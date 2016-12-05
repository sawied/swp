package com.danan.business.smot.integration.http;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.springframework.beans.factory.FactoryBean;


public class CachingHTTPClientCreator implements FactoryBean<CloseableHttpClient>{
	
	
	private HttpCacheStorage cacheStorage;
	
	private HttpClientConnectionManager connectionManager;

	@Override
	public CloseableHttpClient getObject() throws Exception {
		//Set the max object size is 10M
		CacheConfig cacheConfig = CacheConfig.custom().setMaxObjectSize(1024 * 1024 * 10).build();
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(30000) //connection time out for a connection is established
				.setSocketTimeout(60000) //the timeout for waiting for data
				.build();
		
		return CachingHttpClients.custom().setCacheConfig(cacheConfig)
				.setHttpCacheStorage(cacheStorage)
				.setConnectionManager(connectionManager)
				.setUserAgent("Apache HTTPClient Agent")
				.setDefaultRequestConfig(requestConfig)
				.setConnectionTimeToLive(30L, TimeUnit.SECONDS).build();
	}

	@Override
	public Class<?> getObjectType() {
		return CloseableHttpClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
