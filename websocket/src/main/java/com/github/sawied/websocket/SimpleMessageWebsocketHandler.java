package com.github.sawied.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleMessageWebsocketHandler extends TextWebSocketHandler{
	
	private static final Log LOG = LogFactory.getLog(SimpleMessageWebsocketHandler.class);
	
	//SimpMessagingTemplate messagingTemplate;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		LOG.info("received message from "+ session.getId()+" "+ message.getPayload());
	}

	
	
}
