import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PhonebookManager extends JFrame implements ActionListener, ListSelectionListener {
	Vector<Phonebook> collection = new Vector<Phonebook>();
	JFrame phonebookAddFrame;
	JPanel phonebookAddPanel, phonebookAddLabelPanel, phonebookAddTextPanel, phonebookEditPanel,
			phonebookAddButtonPanel, phonebookButtonPanel, phonebookViewPanel;
	JButton phonebookAddFrameButton, phonebookAddButton, phonebookAllRemoveButton, phonebookRemoveButton,
			phonebookShowButton, scheduleShowButton, phonebookBackButton;
	JLabel phonebookViewLabel, phonebookAddName, phonebookAddPhonenumber;
	JTextField phonebookAddNameTxt, phonebookAddPhonenumberTxt;
	DefaultListModel phonebookListModel;
	JList phonebookList;
	Phonebook ObjectPhonebook;

	BufferedWriter fileWriter = new BufferedWriter(new FileWriter("phonebook.txt", true));
	BufferedReader fileReader = new BufferedReader(new FileReader("phonebook.txt"));

	public PhonebookManager() throws IOException {
		setupPanelAndPrintList();
		setupFrame();
	}

	public static void main(String[] args) throws IOException {
		new PhonebookManager();
	}

	public void setupFrame() {
		setTitle("전화번호부 창");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		add(phonebookButtonPanel, BorderLayout.NORTH);
		add(phonebookViewPanel);
	}

	public void setupPanelAndPrintList() throws IOException {
		phonebookButtonPanel = new JPanel();
		phonebookButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		phonebookButtonPanel.setPreferredSize(new Dimension(530, 50));

		phonebookAddButton = new JButton("추가");
		phonebookRemoveButton = new JButton("삭제");
		phonebookAllRemoveButton = new JButton("전체삭제");
		phonebookButtonPanel.add(phonebookAddButton);
		phonebookButtonPanel.add(phonebookRemoveButton);
		phonebookButtonPanel.add(phonebookAllRemoveButton);

		phonebookAddButton.addActionListener(this);
		phonebookRemoveButton.addActionListener(this);
		phonebookAllRemoveButton.addActionListener(this);

		phonebookViewPanel = new JPanel();
		phonebookViewPanel.setPreferredSize(new Dimension(530, 550));
		phonebookViewPanel.setBorder(BorderFactory.createTitledBorder("전화번호부"));
		phonebookViewPanel.setLayout(new BorderLayout());

		phonebookListModel = new DefaultListModel();
		readDataAndAddToList();
		phonebookList = new JList(phonebookListModel);
		phonebookList.addListSelectionListener(this);
		phonebookViewPanel.add(phonebookList);
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
				removeData();
				phonebookListModel.removeElementAt(n);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		else if (source == phonebookAddFrameButton) {
			generateNewObject();
			phonebookListModel.addElement(phonebookAddNameTxt.getText() + phonebookAddPhonenumberTxt.getText());
			writeData(phonebookAddNameTxt.getText(), phonebookAddPhonenumberTxt.getText());
			phonebookAddFrame.dispose();
		}

		else if (source == phonebookAllRemoveButton) {
			try {
				fileWriter = new BufferedWriter(new FileWriter("phonebook.txt"));
				phonebookListModel.removeAllElements();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void generateNewObject() {
		ObjectPhonebook = new Phonebook(phonebookAddNameTxt.getText(), phonebookAddPhonenumberTxt.getText());
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

	public String writeData(String a, String b) {
		String s = null;
		try {
			fileWriter.write(a);
			fileWriter.write(b);
			fileWriter.newLine();
			fileWriter.flush();
			s = fileReader.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public void removeData() {
		int n = phonebookList.getSelectedIndex();

		try {
			for (int i = 0; i < phonebookListModel.size(); i++) {
				if (n != i) {
					fileWriter.write(phonebookListModel.elementAt(i).toString());
					fileWriter.newLine();
				} else
					;
			}
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}