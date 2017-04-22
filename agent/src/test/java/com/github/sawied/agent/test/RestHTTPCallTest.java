package com.github.sawied.agent.test;



import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestHTTPCallTest {

    
    private static final String HELLO = "Hello";

    @Test
    public void uploadFileSuccess(){
	RestTemplate restTemplate = new RestTemplate();
	
	HttpHeaders header = new HttpHeaders();
	header.setContentType(MediaType.MULTIPART_FORM_DATA);
	
	MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
	parts.add("idCard", "169");
	
	HttpHeaders txtHeader = new HttpHeaders();
	txtHeader.setContentType(MediaType.TEXT_PLAIN);
	HttpEntity<ByteArrayResource> txtPart = new HttpEntity<ByteArrayResource>(new NamedInputStreamResource(HELLO.getBytes(),"upload.txt"), txtHeader);
	parts.add("file",txtPart);
	
	HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(parts, header);
	
	
	
	
	String response =restTemplate.postForObject("http://localhost:5295/agent/files", requestEntity, String.class);
	Assert.assertEquals(HELLO, response);
	
    }
    
    
}
