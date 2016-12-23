import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ScheduleManager extends JFrame implements ActionListener, ListSelectionListener {
	Vector<Schedule> collection = new Vector<Schedule>();
	JFrame scheduleAddFrame;
	JPanel scheduleButtonPanel, scheduleViewPanel, scheduleAddPanel, scheduleAddLabelPanel, scheduleAddTextPanel,
			scheduleEditPanel, scheduleAddButtonPanel;
	JButton scheduleAddButton, scheduleRemoveButton, scheduleAllRemoveButton, scheduleAddFrameButton;
	JLabel scheduleViewLabel, scheduleAddDate, scheduleAddDescription;
	JTextField scheduleAddDateTxt, scheduleAddDescriptionTxt;
	DefaultListModel scheduleListModel;
	JList scheduleList;

	BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("scheduleFile.txt", true));
	BufferedReader fileReader2 = new BufferedReader(new FileReader("scheduleFile.txt"));

	public ScheduleManager() throws IOException {
		printScheduleList();
		setupFrame();
	}

	public static void main(String[] args) throws IOException {
		new ScheduleManager();
	}

	public void setupFrame() {
		setTitle("스케줄 창");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		add(scheduleButtonPanel, BorderLayout.NORTH);
		add(scheduleViewPanel);
	}

	public void AddscheduleFrame() {
		scheduleAddFrame = new JFrame("스케줄 추가 창");
		scheduleAddFrame.setVisible(true);
		scheduleAddFrame.setSize(300, 350);
		scheduleAddFrame.setResizable(false);

		scheduleAddPanel = new JPanel();
		scheduleAddPanel.setLayout(new BorderLayout());
		scheduleAddPanel.setPreferredSize(new Dimension(300, 350));

		scheduleEditPanel = new JPanel();
		scheduleEditPanel.setPreferredSize(new Dimension(300, 200));

		scheduleAddLabelPanel = new JPanel();
		scheduleAddDate = new JLabel("날짜 (yyyy-mm-dd)");
		scheduleAddDescription = new JLabel("세부 스케줄 입력");
		scheduleAddLabelPanel.add(scheduleAddDate);
		scheduleAddLabelPanel.add(scheduleAddDescription);
		scheduleAddLabelPanel.setLayout(new GridLayout(0, 1));
		scheduleEditPanel.add(scheduleAddLabelPanel);

		scheduleAddTextPanel = new JPanel();
		scheduleAddDateTxt = new JTextField(15);
		scheduleAddDescriptionTxt = new JTextField(15);
		scheduleAddTextPanel.add(scheduleAddDateTxt);
		scheduleAddTextPanel.add(scheduleAddDescriptionTxt);
		scheduleAddTextPanel.setLayout(new GridLayout(0, 1));
		scheduleEditPanel.add(scheduleAddTextPanel);

		scheduleAddButtonPanel = new JPanel();
		scheduleAddFrameButton = new JButton("추가");
		scheduleAddButtonPanel.add(scheduleAddFrameButton);
		scheduleAddFrameButton.addActionListener(this);

		scheduleAddPanel.add(scheduleEditPanel, BorderLayout.NORTH);
		scheduleAddPanel.add(scheduleAddButtonPanel);
		scheduleAddFrame.add(scheduleAddPanel);
	}

	public void printScheduleList() throws IOException {
		scheduleButtonPanel = new JPanel();
		scheduleButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		scheduleButtonPanel.setPreferredSize(new Dimension(530, 50));

		scheduleAddButton = new JButton("추가");
		scheduleRemoveButton = new JButton("삭제");
		scheduleAllRemoveButton = new JButton("전체삭제");
		scheduleButtonPanel.add(scheduleAddButton);
		scheduleButtonPanel.add(scheduleRemoveButton);
		scheduleButtonPanel.add(scheduleAllRemoveButton);

		scheduleAddButton.addActionListener(this);
		scheduleRemoveButton.addActionListener(this);
		scheduleAllRemoveButton.addActionListener(this);

		scheduleViewPanel = new JPanel();
		scheduleViewPanel.setPreferredSize(new Dimension(530, 550));
		scheduleViewPanel.setBorder(BorderFactory.createTitledBorder("스케줄"));
		scheduleViewPanel.setLayout(new BorderLayout());
		scheduleListModel = new DefaultListModel();
		readData();
		scheduleList = new JList(scheduleListModel);
		scheduleList.addListSelectionListener(this);
		scheduleViewPanel.add(scheduleList);
	}

	public void readData() {
		try {
			String s;
			while ((s = fileReader2.readLine()) != null) {
				scheduleListModel.addElement(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String writeData(String a, String b, String c, String d) {
		String s = null;
		try {
			fileWriter2.write("[");
			fileWriter2.write(b);
			fileWriter2.write("]  ");
			fileWriter2.write(d);
			fileWriter2.newLine();
			fileWriter2.flush();
			s = fileReader2.readLine();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return s;
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == scheduleAddButton) {
			AddscheduleFrame();
		}

		else if (source == scheduleRemoveButton) {
			int indexElement = scheduleList.getSelectedIndex();

			try {
				fileWriter2 = new BufferedWriter(new FileWriter("scheduleFile.txt"));
				for (int i = 0; i < scheduleListModel.size(); i++) {
					if (indexElement != i) {
						fileWriter2.write(scheduleListModel.elementAt(i).toString());
						fileWriter2.newLine();
					} else
						;
				}
				scheduleListModel.removeElementAt(indexElement);
				fileWriter2.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		else if (source == scheduleAddFrameButton) {
			Schedule ObjectSchedule = new Schedule(scheduleAddDateTxt.getText(), scheduleAddDescriptionTxt.getText());
			collection.addElement(ObjectSchedule);
			scheduleListModel.addElement("(new) [" + scheduleAddDateTxt.getText() + "]  " + scheduleAddDescriptionTxt.getText());
			writeData("[", scheduleAddDateTxt.getText(), "]  ", scheduleAddDescriptionTxt.getText());
			scheduleAddFrame.dispose();
		}

		else if (source == scheduleAllRemoveButton) {
			try {
				fileWriter2 = new BufferedWriter(new FileWriter("scheduleFile.txt"));
				scheduleListModel.removeAllElements();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}
