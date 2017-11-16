package com.github.sawied.websocket.config;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sawied.websocket.beans.Book;

@Configuration
public class ApplicationConfig {
	
	private static final String BOOK_CACHE = "bookCache";
	
	@Bean
	@Qualifier("bookCache")
	public CacheAccess<String, Book> bookCacheBuild(){
		return JCS.getInstance(BOOK_CACHE);
	} 

}
