package com.danan.intg.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/http/proxy-httpclient.xml"})
public class NormalHTTPTest {
	
	 @Autowired
	 private HttpClient httpClient; 
	 
	 
	 @Test
	 public void httpFetchSuccess(){
		 HttpGet get = new HttpGet("https://www.google.com.hk");
		 try {
			HttpResponse response = httpClient.execute(get);
			System.out.println(response.getStatusLine());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	 }
	 
	 

}
