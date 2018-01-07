package com.github.sawied.websocket.components;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.websocket.beans.Book;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

@RestController
@RequestMapping("/books")
public class BooksService {
	
	
	
	private static final String BOOK = "book";
	
	
	
	@Autowired
	@Qualifier("lanternCache")
	private Ehcache ehCache;

	
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
