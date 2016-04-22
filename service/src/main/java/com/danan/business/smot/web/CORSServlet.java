package com.danan.business.smot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class CORSServlet
 */
@WebServlet("/cors")
public class CORSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(CORSServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CORSServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("income request be processing");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "text/plain");
		PrintWriter writer = response.getWriter();
		for(int i=0;i<100;i++){			
			writer.append("data-").append(String.valueOf(i));
		}
		writer.close();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doOptions(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "X-HSBC");
		response.setHeader("Access-Control-Max-Age", "1728000");
		response.flushBuffer();
	}
	
	

}
