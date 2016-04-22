package com.danan.intg.ftp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/sftp/spring-sftp-context.xml"})
public class FTPUploadTesting {
	
	private static final Log LOG = LogFactory.getLog(FTPUploadTesting.class);
	
	
	@Autowired
	@Qualifier("ftpOutboundChannel")
	private MessageChannel mc =null;
	private CountDownLatch countDownLatch=new CountDownLatch(1);
	
	private CountDownLatch startLatch=null;
	
	
	@Test
	public void uploadOneFile(){
		File file = new File("D:/works/A1.txt");
		MessageBuilder<File> mb = MessageBuilder.withPayload(file);
		MessagingTemplate mt =new MessagingTemplate(mc);
		mt.send(mb.build());
		LOG.info("start upload, the current task is :"+ file.toString() );
	}
	
	
	@Test
	public void uploadFile() throws IOException, InterruptedException{
		File root= new File("D:/works/wsdl");
		File[] listFiles = root.listFiles();
		int j=0;
		for(int i=0; i<listFiles.length;i++){
			File file = listFiles[i];
			if(!file.isDirectory()){
				new Thread(new ftpSender(file)).start();
				j++;
			}
		}
		startLatch = new CountDownLatch(j);
		countDownLatch.countDown();
		LOG.info("start upload, the total tasks are :"+ j  );
		startLatch.await();
	}
	
	class ftpSender implements Runnable{

		private File file=null;		
		
		public ftpSender(File file) {
			super();
			this.file = file;
		}

		@Override
		public void run() {
			if(file!=null){
				try {
					countDownLatch.await();
					MessageBuilder<File> mb = MessageBuilder.withPayload(file);
					MessagingTemplate mt =new MessagingTemplate(mc);
					mt.send(mb.build());
					LOG.info("start upload, the current task is :"+ file.toString() );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally
				{					
					startLatch.countDown();
					LOG.debug("current:"+startLatch.toString());
				}
			}
			
		}
		
	}
	
	
	

}
