package com.danan.intg.http;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/http/httpclient.xml"})
public class CachingHttpClientTest {

    @Autowired
    private HttpClient httpClient; 
    
    
    @Test
    public void getCachedResponseSuccess(){
	try {
	    HttpResponse response = httpClient.execute(new HttpGet("http://localhost/sample.pdf"));
	    int statusCode = response.getStatusLine().getStatusCode();
	    Assert.assertEquals(200, statusCode);
	    
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    
}
