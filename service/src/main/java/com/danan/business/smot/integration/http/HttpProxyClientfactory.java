package com.danan.business.smot.integration.http;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

public class HttpProxyClientfactory implements FactoryBean<CloseableHttpClient>,DisposableBean{

	
	private CloseableHttpClient  httpClient;
	


	@Override
	public CloseableHttpClient getObject() throws Exception {
	    if(httpClient==null){
		httpClient = buildHttpClient();
	    }
	    return httpClient;
	}

	private CloseableHttpClient buildHttpClient() {
		HttpHost proxyHost = new HttpHost("localhost", 50411);
		this.httpClient= HttpClients.custom()
				.setProxy(proxyHost)
				.build();
		return this.httpClient;
	}
	
	
	
	@Override
	public Class<?> getObjectType() {
		return CloseableHttpClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


	@Override
	public void destroy() throws Exception {
	    if(httpClient!=null){
		httpClient.close();
	    }
	}
	
	
}
