package com.github.sawied.agent.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/files")
public class UploadServiceController {

    private final static Logger LOG=LoggerFactory.getLogger(UploadServiceController.class); 
    
    
    @RequestMapping(method=RequestMethod.POST)
    public void upload(@RequestParam("idCard") String idCard,@RequestParam("file") MultipartFile file,HttpServletResponse response){
	
	try{
	    LOG.info("Id Card is " + idCard );
	    IOUtils.copy(file.getInputStream(), response.getOutputStream());
	} catch (IOException e) {
	   LOG.error("IO exception when upload file", e);
	}
	
	
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String list(){
	return "Home";
    }
    
    
}
