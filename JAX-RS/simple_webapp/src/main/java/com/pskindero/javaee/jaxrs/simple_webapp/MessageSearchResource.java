package com.pskindero.javaee.jaxrs.simple_webapp;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pskindero.javaee.jaxrs.simple_webapp.model.Message;

@Path("messages")
public class MessageSearchResource {

	public static List<Message> messages = new ArrayList<Message>();
	
	static {
		Message m1 = new Message("tom", "Hello message");
		Message m2 = new Message("tom", "Ok, it works");
		Message m3 = new Message("ian", "But design is terrible!");
		Message m4 = new Message("tom", "I know.");
		Message m5 = new Message("ian", "need to fix it!");
		Message m6 = new Message("tom", "But it is only some fast example;p");
		messages.add(m1);
		messages.add(m2);
		messages.add(m3);
		messages.add(m4);
		messages.add(m5);
		messages.add(m6);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllMessages() {
		return messages.toString();
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessagesXml() {
		return messages;
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessagesJson() {
		return messages;
	}
}
