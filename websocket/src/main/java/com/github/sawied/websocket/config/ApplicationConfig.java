package com.github.sawied.websocket.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import net.sf.ehcache.CacheManager;


@Configuration
public class ApplicationConfig {
	
	
	
	@Bean
	public EhCacheManagerFactoryBean ehcacheManagerFactoryCreate(){
		Resource  resource = new ClassPathResource("sawied/github/cache/ehcache.xml");
		EhCacheManagerFactoryBean ehFactoryBean = new EhCacheManagerFactoryBean();
		ehFactoryBean.setConfigLocation(resource);
		ehFactoryBean.setCacheManagerName("dscache");
		return ehFactoryBean; 
	}
	
	@Autowired
	@Bean
	@Qualifier("lanternCache")
	public EhCacheFactoryBean ehcacheFactoryCreate(CacheManager cacheManage) {
		EhCacheFactoryBean factoryBean = new EhCacheFactoryBean();
		factoryBean.setCacheManager(cacheManage);
		factoryBean.setCacheName("lanternCache");
		return factoryBean;
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		List<ClientHttpRequestInterceptor> interceptors=restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        }
		interceptors.add(new RestTemplateHAMCAuthorizationInterceptor(null,null));
        restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	
	
	

}
