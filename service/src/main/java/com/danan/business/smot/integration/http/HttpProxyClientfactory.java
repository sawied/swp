package com.danan.business.smot.integration.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 * 
 * @author lucy
 *
 */
public class HttpProxyClientfactory implements FactoryBean<CloseableHttpClient>, DisposableBean {
    /***/
    private CloseableHttpClient httpClient;

    private int port;
    /***/
 
    private String host;
    
    private Resource keystoreResource;
    
    private char[] keystorePasswd;
    

    @Override
    public CloseableHttpClient getObject() throws Exception {
        if (httpClient == null) {
            httpClient = buildHttpClient();
        }
        return httpClient;
    }

    /**
     * 
     * @return CloseableHttpClient
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * @throws KeyStoreException 
     * @throws IOException 
     * @throws CertificateException 
     */
    private CloseableHttpClient buildHttpClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
    	
    	KeyStore keystore = null;
    	if(keystoreResource!=null) {
    		
    		keystore = KeyStore.getInstance("JKS");
    		
    		keystore.load(keystoreResource.getInputStream(), keystorePasswd);
    	}
    	
    	SSLContext sslContext= new SSLContextBuilder().loadTrustMaterial(keystore, new TrustStrategy(){
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return false;
			}
    	}).build();
    	
        HttpClientBuilder httpBuilder = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier());
        if (host != null && !host.trim().isEmpty()) {
            HttpHost proxyHost = new HttpHost(host, port);
            httpBuilder.setProxy(proxyHost);
        }
        this.httpClient = httpBuilder
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor()).build();
        return this.httpClient;
    }

    @Override
    public void destroy() throws Exception {
        if (httpClient != null) {
            httpClient.close();
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Class<?> getObjectType() {
        return CloseableHttpClient.class;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

	public Resource getKeystoreResource() {
		return keystoreResource;
	}

	public void setKeystoreResource(Resource keystoreResource) {
		this.keystoreResource = keystoreResource;
	}

	public char[] getKeystorePasswd() {
		return keystorePasswd;
	}

	public void setKeystorePasswd(char[] keystorePasswd) {
		this.keystorePasswd = keystorePasswd;
	}
    
    

}
