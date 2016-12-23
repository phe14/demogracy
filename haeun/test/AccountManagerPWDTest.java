import org.junit.*;
import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
	
public class AccountManagerPWDTest {
	@Test
	public void testPasswordchange() {
		BufferedWriter passfileWriter;
		
		try {
			AccountManager am = new AccountManager();
			
			String newpwd = "newone";
			String conpwd = "newone";
			String result = am.passwordchange(newpwd,conpwd);
	
			assertEquals(result, newpwd);
			System.out.println(result);
			} catch (IOException e1) {
				e1.printStackTrace();
				}
		}						
}
