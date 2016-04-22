package com.danan.nodel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.activation.DataHandler;

import org.danan.appmanagment.AppMgmt;
import org.danan.appmanagment.AppMgmtService;
import org.danan.appmanagment.FaultMsg;
import org.danan.appmanagment.RetrvApplicationInfoRequest;
import org.danan.appmanagment.RetrvApplicationInfoResponse;
import org.danan.bean.commonsegment.Customer;
import org.junit.Assert;
import org.junit.Test;

public class WebService{
	
	@Test
	public void testWEbServiceSuccess() throws FaultMsg{
		URL url;
		try {
			url = new URL("HTTP", "127.0.0.1", 8081,"/smot/AppMgmtService?wsdl");
			AppMgmtService appMgmtService = new AppMgmtService(url); 
			AppMgmt appMgmtPort = appMgmtService.getAppMgmtPort();
			RetrvApplicationInfoRequest request = new RetrvApplicationInfoRequest();
			request.setIn("5");
			RetrvApplicationInfoResponse retrvApplicationInfo = appMgmtPort.retrvApplicationInfo(request);
			Customer info = retrvApplicationInfo.getInfo();
			DataHandler attachment = info.getAttachment();
			FileOutputStream outStream = new FileOutputStream("D:/works/img.gif");
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
			Assert.assertNotNull(info);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
