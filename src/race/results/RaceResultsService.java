package race.results;

import java.util.Collection;
import java.util.HashSet;

import send.mail.Client;
import send.mail.Message;

public class RaceResultsService {

	private Collection<Client> clients = new HashSet<>();

	public void addSubscriber(Client client) {
		this.clients.add(client);
	}

	public void send(Message message) {
		for (Client client : clients) {
			client.receive(message);
		}
	}

	public void removeSubscriber(Client client) {
		clients.remove(client);
	}

}
