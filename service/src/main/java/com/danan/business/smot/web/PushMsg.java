package com.danan.business.smot.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

import com.ctc.wstx.cfg.OutputConfigFlags;

public class PushMsg implements Runnable {

	private AsyncContext ac=null;
	
	public PushMsg(AsyncContext ac) {
		super();
		this.ac = ac;
	}

	public void run() {
		try {
			HttpServletResponse response = (HttpServletResponse)ac.getResponse();
			PrintWriter writer = response.getWriter();
			char[] cs=new char[2048];
			Arrays.fill(cs, 0, 2048,' ');
			writer.println(":"+new String(cs));
			for(int i=0;i<30;i++){				
				writer.println("data:"+new Date());
				writer.println();
				writer.flush();
				Thread.sleep(1000);
			}
			ac.complete();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
