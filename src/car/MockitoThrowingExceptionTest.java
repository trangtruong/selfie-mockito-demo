package car;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoThrowingExceptionTest {
	Car myFerrari = Mockito.mock(Car.class);

	@Test(expected = RuntimeException.class)
	public void throwException() {
		when(myFerrari.needsFuel()).thenThrow(RuntimeException.class);

		myFerrari.needsFuel();
	}
}
