import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AccountManager extends JFrame implements ActionListener{
	
	JFrame modifyframe;
	JPanel modifyAccoutPanel;
	JLabel modifyIdlabel, modifyPasswordLabel, checkPasswordLabel, line, line2, line3;
    TextField modifyId, modifyPassword, checkPassword;
    JButton okButton, idOkButton, passwordOkButton;
    
    ReferenceAccount ReferenceAccount  = new ReferenceAccount();
 
	public AccountManager() throws IOException {
		AccountManageFrame();
		setupFrame();
	}
	
	public void AccountManageFrame() {
		modifyAccoutPanel = new JPanel();
		modifyIdlabel = new JLabel("new USERNAME:");
		modifyPasswordLabel = new JLabel("new PASSWORD:");
		checkPasswordLabel = new JLabel("check PASSWORD:");
		line = new JLabel("-------------------------------------");
		line2 = new JLabel("------------------------------------");
		line3 = new JLabel("------------------------------------");
		modifyId = new TextField(10);
		modifyPassword = new TextField(10);
		checkPassword = new TextField(10);
		modifyPassword.setEchoChar('*');
		checkPassword.setEchoChar('*');
		okButton = new JButton("ok");
		idOkButton = new JButton("modify username");
		passwordOkButton = new JButton("modify password");
		
		modifyAccoutPanel.add(line);
		modifyAccoutPanel.add(modifyIdlabel);
		modifyAccoutPanel.add(modifyId);
		modifyAccoutPanel.add(idOkButton);
		modifyAccoutPanel.add(line2);
		modifyAccoutPanel.add(modifyPasswordLabel);
		modifyAccoutPanel.add(modifyPassword);
		modifyAccoutPanel.add(checkPasswordLabel);
		modifyAccoutPanel.add(checkPassword);
		modifyAccoutPanel.add(passwordOkButton);
		modifyAccoutPanel.add(line3);
		modifyAccoutPanel.add(okButton);
		setLayout(new GridLayout());
		
		okButton.addActionListener(this);
		idOkButton.addActionListener(this);
		passwordOkButton.addActionListener(this);
	}
	
	public void setupFrame() {
		setTitle("modify account");
		setSize(200, 370);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		add(modifyAccoutPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
        
		if (source == okButton) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dispose();
		}
		
		else if (source == idOkButton) {
			String newid1 = modifyId.getText();
			String oldid1 = ReferenceAccount.username;
			
			idchange(newid1, oldid1);
		}
		
		else if (source == passwordOkButton) {
	        String newpassword1 = modifyPassword.getText();
	        String confirmpassword1 =  checkPassword.getText();
	        
	        passwordchange(newpassword1, confirmpassword1);
		}
	}
	
	public int idchange(String newid1, String oldid1){
        String newid = newid1;
        String oldid = oldid1;
        
		if (newid.equals(oldid)) {
			JOptionPane.showMessageDialog(null, "the previous ID and a new ID are same.");
			return 3;
		}
			
		else{
			BufferedWriter fileWriter;
			try {
				fileWriter = new BufferedWriter(new FileWriter("account.txt"));
				fileWriter.write(newid);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
			JOptionPane.showMessageDialog(null, "ID has changed.");
			return 4;
		}
	}
	
	public String passwordchange(String newpassword1, String confirmpassword1) {
        String newpassword = newpassword1;
        String confirmpassword = confirmpassword1;
        
		if(!newpassword.equals(confirmpassword)) {
			JOptionPane.showMessageDialog(null, "The two entered password is different.");
			return "success";
		}
		
		else {
			BufferedWriter passfileWriter;
			BufferedReader passfileReader;
	        String s = null;
	        
			try {
				passfileWriter = new BufferedWriter(new FileWriter("passaccount.txt"));
				passfileWriter.write(newpassword);
				passfileReader = new BufferedReader(new FileReader("passaccount.txt"));
				
				passfileWriter.flush();
				s = passfileReader.readLine();
				//passfileWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}				
			JOptionPane.showMessageDialog(null, "password has changed.");
			return s;
		}
	}
}
