import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

public class Program extends JFrame implements ActionListener, ListSelectionListener {
	JFrame phonebookAddFrame;
	JPanel accountPanel, phonebookPanel, schedulePanel, phonebookButtonPanel, phonebookViewPanel;
	JButton phonebookAddButton, phonebookAllRemoveButton, phonebookRemoveButton;

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

		// 異붽�, �쟾泥댁궘�젣 踰꾪듉 �뙣�꼸
		phonebookButtonPanel = new JPanel();
		phonebookButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		phonebookButtonPanel.setPreferredSize(new Dimension(530, 50));

		phonebookAddButton = new JButton("異붽�");
		phonebookRemoveButton = new JButton("�궘�젣");
		phonebookAllRemoveButton = new JButton("�쟾泥댁궘�젣");
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
