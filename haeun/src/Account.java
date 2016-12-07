import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

class AccountInfo {
	String username = "min";
	String userpass = "123";
}

public class Account extends JFrame implements ActionListener {
	JPanel loginPanel, emptyPanel;
	JLabel idlabel;
    JLabel passlabel;
    TextField inputid;
    TextField inputpass;
    JButton loginok;
    
	public Account() {
		setTitle("program");
		setSize(1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		setResizable(false);
		
		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(350,100));
		loginPanel.setBorder(BorderFactory.createTitledBorder("LOGIN"));
   		emptyPanel =  new JPanel();
   		emptyPanel.setPreferredSize(new Dimension(1100,280));
		
		idlabel = new JLabel("ID:");
		passlabel = new JLabel("PASSWORD:");
		loginok = new JButton("login");
		inputid = new TextField(10);
		inputpass = new TextField(10);
		inputpass.setEchoChar('*');
		
		loginPanel.add(idlabel); 
		loginPanel.add(inputid); 
		loginPanel.add(passlabel);
		loginPanel.add(inputpass); 
		loginPanel.add(loginok);
		add(emptyPanel, BorderLayout.NORTH);
		add(loginPanel, BorderLayout.CENTER);
		setLayout(new FlowLayout());
		
		loginok.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {		
        String id =  inputid.getText();
        String pass = inputpass.getText();
        
        AccountInfo account  = new AccountInfo();

		if (id.equals(account.username) && pass.equals(account.userpass)){
        	JOptionPane.showMessageDialog(null, "Success!");
        	try {
				new Program();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		else if(!id.equals(account.username)&&account.userpass.equals(pass)){
        	JOptionPane.showMessageDialog(null, "id doesn't match.");
        }
        else if(!pass.equals(account.userpass)&&account.username.equals(id)){
        	JOptionPane.showMessageDialog(null, "Password doesn't match.");
        }
		
        else if(!id.equals(account.username)&&!pass.equals(account.userpass)){
        	JOptionPane.showMessageDialog(null, "try again.");
        }
	}
	
	public static void main(String[] args) {
		new Account();
	}	
}
