import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Program extends JFrame{
	
	JPanel accountPanel, phonebookPanel, schedulePanel;
	
	public Program(){
	
	//�������� �г�(�α׾ƿ�, id/pw����)
	accountPanel = new JPanel();
	accountPanel.setPreferredSize(new Dimension(1100,100));
	
	//��ȭ��ȣ�� ���� �г�(��ȭ��ȣ �߰�,����)
	phonebookPanel = new JPanel();
	phonebookPanel.setPreferredSize(new Dimension(540,500));
	phonebookPanel.setBorder(BorderFactory.createTitledBorder("phonebook"));
	
	//������ ���� �г�(������ �߰�,����)
	schedulePanel = new JPanel();
	schedulePanel.setPreferredSize(new Dimension(540,500));
	schedulePanel.setBorder(BorderFactory.createTitledBorder("schedule"));
	
	//�����ӿ� �г� �߰�
	add(accountPanel, BorderLayout.NORTH);
	add(phonebookPanel, BorderLayout.WEST);
	add(schedulePanel, BorderLayout.EAST);
	
	//������ �⺻ ����
	setTitle("program");
	setSize(1100, 800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	setVisible(true);
	setResizable(false);
	
	}
	
	public static void main(String[] args) {
		new Program();
	}

}

