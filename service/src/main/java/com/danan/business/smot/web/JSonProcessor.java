package com.danan.business.smot.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class JSonProcessor
 */
public class JSonProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public JSonProcessor() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		HttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost("http://cn.bing.com");
		HttpEntity entity = new InputStreamEntity(inputStream, -1);
		post.setEntity(entity);
		HttpResponse httpResp = client.execute(post);
		HttpEntity responseEntity = httpResp.getEntity();
		String str=EntityUtils.toString(responseEntity);
		response.getWriter().write(str);
		response.flushBuffer();
	}

}
