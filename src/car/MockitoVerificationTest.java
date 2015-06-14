package car;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;


public class MockitoVerificationTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testVerification() {
		myFerrari.needsFuel();
		myFerrari.driveTo("Sweet home Alabama");
		
		verify(myFerrari).driveTo("Sweet home Alabama");
		verify(myFerrari).needsFuel();
	}
}
