package car;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;


public class MockitoFailedVerificationArgumentsTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testVerificationFailure() {
		myFerrari.driveTo("Sweet home Alabama");
		
		verify(myFerrari).driveTo("Sweet home Honolulu");
	}
}
