package com.danan.business.smot.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import org.danan.appmanagment.RetrvApplicationInfoRequest;
import org.danan.appmanagment.RetrvApplicationInfoResponse;
import org.danan.bean.commonsegment.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebServiceController {
	private static List<String> contentList=new ArrayList<String>();

	@Autowired
	@Qualifier("inputChannel")
	private MessageChannel mc =null;
	
	@RequestMapping("/download")
	@ResponseBody
	public String downloadAttachment(){
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
		return "SUCCESS";
	}
	
	@RequestMapping("/excel")
	public void parseExcel(HttpServletResponse response){
		
	}

	
	
}
