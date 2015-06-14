package race.results;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import send.mail.Client;
import send.mail.Message;

public class RaceResultsServiceFirstAndSecondTest {

	RaceResultsService raceResults = new RaceResultsService();
	Message message = Mockito.mock(Message.class);
	Client clientA = Mockito.mock(Client.class);
	Client clientB = Mockito.mock(Client.class);

	@Test
	public void subscribedClientShouldReceiveMessage() {
		raceResults.addSubscriber(clientA);
		raceResults.send(message);

		verify(clientA).receive(message);
	}
	
	@Test
	public void messageShouldBeSentToSubscribedClients() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);
		raceResults.send(message);

		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}
	
	@Test
	public void notSubscribedClientShouldNotReceiveMessage() {
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
	}
	
	@Test
	public void shouldSendOnlyOneMessageToMultiClients() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientA);
		raceResults.send(message);

		verify(clientA).receive(message);
	}
	
	@Test
	public void unSubscribedClientShouldNotReceiveMessages() {
		raceResults.addSubscriber(clientA);
		raceResults.removeSubscriber(clientA);
		
		raceResults.send(message);

		verify(clientA, never()).receive(message);
	}
}
