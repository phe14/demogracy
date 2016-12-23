import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class AccountManagerIDTest {

	@Test
	public void testIdSame() throws IOException {
		AccountManager AccountManager = new AccountManager();
		int result =  (int)AccountManager.idchange("111", "111");
		assertEquals(3,result);
		System.out.println("success test 2");
	}
	
}
