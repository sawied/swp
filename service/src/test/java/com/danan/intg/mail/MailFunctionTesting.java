package com.danan.intg.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/mail/spring-mail-content.xml"})
public class MailFunctionTesting {
	
	@Autowired
	@Qualifier("outboundMail")
	private MessageChannel messageChannel;
	
	
	@Test
	public void simpleTextMail(){
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setFrom("274624019@qq.com");
		mailMsg.setTo("danan.2009@gmail.com");
		mailMsg.setSubject("Mail sender testing");
		mailMsg.setText("Hello,James X W Z , I have receivered your mail.");
		
		MessagingTemplate mt =new MessagingTemplate(messageChannel);
		MessageBuilder<SimpleMailMessage> mb =MessageBuilder.withPayload(mailMsg);
		mt.send(mb.build());
		
		
	}

	
	
}
