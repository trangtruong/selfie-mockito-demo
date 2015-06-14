package car;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoReturningDesiredValuesTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testStubbing() {
		assertFalse("new test double should return false as boolean", myFerrari.needsFuel());

		when(myFerrari.needsFuel()).thenReturn(true);

		assertTrue("new test double should return false as boolean", myFerrari.needsFuel());
	}
}
