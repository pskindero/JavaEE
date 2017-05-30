package com.odkop.services.messaging;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageEncoder implements Encoder.Text<Message> {
	private static final Logger LOGGER = LogManager.getLogger(MessageEncoder.class);

	public void init(EndpointConfig config) {

	}

	public void destroy() {

	}

	public String encode(Message m) throws EncodeException {
		LOGGER.info("Encode: " +m );
		StringWriter swriter = new StringWriter();
		try (JsonWriter jsonWrite = Json.createWriter(swriter)) {
			JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add("author", m.getAuthor())
					.add("message", m.getContent());
			jsonWrite.writeObject(builder.build());
		}
		return swriter.toString();
	}

}
