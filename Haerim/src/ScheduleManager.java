import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class ScheduleManager extends Program {
	
	Vector<Schedule> collection = new Vector<Schedule>();
	JFrame scheduleAddFrame;
	JPanel scheduleAddPanel, scheduleAddLabelPanel, scheduleAddTextPanel, scheduleEditPanel, scheduleAddButtonPanel;
	JButton scheduleAddFrameButton;
	JLabel scheduleViewLabel, scheduleAddDate, scheduleAddscheduleDescription;
	JTextField scheduleAddDateTxt, scheduleAddscheduleDescriptionTxt;
	DefaultListModel scheduleListModel;
	JList scheduleList;

	BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("scheduleFile.txt", true));
	BufferedReader fileReader2 = new BufferedReader(new FileReader("scheduleFile.txt"));

	public ScheduleManager() throws IOException {
		printScheduleList();
	}
	
	public static void main(String[] args) throws IOException {
		new ScheduleManager();
	}
	
	public void Addschedule() {
		ScheduleAddFrame = new JFrame("스케줄 추가 창");
		ScheduleAddFrame.setVisible(true);
		ScheduleAddFrame.setSize(300, 350);
		ScheduleAddFrame.setResizable(false);

		// 스케줄 추가 전체 패널
		scheduleAddPanel = new JPanel();
		scheduleAddPanel.setLayout(new BorderLayout());
		scheduleAddPanel.setPreferredSize(new Dimension(300, 350));

		// 스케줄 추가 라벨,텍스트 패널
		scheduleEditPanel = new JPanel();
		scheduleEditPanel.setPreferredSize(new Dimension(300, 200));

		// 스케줄 추가 라벨 패널
		scheduleAddLabelPanel = new JPanel();
		scheduleAddDate = new JLabel("날짜");
		scheduleAddscheduleDescription = new JLabel("내용");
		scheduleAddLabelPanel.add(scheduleAddDate);
		scheduleAddLabelPanel.add(scheduleAddscheduleDescription);
		scheduleAddLabelPanel.setLayout(new GridLayout(0, 1));
		scheduleEditPanel.add(scheduleAddLabelPanel);

		// 스케줄 추가 텍스트 패널
		scheduleAddTextPanel = new JPanel();
		scheduleAddDateTxt = new JTextField(15);
		scheduleAddscheduleDescriptionTxt = new JTextField(15);
		scheduleAddTextPanel.add(scheduleAddDateTxt);
		scheduleAddTextPanel.add(scheduleAddscheduleDescriptionTxt);
		scheduleAddTextPanel.setLayout(new GridLayout(0, 1));
		scheduleEditPanel.add(scheduleAddTextPanel);

		// 스케줄 추가 버튼
		scheduleAddButtonPanel = new JPanel();
		scheduleAddFrameButton = new JButton("추가");
		scheduleAddButtonPanel.add(scheduleAddFrameButton);
		scheduleAddFrameButton.addActionListener(this);

		// 프레임에 패널 추가
		scheduleAddPanel.add(scheduleEditPanel, BorderLayout.NORTH);
		scheduleAddPanel.add(scheduleAddButtonPanel);
		scheduleAddFrame.add(scheduleAddPanel);
	}

	public void printScheduleList() throws IOException {
		// 스케줄 목록 출력
		scheduleViewPanel = new JPanel();
		scheduleViewPanel.setPreferredSize(new Dimension(530, 550));
		scheduleViewPanel.setBorder(BorderFactory.createTitledBorder("스케줄"));
		scheduleViewPanel.setLayout(new BorderLayout());

		////// 메모장에서 읽기////////////
		try {
			scheduleListModel = new DefaultListModel();

			String s;
			while ((s = fileReader2.readLine()) != null) {
				scheduleListModel.addElement(s);
			}
			scheduleList = new JList(scheduleListModel);
			scheduleList.addListSelectionListener(this);
			scheduleViewPanel.add(scheduleList);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		schedulePanel.add(scheduleViewPanel, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		// 스케줄 상단에 추가버튼을 누른다면 새 창이 뜬다.
		if (source == scheduleAddButton) {
			Addschedule();
		}

		else if (source == scheduleRemoveButton) {
			int n = scheduleList.getSelectedIndex();
			scheduleListModel.removeElementAt(n); // 리스트에서 index n을 삭제

			/////// 메모장 업데이트/////

		}

		else if (source == scheduleAddFrameButton) {
			Schedule Objectschedule = new Schedule(scheduleAddDateTxt.getText(),scheduleAddscheduleDescriptionTxt.getText());
			collection.addElement(Objectschedule); // s를 collection에 추가
			scheduleListModel.addElement(scheduleAddDateTxt.getText() + scheduleAddscheduleDescriptionTxt.getText());

			///// 메모장에 저장///////
			try {
				fileWriter2.write(scheduleAddDateTxt.getText());
				fileWriter2.write(scheduleAddscheduleDescriptionTxt.getText());
				fileWriter2.newLine();
				fileWriter2.flush();
				fileWriter2.close();

			} 
			
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			scheduleAddFrame.dispose();
		}

		else if (source == scheduleAllRemoveButton) {
			scheduleListModel.removeAllElements();
		}
	}
}
