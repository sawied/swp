package com.github.sawied.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


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
	
	
	

}
