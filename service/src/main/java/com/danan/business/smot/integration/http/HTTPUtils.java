package com.danan.business.smot.integration.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.springframework.http.HttpMethod;

/**
 * 
 * @author James X W Zhang
 *
 */
public abstract class HTTPUtils {

	private static List<String> whitelist = new ArrayList<String>();

	static {
		whitelist.add("Content-Type");
		whitelist.add("Accept");
		whitelist.add("Accept-Language");
		whitelist.add("Accept-Encoding");
		whitelist.add("Accept-Charset");
		whitelist.add("Accept-Encoding");
	}

	public static HttpUriRequest createHTTPRequestByType(HttpServletRequest request) throws IOException {

		HttpUriRequest urlRequest = null;

		String method = request.getMethod();
		if (HttpMethod.GET.matches(method)) {
			HttpGet httpGet = new HttpGet();
			urlRequest = httpGet;
		}
		if (HttpMethod.POST.matches(method)) {
			HttpPost httpPost = new HttpPost();
			httpPost.setEntity(new InputStreamEntity(request.getInputStream()));
			urlRequest = httpPost;
		}
		if (HttpMethod.DELETE.matches(method)) {
			urlRequest = new HttpDelete();
		}
		if (HttpMethod.PUT.matches(method)) {
			HttpPut httpPut = new HttpPut();
			httpPut.setEntity(new InputStreamEntity(request.getInputStream()));
			urlRequest = new HttpPut();
		}

		copyHeaders(request, urlRequest);

		return urlRequest;
	}

	
	
	
	
	private static void copyHeaders(HttpServletRequest request, HttpUriRequest urlRequest) {

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			if (whitelist.contains(name)) {
				urlRequest.setHeader(name, request.getHeader(name));
			}
		}

	}

}
