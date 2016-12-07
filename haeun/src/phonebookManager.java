import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class phonebookManager extends Program {
	Vector<phonebook> collection = new Vector<phonebook>();
	JFrame phonebookAddFrame;
	JPanel phonebookAddPanel, phonebookAddLabelPanel, phonebookAddTextPanel, phonebookEditPanel, phonebookAddButtonPanel;
	JButton phonebookAddFrameButton;
	JLabel phonebookViewLabel, phonebookAddName, phonebookAddPhonenumber;
	JTextField phonebookAddNameTxt, phonebookAddPhonenumberTxt;
	DefaultListModel phonebookListModel;
	JList phonebookList;

	BufferedWriter fileWriter = new BufferedWriter(new FileWriter("save.txt", true));
	BufferedReader fileReader = new BufferedReader(new FileReader("save.txt"));

	public phonebookManager() throws IOException {
		printPhonebookList();
	}
	
	public static void main(String[] args) throws IOException {
		new phonebookManager();
	}
	
	public void Addphonebook() {
		phonebookAddFrame = new JFrame("�쟾�솕踰덊샇遺� 異붽� 李�");
		phonebookAddFrame.setVisible(true);
		phonebookAddFrame.setSize(300, 350);
		phonebookAddFrame.setResizable(false);

		// �쟾�솕踰덊샇遺� 異붽� �쟾泥� �뙣�꼸
		phonebookAddPanel = new JPanel();
		phonebookAddPanel.setLayout(new BorderLayout());
		phonebookAddPanel.setPreferredSize(new Dimension(300, 350));

		// �쟾�솕踰덊샇遺� 異붽� �씪踰�,�뀓�뒪�듃 �뙣�꼸
		phonebookEditPanel = new JPanel();
		phonebookEditPanel.setPreferredSize(new Dimension(300, 200));

		// �쟾�솕踰덊샇遺� 異붽� �씪踰� �뙣�꼸
		phonebookAddLabelPanel = new JPanel();
		phonebookAddName = new JLabel("�씠由�");
		phonebookAddPhonenumber = new JLabel("�쟾�솕踰덊샇");
		phonebookAddLabelPanel.add(phonebookAddName);
		phonebookAddLabelPanel.add(phonebookAddPhonenumber);
		phonebookAddLabelPanel.setLayout(new GridLayout(0, 1));
		phonebookEditPanel.add(phonebookAddLabelPanel);

		// �쟾�솕踰덊샇遺� 異붽� �뀓�뒪�듃 �뙣�꼸
		phonebookAddTextPanel = new JPanel();
		phonebookAddNameTxt = new JTextField(15);
		phonebookAddPhonenumberTxt = new JTextField(15);
		phonebookAddTextPanel.add(phonebookAddNameTxt);
		phonebookAddTextPanel.add(phonebookAddPhonenumberTxt);
		phonebookAddTextPanel.setLayout(new GridLayout(0, 1));
		phonebookEditPanel.add(phonebookAddTextPanel);

		// �쟾�솕踰덊샇遺� 異붽� 踰꾪듉
		phonebookAddButtonPanel = new JPanel();
		phonebookAddFrameButton = new JButton("異붽�");
		phonebookAddButtonPanel.add(phonebookAddFrameButton);
		phonebookAddFrameButton.addActionListener(this);

		// �봽�젅�엫�뿉 �뙣�꼸 異붽�
		phonebookAddPanel.add(phonebookEditPanel, BorderLayout.NORTH);
		phonebookAddPanel.add(phonebookAddButtonPanel);

		phonebookAddFrame.add(phonebookAddPanel);
	}

	public void printPhonebookList() throws IOException {
		// �쟾�솕踰덊샇遺� 紐⑸줉 異쒕젰
		phonebookViewPanel = new JPanel();
		phonebookViewPanel.setPreferredSize(new Dimension(530, 550));
		phonebookViewPanel.setBorder(BorderFactory.createTitledBorder("�쟾�솕踰덊샇遺�"));
		phonebookViewPanel.setLayout(new BorderLayout());

		////// 硫붾え�옣�뿉�꽌 �씫湲�////////////
		try {
			phonebookListModel = new DefaultListModel();

			String s;
			while ((s = fileReader.readLine()) != null) {
				phonebookListModel.addElement(s);
			}
			phonebookList = new JList(phonebookListModel);
			phonebookList.addListSelectionListener(this);
			phonebookViewPanel.add(phonebookList);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		phonebookPanel.add(phonebookViewPanel, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		// �쟾�솕踰덊샇遺� �긽�떒�뿉 異붽�踰꾪듉�쓣 �늻瑜몃떎硫� �깉 李쎌씠 �쑍�떎.
		if (source == phonebookAddButton) {
			Addphonebook();
		}

		else if (source == phonebookRemoveButton) {
			int n = phonebookList.getSelectedIndex();
			phonebookListModel.removeElementAt(n); // 由ъ뒪�듃�뿉�꽌 index n�쓣 �궘�젣

			/////// 硫붾え�옣 �뾽�뜲�씠�듃/////

		}

		else if (source == phonebookAddFrameButton) {
			phonebook ObjectPhonebook = new phonebook(phonebookAddNameTxt.getText(),phonebookAddPhonenumberTxt.getText());
			collection.addElement(ObjectPhonebook); // s瑜� collection�뿉 異붽�
			phonebookListModel.addElement(phonebookAddNameTxt.getText() + phonebookAddPhonenumberTxt.getText());// list�뿉
																										// �씠由꾩텛媛�

			///// 硫붾え�옣�뿉 ���옣///////
			try {
				fileWriter.write(phonebookAddNameTxt.getText());
				fileWriter.write(phonebookAddPhonenumberTxt.getText());
				fileWriter.newLine();
				fileWriter.flush();
				fileWriter.close();

			} 
			
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			phonebookAddFrame.dispose();
		}

		else if (source == phonebookAllRemoveButton) {
			phonebookListModel.removeAllElements();
		}
	}
}
