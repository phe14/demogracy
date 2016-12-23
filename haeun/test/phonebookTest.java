import static org.junit.Assert.*;
import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import org.junit.Test;

public class phonebookTest {
	
	@Test
	public void testToString() {
		Phonebook phonebook = new Phonebook("박하은","010-9521-7917");
		assertEquals("박하은	010-9521-7917",phonebook.toString());
	}

	@Test
	public void testWriteData() {
		try {
			PhonebookManager pm = new PhonebookManager();
			String a = "박하은";
			String b = "010-0000-0000";
			String result = pm.writeData(a,b);
			assertEquals(result,a+b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
