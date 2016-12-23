import java.io.*;

public class ReferenceAccount {
	
	String username;
	String userpassword;
	File idfile = new File("c:\\account.txt");
	File passwordfile = new File("c:\\passaccount.txt");
	
	public ReferenceAccount(){
		BufferedReader idReader = null;
		try {
			idReader = new BufferedReader(new FileReader(idfile));
			
			String s;
			while ((s = idReader.readLine()) != null){
				username = s;
			}
			
		}catch (IOException e1) {
	         e1.printStackTrace();
		}
		
		BufferedReader passReader = null;
		try {
			passReader = new BufferedReader(new FileReader(passwordfile));
			
			String i;
			while ((i = passReader.readLine()) != null){
				userpassword = i;
			}
		}catch (IOException e2) {
	         e2.printStackTrace();
		}
	}
}