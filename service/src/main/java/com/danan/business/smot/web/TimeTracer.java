package com.danan.business.smot.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeTracer implements Runnable {
	
	private final static Logger LOG =LoggerFactory.getLogger(TimeTracer.class);

	private AsyncContext ac=null;
	
	private volatile boolean running =true;
	
	public TimeTracer(AsyncContext ac) {
		super();
		this.ac = ac;
	}

	public void run() {
		try {
			HttpServletResponse response = (HttpServletResponse)ac.getResponse();
			ServletOutputStream outStream = response.getOutputStream();
			char[] cs=new char[2048];
			Arrays.fill(cs, 0, 2048,' ');
			outStream.println(":"+new String(cs));
			while(running){				
				outStream.println("data:"+new Date());
				outStream.println();
				//writer.flush();
				outStream.flush();
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			LOG.error("An IOException error occurred in processing while timer in writering",e);
		} catch (InterruptedException e) {
			LOG.error("An InterruptedException error occurred in processing while timer in writering",e);
		}catch(Exception e){
			LOG.error("An error occurred in processing while timer in writering",e);
		}finally{
			//ac.complete();
		}
	}

}
