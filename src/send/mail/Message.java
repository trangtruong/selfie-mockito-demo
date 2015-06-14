package send.mail;

public class Message {
	private TemplateEngine templateEngine;
	private MailServer mailServer;

	public Message(TemplateEngine templateEngine, MailServer mailServer) {
		this.templateEngine = templateEngine;
		this.mailServer = mailServer;
	}

	public void sendMessage(Client client, Template template) {
		String msgContent = templateEngine.prepareMessage(template, client);
		mailServer.send(client.getEmail(), msgContent);
	}

}
