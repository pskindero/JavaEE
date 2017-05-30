package com.odkop.services.messaging;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageDecoder implements Decoder.Text<Message>{
	private static final Logger LOGGER = LogManager.getLogger(MessageDecoder.class);

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message decode(String s) throws DecodeException {
		LOGGER.info("Decode: " +s );
		Message m = new Message();
		if (willDecode(s)){
			JsonParser parser = Json.createParser(new StringReader(s));
			while (parser.hasNext()) {
				 if (parser.next() == JsonParser.Event.KEY_NAME) {
		                String key = parser.getString();
		                parser.next();
		                String value = parser.getString();
		                if (key.equals("author"))
		                	m.setAuthor(value);
		                if (key.equals("message"))
		                	m.setContent(value);
		}
			}
		} else {
			throw new DecodeException(s, "Message not decodable ");
		}
		return m;
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

}
