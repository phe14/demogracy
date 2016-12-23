import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class AccountManagerTest {

	@Test
	public void testPasswordNotSame() throws IOException {
		AccountManager AccountManager = new AccountManager();
		String result = AccountManager.passwordchange("111", "222");
		assertEquals("success",result);
		System.out.println("success test 1");
	}
}
