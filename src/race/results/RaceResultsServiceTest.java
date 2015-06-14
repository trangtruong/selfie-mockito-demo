package race.results;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import send.mail.Client;
import send.mail.Message;

public class RaceResultsServiceTest {
	
	@Test
	public void subscribedClientShouldReceiveMessage() {
		RaceResultsService raceResults = new RaceResultsService();
		Message message = Mockito.mock(Message.class);
		Client client = Mockito.mock(Client.class);
		raceResults.addSubscriber(client);
		raceResults.send(message);

		verify(client).receive(message);
		
	}
}
