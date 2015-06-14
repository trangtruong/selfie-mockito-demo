package car;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;


public class MockitoFailedVerificationTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testVerificationFailure() {
		myFerrari.needsFuel();
		
		verify(myFerrari).getEngineTemparature();
	}
}
