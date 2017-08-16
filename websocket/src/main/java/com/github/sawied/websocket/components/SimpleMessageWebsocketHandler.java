package com.github.sawied.websocket.components;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Controller
public class SimpleMessageWebsocketHandler implements MessageHandler{
	
	private static final Logger  LOGER = LoggerFactory.getLogger(SimpleMessageWebsocketHandler.class);
	
	@Autowired
	private SimpMessagingTemplate simTemplate;
	
	
	@RequestMapping("/{userid}/{message}")
	public void request(@PathVariable("userid") String userid,@PathVariable("message") String message){
		//simTemplate.convertAndSendToUser(userid, destination, message);
	}


	@Override
	public void handleMessage(Message<?> msg) throws MessagingException {
		
	}

	
	



	
	
}
