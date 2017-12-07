package com.github.sawied.jweb.service;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.jweb.entity.Event;
import com.github.sawied.jweb.repository.EventRepository;
import com.github.sawied.jweb.service.bean.CreateEventRequest;
import com.github.sawied.jweb.service.bean.SearchEventRequest;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Page<Event> searchEvent(SearchEventRequest request){
		Pageable page =new PageRequest(request.getPage(),10);
		return eventRepository.findAll(page);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Event createEvent(@RequestBody @Valid CreateEventRequest request){
		Event event = new Event();
		event.setText(request.getText());
		event.setCreateTime(new Date());
		event.setStatus(Event.IN_PROGRESS);
		return eventRepository.save(event);
	}
	
	
}
