import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class ScheduleTest {
	@Test
	public void testWriteData() {
		try {
			ScheduleManager sm = new ScheduleManager();
			
			String a = "2016-12-25";
			String b = "Christmas";
			String result = sm.writeData("[",a,"]  ",b);
			
			System.out.println(result);
			assertEquals(result,"["+a+"]  "+b);
			} catch (IOException exception) {
				exception.printStackTrace();
				}
		}
	}