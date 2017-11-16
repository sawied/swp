package com.github.sawied.websocket.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;

import org.apache.commons.jcs.access.CacheAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.websocket.beans.Book;
import com.github.sawied.websocket.beans.BookSearchRequest;

@RestController
@RequestMapping("/books")
public class BooksService {
	
	
	
	private static final String BOOK = "book";
	
	private AtomicInteger ai =new AtomicInteger(0);
	
	
	@Autowired
	@Qualifier("bookCache")
	private CacheAccess<String, Book> jcs;

	@RequestMapping(method=RequestMethod.GET,path="")
	@ResponseBody
	 public Page<Book> listBooks(@Valid  BookSearchRequest request,Errors errors,BindingResult result) throws Exception{
		ValidationUtils.invokeValidator(new BookSearchRequestValidator(), request, errors);
		if(errors.hasErrors()){
			throw new BindException(result);
		}
		 List<Book> books = new ArrayList<Book>();
		 if(books!=null){
			 books.addAll(books);
		 }
		  Page<Book> page = new PageImpl<Book>(books);
		 return page;
	 }
	
	
	@RequestMapping(method=RequestMethod.GET,path="/{id}")
	@ResponseBody
	 public Book getOne(@PathVariable("id") String id) throws Exception{
		Book bok = jcs.get(BOOK+"_"+id);
		 return bok;
	 }
	
	
	@RequestMapping(method=RequestMethod.POST,path="")
	@ResponseBody
	public Book addBook(@Valid @RequestBody Book book){
		book.setId(ai.getAndIncrement());
		book.setPublish(new Date());
		jcs.put(BOOK+"_"+book.getId(),book);
		return book;
	}
	
	
	
	
}
