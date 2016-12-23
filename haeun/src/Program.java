import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

public class Program extends JFrame implements ActionListener, ListSelectionListener {
	JFrame phonebookAddFrame, ScheduleAddFrame;
	JPanel buttonPanel, accountPanel, phonebookPanel, phonebookButtonPanel, phonebookViewPanel,
			schedulePanel, scheduleButtonPanel, scheduleViewPanel;
	JButton phonebookAddButton, phonebookAllRemoveButton, phonebookRemoveButton,
			scheduleAddButton, scheduleAllRemoveButton, scheduleRemoveButton,
			accountModifyButton , logoutButton, phonebookShowButton, scheduleShowButton,
			phonebookBackButton;

	public Program() throws IOException {
		setupButtonFrame();
		setupFrame();
	}

	public void setupButtonFrame() {
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(300, 200));
		logoutButton = new JButton("LOGOUT");
		accountModifyButton = new JButton ("ACCOUNT MODIFY");
		buttonPanel.add(accountModifyButton);
		buttonPanel.add(logoutButton);
		phonebookShowButton = new JButton("PHONEBOOK");
		buttonPanel.add(phonebookShowButton);
		scheduleShowButton = new JButton("SCHEDULE");
		buttonPanel.add(scheduleShowButton);
		
		accountModifyButton.addActionListener(this);
		logoutButton.addActionListener(this);
		phonebookShowButton.addActionListener(this);
		scheduleShowButton.addActionListener(this);
	}

	public void setupFrame() {
		setTitle("program");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		add(buttonPanel, BorderLayout.NORTH);
	}

	public static void main(String[] args) throws IOException {
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == accountModifyButton) {
			try {
				new AccountManager();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		else if (source == logoutButton) {
			new Account();
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dispose();
		}
		
		else if (source == phonebookShowButton) {
			try {
				new PhonebookManager();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		else if (source == scheduleShowButton) {
			try {
				new ScheduleManager();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
