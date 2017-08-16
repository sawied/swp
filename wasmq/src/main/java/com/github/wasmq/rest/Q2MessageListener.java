package com.github.wasmq.rest;

import java.io.IOException;

import javax.jms.JMSException;

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
		
		response.setJMSCorrelationID(message.getJMSCorrelationID());
		
		MessageProducer consumer = session.createProducer(message.getJMSReplyTo());
		
		consumer.send(response);
		
		
		
		System.out.println(message);
				
	}


	public Resource getResource() {
		return resource;
	}


	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	



}
