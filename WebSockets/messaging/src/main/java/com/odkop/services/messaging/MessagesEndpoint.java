package com.odkop.services.messaging;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ServerEndpoint(
			value = "/messages",
			encoders = MessageEncoder.class,
			decoders = MessageDecoder.class
		)
public class MessagesEndpoint {

	private static final Logger LOGGER = LogManager.getLogger(MessagesEndpoint.class);
	
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public void setToAllExcept(Session except, Message message) {
		LOGGER.info("Sent message: {} to all except session id: {}", message, except.getId());
		for (Session session: sessions) {
			if (session.getId()!=except.getId()) {
				sent(session, message);
			}
		}
	}
	
	public void sent(Session session, Message message) {
		LOGGER.info("Sent message: {} to session id: {}", message, session.getId());
		session.getAsyncRemote().sendObject(message);
	}
	
	@OnOpen
	public void open(Session session, EndpointConfig conf) {
		LOGGER.info("Open - session id: {}, maxIdleTimeout: {}", 
				session.getId(), session.getMaxIdleTimeout(), session);
		sessions.add(session);
		LOGGER.info("Current session poll size: {}", sessions.size());
	}

	@OnMessage
	public void message(Session session, Message msg) {
		LOGGER.info("Message - session id: {}, message: {}", session.getId(), msg);
		setToAllExcept(session, msg);
	}

	@OnError
	public void error(Session session, Throwable error) {
		LOGGER.info("Error - session id: {}, error: {}", session.getId(), error);
	}

	@OnClose
	public void close(Session session, CloseReason reason) {
		LOGGER.info("Close - session id: {}, reason code: {}, reason msg: {}", 
				session.getId(), reason.getCloseCode(), reason.getReasonPhrase());
		sessions.remove(session);
		LOGGER.info("Current session poll size: {}", sessions.size());
	}

}
