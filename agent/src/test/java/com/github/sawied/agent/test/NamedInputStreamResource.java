package com.github.sawied.agent.test;


import org.springframework.core.io.ByteArrayResource;

public class NamedInputStreamResource extends ByteArrayResource {

    private String fileName;
    
    public NamedInputStreamResource(byte[] inputStream, String fileName) {
	super(inputStream);
	this.fileName=fileName;
    }

    @Override
    public String getFilename() {
	return fileName;
    }
    
    
    
    
}
