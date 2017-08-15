package com.danan.intg.ws;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.ws.model.hub.OpDefRqst;
import com.github.sawied.ws.model.hub.RqstPayload;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/ws/spring-ws-xdt.xml"})
public class WsXdtTest {

	
	@Autowired
	@Qualifier("wsInputChannel")
	private MessageChannel mc =null;
	
	@Test
	public void wsXdtTestSuccess() {
		MessagingTemplate mt =new MessagingTemplate(mc);
		OpDefRqst rqst = new OpDefRqst();
		rqst.setSeq("1");
		rqst.setValue("<>26358");
		
		RqstPayload repy = new RqstPayload();
		repy.setOpDefRqst(rqst);
		Message<RqstPayload> request = MessageBuilder.withPayload(repy).build();
		
		mt.sendAndReceive(request);
		
	}
	
	@Test
	public void marshalTestSuccess() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance("com.github.sawied.ws.model.hub");
			Marshaller marshaller = jaxbContent.createMarshaller();
			
			OpDefRqst rqst = new OpDefRqst();
			rqst.setSeq("1");
			rqst.setValue("<>26358");
			
			RqstPayload repy = new RqstPayload();
			repy.setOpDefRqst(rqst);
			
			marshaller.marshal(repy, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
}
