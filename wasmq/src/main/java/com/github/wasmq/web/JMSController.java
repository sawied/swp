package com.github.wasmq.web;


import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JMSController {

	@Autowired(required=false)
	@Qualifier("jmsRequest")
	private MessageChannel mq =null;
	
	
	@Autowired
	private JmsTemplate jmsTemplate=null;
	
	@Autowired
	@Qualifier("jr")
	private Destination requestDestination;
	
	@Autowired
	@Qualifier("jmsReply")
	private Destination replyDetination;
	
	
	@Autowired
	@Qualifier("jmsRR")
	private Destination rr;
	
	
	@Autowired
	@Qualifier("replyAlias")
	private Destination replyAlias;
	
	private AtomicInteger count=new AtomicInteger(0);
	
	
	private ThreadLocal<javax.jms.Message> tl= new ThreadLocal<javax.jms.Message>();

	
	
	@RequestMapping("/sr")
	@ResponseBody
	public String sendAndReceive() throws JMSException{
		
		final String identificationId = "mvtm-"+String.valueOf(System.currentTimeMillis())+String.valueOf(count.getAndIncrement());
		
		System.out.println("JMSCorrelationID:"+identificationId);
		
		
		
		
		jmsTemplate.send(requestDestination, new MessageCreator() {
			@Override
			public javax.jms.Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(String.valueOf(System.currentTimeMillis()));
				msg.setJMSReplyTo(rr);
				msg.setJMSCorrelationID(identificationId);
				msg.setJMSExpiration(System.currentTimeMillis()+60000);
				tl.set(msg);
				return msg;
			}
		});
		
		String messageId= tl.get().getJMSMessageID();
		
		System.out.println("Message Id : " + messageId);
		
		javax.jms.TextMessage jms = (TextMessage)jmsTemplate.receiveSelected(replyDetination,"JMSCorrelationID"+"="+"'"+messageId+"'");
		
		return jms.getText();	
	}
	public String generateCorrelationIdSelector(String var){
		byte[] bytes= new byte[24];
		byte[] ids=var.getBytes();
		for(int i=0;i<bytes.length&&i<ids.length;i++){
			bytes[i]=ids[i];
		}
		return "ID:"+Hex.encodeHexString(bytes);
	}
	
	@RequestMapping("/sa")
	@ResponseBody
	public String sendasReply(){
		jmsTemplate.send(requestDestination, new MessageCreator(){

			@Override
			public javax.jms.Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(String.valueOf(System.currentTimeMillis()));
				msg.setStringProperty("ReplyToQ", "R");
				msg.setStringProperty("ReplyToQMgr", "");
				return msg;
			}
			
		});
		return "DONE";
	}
	
	
	
	
	@RequestMapping("/mq")
	public String sendms(){
		String time=String.valueOf(System.currentTimeMillis());
		Message<String> msg = MessageBuilder.withPayload(time).build();
		MessagingTemplate mt =new MessagingTemplate(mq);
		Message<?> rspon = mt.sendAndReceive(msg);
		System.out.println(rspon);
		
		return "time";
	}
	
	

	
	
}
