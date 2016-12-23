import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Account extends JFrame implements ActionListener {
	JPanel loginPanel, emptyPanel;
	JLabel idlabel;
    JLabel passwordlabel;
    TextField inputid;
    TextField inputpassword;
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
		passwordlabel = new JLabel("PASSWORD:");
		loginok = new JButton("login");
		inputid = new TextField(10);
		inputpassword = new TextField(10);
		inputpassword.setEchoChar('*');
		
		loginPanel.add(idlabel); 
		loginPanel.add(inputid); 
		loginPanel.add(passwordlabel);
		loginPanel.add(inputpassword); 
		loginPanel.add(loginok);
		add(emptyPanel, BorderLayout.NORTH);
		add(loginPanel, BorderLayout.CENTER);
		setLayout(new FlowLayout());
		
		loginok.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {		
        String id =  inputid.getText();
        String password = inputpassword.getText();
        
        ReferenceAccount ReferenceAccount  = new ReferenceAccount();

		if (id.equals(ReferenceAccount.username) && password.equals(ReferenceAccount.userpassword)){
        	JOptionPane.showMessageDialog(null, "Success!");
				try {
					new Program();
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        }
		
		else if(!id.equals(ReferenceAccount.username) && password.equals(ReferenceAccount.userpassword)){
        	JOptionPane.showMessageDialog(null, "id doesn't match.");
        }
		
        else if(!password.equals(ReferenceAccount.userpassword) && id.equals(ReferenceAccount.userpassword)){
        	JOptionPane.showMessageDialog(null, "Password doesn't match.");
        }
		
        else if(!id.equals(ReferenceAccount.username) && !password.equals(ReferenceAccount.userpassword)){
        	JOptionPane.showMessageDialog(null, "try again.");
        }
	}
	
	public static void main(String[] args) {
		new Account();
	}
}
