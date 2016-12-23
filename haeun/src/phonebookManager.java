import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class phonebookManager extends Program {
	Vector<phonebook> collection = new Vector<phonebook>();
	JFrame phonebookAddFrame;
	JPanel phonebookAddPanel, phonebookAddLabelPanel, phonebookAddTextPanel, phonebookEditPanel,
			phonebookAddButtonPanel;
	JButton phonebookAddFrameButton;
	JLabel phonebookViewLabel, phonebookAddName, phonebookAddPhonenumber;
	JTextField phonebookAddNameTxt, phonebookAddPhonenumberTxt;
	DefaultListModel phonebookListModel;
	JList phonebookList;
	phonebook ObjectPhonebook;

	BufferedWriter fileWriter = new BufferedWriter(new FileWriter("phonebook.txt", true));
	BufferedReader fileReader = new BufferedReader(new FileReader("phonebook.txt"));

	public phonebookManager() throws IOException {
		printPhonebookList();
	}

	public static void main(String[] args) throws IOException {
		new phonebookManager();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == phonebookAddButton) {
			AddphonebookFrame();
		}

		else if (source == phonebookRemoveButton) {
			int n = phonebookList.getSelectedIndex();
			try {
				fileWriter = new BufferedWriter(new FileWriter("phonebook.txt"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			removeData();
			phonebookListModel.removeElementAt(n);
		}

		else if (source == phonebookAddFrameButton) {
			generateNewObject();
			phonebookListModel.addElement(phonebookAddNameTxt.getText() + phonebookAddPhonenumberTxt.getText());
			writeData();
			phonebookAddFrame.dispose();
		}

		else if (source == phonebookAllRemoveButton) {
			try {
				fileWriter = new BufferedWriter(new FileWriter("phonebook.txt"));
				removeAllData();
				phonebookListModel.removeAllElements();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void generateNewObject() {
		ObjectPhonebook = new phonebook(phonebookAddNameTxt.getText(), phonebookAddPhonenumberTxt.getText());
		collection.addElement(ObjectPhonebook);
	}

	public void AddphonebookFrame() {
		phonebookAddFrame = new JFrame("전화번호부 추가 창");
		phonebookAddFrame.setVisible(true);
		phonebookAddFrame.setSize(300, 350);
		phonebookAddFrame.setResizable(false);
		phonebookAddPanel = new JPanel();
		phonebookAddPanel.setLayout(new BorderLayout());
		phonebookAddPanel.setPreferredSize(new Dimension(300, 350));

		phonebookEditPanel = new JPanel();
		phonebookEditPanel.setPreferredSize(new Dimension(300, 200));

		phonebookAddLabelPanel = new JPanel();
		phonebookAddName = new JLabel("이름");
		phonebookAddPhonenumber = new JLabel("전화번호");
		phonebookAddLabelPanel.add(phonebookAddName);
		phonebookAddLabelPanel.add(phonebookAddPhonenumber);
		phonebookAddLabelPanel.setLayout(new GridLayout(0, 1));
		phonebookEditPanel.add(phonebookAddLabelPanel);

		phonebookAddTextPanel = new JPanel();
		phonebookAddNameTxt = new JTextField(15);
		phonebookAddPhonenumberTxt = new JTextField(15);
		phonebookAddTextPanel.add(phonebookAddNameTxt);
		phonebookAddTextPanel.add(phonebookAddPhonenumberTxt);
		phonebookAddTextPanel.setLayout(new GridLayout(0, 1));
		phonebookEditPanel.add(phonebookAddTextPanel);

		phonebookAddButtonPanel = new JPanel();
		phonebookAddFrameButton = new JButton("추가");
		phonebookAddButtonPanel.add(phonebookAddFrameButton);
		phonebookAddFrameButton.addActionListener(this);

		phonebookAddPanel.add(phonebookEditPanel, BorderLayout.NORTH);
		phonebookAddPanel.add(phonebookAddButtonPanel);
		phonebookAddFrame.add(phonebookAddPanel);
	}

	public void printPhonebookList() throws IOException {
		phonebookViewPanel = new JPanel();
		phonebookViewPanel.setPreferredSize(new Dimension(530, 550));
		phonebookViewPanel.setBorder(BorderFactory.createTitledBorder("전화번호부"));
		phonebookViewPanel.setLayout(new BorderLayout());

		phonebookListModel = new DefaultListModel();
		readDataAndAddToList();
		phonebookList = new JList(phonebookListModel);
		phonebookList.addListSelectionListener(this);
		phonebookViewPanel.add(phonebookList);
		phonebookPanel.add(phonebookViewPanel, BorderLayout.NORTH);
	}

	public void readDataAndAddToList() {
		try {
			String s;
			while ((s = fileReader.readLine()) != null) {
				phonebookListModel.addElement(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeData() {
		try {
			fileWriter.write(phonebookAddNameTxt.getText());
			fileWriter.write(phonebookAddPhonenumberTxt.getText());
			fileWriter.newLine();
			fileWriter.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void removeData() {
		int n = phonebookList.getSelectedIndex();
		
		try {
			for (int i = 0; i < phonebookListModel.size(); i++) {
				if (n != i) {
					fileWriter.write(phonebookListModel.elementAt(i).toString());
					fileWriter.newLine();
				} 
				else
					;
			}		
		}catch (IOException e1) {
					e1.printStackTrace();
				}
	}

	public void removeAllData() {
		try {
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}