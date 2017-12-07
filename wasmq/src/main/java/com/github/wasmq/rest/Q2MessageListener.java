package com.github.wasmq.rest;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class Q2MessageListener implements SessionAwareMessageListener<TextMessage>{

	@Autowired
	private Resource resource;
	
	
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		
		byte[] bytes=null;
		
		try {
			 bytes = IOUtils.toByteArray(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TextMessage response = session.createTextMessage(new String(bytes));
		
		response.setJMSCorrelationIDAsBytes(correlationidDecode(message.getJMSMessageID().substring("ID:".length())));
		
		MessageProducer consumer = session.createProducer(message.getJMSReplyTo());
		
		
		consumer.send(response,Message.DEFAULT_DELIVERY_MODE,Message.DEFAULT_PRIORITY,15000);
		
		
		
		System.out.println(message);
				
	}
	
	
	public byte[] correlationidDecode(String str){
		byte[] bytes = new byte[24];
		int count=str.length()/2;
		for(int i=0;i<count;i++){
		   Integer r=Integer.decode("0X"+str.substring(i*2, (i+1)*2));
		   bytes[i]=r.byteValue();
		}
		return bytes;
	}


	public Resource getResource() {
		return resource;
	}


	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	



}
