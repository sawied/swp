package com.danan.intg.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/xml/xml-process.xml"})
public class XpathTest {

	@Autowired
	private ApplicationContext ac=null;
	
	
	@Autowired
	@Qualifier("xpathInputChannel")
	private MessageChannel mc =null;
	
	
	@Test
	public void xpathparseSuccess(){
		MessagingTemplate mt = new MessagingTemplate(mc);
		Resource resource=ac.getResource("classpath:com/danan/xml/response.xml");
		InputStream inputStream;
		try {
			inputStream = resource.getInputStream();
			String odsXml=IOUtils.toString(inputStream);
			inputStream.close();
			Message<String> message = MessageBuilder.withPayload(odsXml).build();
			Message<String> response = (Message<String>) mt.sendAndReceive(message);
			System.out.println(response.getPayload());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
