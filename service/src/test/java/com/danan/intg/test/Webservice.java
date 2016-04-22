package com.danan.intg.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.danan.appmanagment.FaultMsg;
import org.danan.appmanagment.ObjectFactory;
import org.danan.appmanagment.RetrvApplicationInfoRequest;
import org.danan.appmanagment.RetrvApplicationInfoResponse;
import org.danan.bean.commonsegment.Customer;
import org.danan.bean.commonsegment.FaultInfo;
import org.junit.Assert;
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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/webservice/spring-ws-content.xml"})
public class Webservice{
	
	@Autowired
	@Qualifier("inputChannel")
	private MessageChannel mc =null;
	
	
	public void testWebServiceSuccess(){
		RetrvApplicationInfoRequest request =new RetrvApplicationInfoRequest();
		request.setIn("1");
		MessageBuilder<RetrvApplicationInfoRequest> mb =MessageBuilder.withPayload(request);
		MessagingTemplate mt =new MessagingTemplate(mc);
		Message<?> sendAndReceive = mt.sendAndReceive(mb.build());
		RetrvApplicationInfoResponse retrvApplicationInfo = (RetrvApplicationInfoResponse) sendAndReceive.getPayload();
		Customer info = retrvApplicationInfo.getInfo();
		DataHandler attachment = info.getAttachment();
		try{
		FileOutputStream outStream = new FileOutputStream("D:/works/A1.txt");
		InputStream inputStream = attachment.getInputStream();
		FileChannel channel = outStream.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byte[] bytes= new byte[1];
		int n=-1;
		while((n=inputStream.read(bytes))!=-1){
			if(!byteBuffer.hasRemaining()){
				byteBuffer.flip();
				channel.write(byteBuffer);
				byteBuffer.clear();
			}
			byteBuffer.put(bytes, 0, n);
		}
		//clean remaining byte
		byteBuffer.flip();
		channel.write(byteBuffer);
		inputStream.close();
		channel.close();
		outStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(sendAndReceive);
	}
	
	@Test
	public void marshallFault(){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("org.danan.appmanagment");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			FaultInfo faultInfo = new FaultInfo();
			faultInfo.setErrorCode("4528");
			faultInfo.setReason("not null");
			FaultMsg faultMsg = new FaultMsg("message", faultInfo);
			ObjectFactory ob =new ObjectFactory();
			JAXBElement<FaultInfo> createBusinessException = ob.createBusinessException(faultInfo);
			marshaller.marshal(createBusinessException, System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
