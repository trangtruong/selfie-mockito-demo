package car;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;


public class MockitoDefaultValuesTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testDefaultBehaviourOfTestDouble() {
		assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
		assertEquals("new test double should return 0.0 as double", 0.0, myFerrari.getEngineTemparature());
		
	}
}
