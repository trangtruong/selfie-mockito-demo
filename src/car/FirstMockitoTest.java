package car;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class FirstMockitoTest {
	
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testIfCarIsACar() {
		assertTrue(myFerrari instanceof Car);
	}
}
