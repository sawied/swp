package com.danan.intg.http;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.cache.CacheResponseStatus;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codecimpl.JPEGImageEncoder;
import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/http/httpclient.xml"})
public class CachingHttpClientTest {

    @Autowired
    private HttpClient httpClient; 
    
    
    private final static String REPOSITORY="C:/works/temp/";
    
    
    private final static String JPEG_Suffix=".jpg";
    
    
    @Test
    public void getCachedResponseSuccess(){
	try {
	    HttpResponse response = httpClient.execute(new HttpGet("https://localhost/sample.pdf"));
	    int statusCode = response.getStatusLine().getStatusCode();
	    Assert.assertEquals(200, statusCode);
	    
	    HttpCacheContext context = new HttpCacheContext();
	    response = httpClient.execute(new HttpGet("https://localhost/sample.pdf"),context);
	   
	    CacheResponseStatus cacheResponseStatus = context.getCacheResponseStatus();
	     
	    Assert.assertEquals(cacheResponseStatus, CacheResponseStatus.VALIDATED);
	    
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    
    @Test
    public void getCachedHashCodeSuccess(){
			try {
				String hashCode = getSha256FromResponse();
				Thread.sleep(3000);
				Assert.assertEquals(hashCode, getSha256FromResponse());
				System.out.println("got the hash code is :" + hashCode);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		
    }
    
    
    @Test
    public void pdfResponseToImages(){
    	try {
			HttpResponse response = httpClient.execute(new HttpGet("https://localhost/sample.pdf"));
			int statusCode =  response.getStatusLine().getStatusCode();
			if(statusCode==200 && "application/pdf".equals(response.getFirstHeader("Content-Type").getValue())){
				HttpEntity httpEntity=response.getEntity();
				if(!httpEntity.isRepeatable()){		
					httpEntity = new BufferedHttpEntity(httpEntity);
				}
				
				ByteArrayInputStream content = (ByteArrayInputStream) httpEntity.getContent();
				char[] encode = Hex.encode(DigestUtils.sha256(content));
				content.reset();
				Pdf2Images(content,new String(encode));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
    private String getSha256FromResponse(){
    	char[] encode =null;
    	HttpResponse response;
		try {
			response = httpClient.execute(new HttpGet("https://localhost/sample.pdf"));
			int statusCode =  response.getStatusLine().getStatusCode();
			if(statusCode==200){
				InputStream inputstream = response.getEntity().getContent();
				encode = Hex.encode(DigestUtils.sha256(inputstream));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return encode==null? null : new String(encode);
		
    }
    
    
    
    private void Pdf2Images(InputStream input,String hashCode){
    	
    	try {
			PDDocument pdDocument = PDDocument.load(input);
			int numberOfPages = pdDocument.getNumberOfPages();
			for(int i =0;i<numberOfPages;i++){
				BufferedImage bufferedImage = new PDFRenderer(pdDocument).renderImageWithDPI(i,300,ImageType.RGB);
				saveImage2JPEG(bufferedImage,new File(REPOSITORY,hashCode),StringUtils.leftPad(String.valueOf(i), 3,"0"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
    private void saveImage2JPEG(BufferedImage bufferedImage,File dirctory,String name){
    	if(!dirctory.exists()){
    		dirctory.mkdirs();
    	}else{
    		System.out.println("why the flow can step in here ?");
    	}
    	File dist = new File(dirctory,name + JPEG_Suffix);
    	
    	FileOutputStream outputStream=null;
    	
		try {
			outputStream = new FileOutputStream(dist);
			JPEGEncodeParam jpegEncodeParam=new JPEGEncodeParam();
			jpegEncodeParam.setQuality(0.7f);
			JPEGImageEncoder jpegImageEncoder=new JPEGImageEncoder(outputStream,jpegEncodeParam);
			jpegImageEncoder.encode(bufferedImage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	
    }
    
    
    

    
    
}
