package com.danan.business.smot.web;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class MessageEeventSource
 */
@WebServlet(name = "MessagePush",asyncSupported=true,urlPatterns = { "/MessagePush" })
public class MessageEeventSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Log log=LogFactory.getLog(MessageEeventSource.class);   

    public MessageEeventSource() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/event-stream");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
		AsyncContext ac = request.startAsync();
		ac.setTimeout(60000);
		ac.addListener(new AsyncListener() {
			
			private  Log log=LogFactory.getLog(AsyncListener.class);
			
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				log.debug("timeOut");
			}
			
			@Override
			public void onStartAsync(AsyncEvent ae) throws IOException {
				log.debug("start"+ae.getAsyncContext().getTimeout());
				
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				log.debug("error");
				
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				
				log.debug("complete");
			}
		});
		log.debug(ac.getTimeout());
		ac.start(new PushMsg(ac));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
