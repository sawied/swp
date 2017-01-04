package com.github.sawied.websocket;

import java.io.OutputStream;

import ch.qos.logback.core.OutputStreamAppender;

public class BrowserConsoleAppender<E> extends OutputStreamAppender<E>{

	private OutputStream os =null;
	
	@Override
	public void start() {
		if(os!=null){
			this.setOutputStream(os);
			super.start();
		}
	}

	public synchronized OutputStream getOs() {
		return os;
	}


	public synchronized void setOs(OutputStream os) {
		this.os = os;
	}
	
	
}
