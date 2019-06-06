package com.github.sawied.websocket.components;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.sawied.websocket.beans.Book;
import com.github.sawied.websocket.paging.UserInfo;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

@RestController
@RequestMapping("/books")
public class BooksService {
	
	
	
	private static final String BOOK = "book";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	@Qualifier("lanternCache")
	private Ehcache ehCache;
	
	
	@RequestMapping("/remote")
	public String remoteCall(){
		//restTemplate.
		MappingJacksonValue value = new MappingJacksonValue(new UserInfo());
		HttpEntity<MappingJacksonValue> entity = new HttpEntity<MappingJacksonValue>(value);
		return restTemplate.postForEntity("http://localhost:8888/{id}", entity,String.class, 12).getBody();
	}

	
	@RequestMapping(method=RequestMethod.GET,path="/{id}")
	@ResponseBody
	 public Book getOne(@PathVariable("id") String id) throws Exception{
		Book bok =(Book)(ehCache.get(BOOK+"_"+id).getObjectValue());
		return bok;
	 }
	
	
	@RequestMapping(method=RequestMethod.POST,path="")
	@ResponseBody
	public Book addBook(@Valid @RequestBody Book book){
		book.setId(book.getId());
		book.setPublish(new Date());
		ehCache.put(new Element(BOOK+"_"+book.getId(), book));
		return book;
	}
	
	
	
	
}
