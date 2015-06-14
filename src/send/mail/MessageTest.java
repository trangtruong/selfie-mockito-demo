package send.mail;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MessageTest {

	private static final String MSG_CONTENT = "This is content.";
	private static final String CLIENT_EMAIL = "som@email.com";
	
	Client client = Mockito.mock(Client.class);
	Template template = Mockito.mock(Template.class);
	TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);

	@Test
	public void testDummy() {
		Message message = Mockito.mock(Message.class);
		message.sendMessage(client, template);
	}

	@Test
	public void testStubbing() {
		Message sut = new Message(templateEngine, Mockito.mock(MailServer.class));

		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

		sut.sendMessage(client, template);
	}
	
	@Test
	public void testSpy() {
		MailServer mailServer = Mockito.mock(MailServer.class);
		Message sut = new Message(templateEngine, mailServer);

		sut.sendMessage(client, template);
		
		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}
	
	@Test
	public void testAllTogether() {
		//GIVEN
		MailServer mailServer = Mockito.mock(MailServer.class);
		Message sut = new Message(templateEngine, mailServer);

		//WHEN
		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		
		sut.sendMessage(client, template);
		
		//THEN
		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}
}
