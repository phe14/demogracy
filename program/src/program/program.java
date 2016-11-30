package program;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class program extends JFrame{
	
	JPanel accountPanel, phonebookPanel, schedulePanel;
	
	public program(){
	
	//계정관리 패널(로그아웃, id/pw변경)
	accountPanel = new JPanel();
	accountPanel.setPreferredSize(new Dimension(1100,100));
	
	//전화번호부 관리 패널(전화번호 추가,삭제)
	phonebookPanel = new JPanel();
	phonebookPanel.setPreferredSize(new Dimension(540,500));
	phonebookPanel.setBorder(BorderFactory.createTitledBorder("phonebook"));
	
	//스케줄 관리 패널(스케줄 추가,삭제)
	schedulePanel = new JPanel();
	schedulePanel.setPreferredSize(new Dimension(540,500));
	schedulePanel.setBorder(BorderFactory.createTitledBorder("schedule"));
	
	//프레임에 패널 추가
	add(accountPanel, BorderLayout.NORTH);
	add(phonebookPanel, BorderLayout.WEST);
	add(schedulePanel, BorderLayout.EAST);
	
	//프레임 기본 설정
	setTitle("program");
	setSize(1100, 800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	setVisible(true);
	setResizable(false);
	
	}
	
	public static void main(String[] args) {
		new program();

	}

}
