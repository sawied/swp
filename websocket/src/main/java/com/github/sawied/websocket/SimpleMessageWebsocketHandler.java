package com.github.sawied.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleMessageWebsocketHandler extends TextWebSocketHandler{
	
	private static final Logger  LOGER = LoggerFactory.getLogger(SimpleMessageWebsocketHandler.class);
	
	

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		
		
		LOGER.info("received message from "+ session.getId()+" "+ message.getPayload());
		session.sendMessage(message);
	}





	
	
}
