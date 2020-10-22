import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;




class DriverTest {


	@Test
	void testCallMenuObj() {
		ByteArrayInputStream in = new ByteArrayInputStream("b".getBytes());
		System.setIn(in);
		
      try {
			Driver.callMenuObj("3");
		} catch (ClassNotFoundException | IOException e) {
			assertTrue(false);
		}

		assertTrue(true);
		

	}
}



