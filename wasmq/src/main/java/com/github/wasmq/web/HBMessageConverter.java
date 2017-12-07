package com.github.wasmq.web;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class HBMessageConverter implements MessageConverter{

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		 TextMessage msg = session.createTextMessage(session.toString());
		 msg.setStringProperty("JMS_IBM_MQMD_ReplyToQ", "R2");
		 msg.setStringProperty("JMS_IBM_MQMD_ReplyToQMgr", "HUBMQREMOTE");
		return msg;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		return ((TextMessage)message).getText();
	}

}
