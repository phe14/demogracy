import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

public class Program extends JFrame implements ActionListener, ListSelectionListener {
	JFrame phonebookAddFrame, ScheduleAddFrame;
	JPanel accountPanel, phonebookPanel, phonebookButtonPanel, phonebookViewPanel,
			schedulePanel, scheduleButtonPanel, scheduleViewPanel;
	JButton phonebookAddButton, phonebookAllRemoveButton, phonebookRemoveButton,
			scheduleAddButton, scheduleAllRemoveButton, scheduleRemoveButton;

	public Program() throws IOException {
		setupAccountFrame();
		setupPhonebookFrame();
		setupScheduleFrame();
		setupFrame();
	}

	public void setupAccountFrame() {
		accountPanel = new JPanel();
		accountPanel.setPreferredSize(new Dimension(1100, 100));
	}

	public void setupPhonebookFrame() {
		phonebookPanel = new JPanel();
		phonebookPanel.setPreferredSize(new Dimension(540, 500));
		phonebookPanel.setBorder(BorderFactory.createTitledBorder("phonebook"));

		phonebookButtonPanel = new JPanel();
		phonebookButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		phonebookButtonPanel.setPreferredSize(new Dimension(530, 50));

		phonebookAddButton = new JButton("추가");
		phonebookRemoveButton = new JButton("삭제");
		phonebookAllRemoveButton = new JButton("전체삭제");
		phonebookButtonPanel.add(phonebookAddButton);
		phonebookButtonPanel.add(phonebookRemoveButton);
		phonebookButtonPanel.add(phonebookAllRemoveButton);
		phonebookPanel.add(phonebookButtonPanel, BorderLayout.NORTH);

		phonebookAddButton.addActionListener(this);
		phonebookRemoveButton.addActionListener(this);
		phonebookAllRemoveButton.addActionListener(this);
	}

	public void setupScheduleFrame() {
		schedulePanel = new JPanel();
		schedulePanel.setPreferredSize(new Dimension(540, 500));
		schedulePanel.setBorder(BorderFactory.createTitledBorder("schedule"));

		scheduleButtonPanel = new JPanel();
		scheduleButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		scheduleButtonPanel.setPreferredSize(new Dimension(530, 50));

		scheduleAddButton = new JButton("추가");
		scheduleRemoveButton = new JButton("삭제");
		scheduleAllRemoveButton = new JButton("전체삭제");
		scheduleButtonPanel.add(scheduleAddButton);
		scheduleButtonPanel.add(scheduleRemoveButton);
		scheduleButtonPanel.add(scheduleAllRemoveButton);
		schedulePanel.add(scheduleButtonPanel, BorderLayout.NORTH);

		scheduleAddButton.addActionListener(this);
		scheduleRemoveButton.addActionListener(this);
		scheduleAllRemoveButton.addActionListener(this);
	}

	public void setupFrame() {
		setTitle("program");
		setSize(1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		add(accountPanel, BorderLayout.NORTH);
		add(phonebookPanel, BorderLayout.WEST);
		add(schedulePanel, BorderLayout.EAST);
	}

	public static void main(String[] args) throws IOException {
		new Program();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}