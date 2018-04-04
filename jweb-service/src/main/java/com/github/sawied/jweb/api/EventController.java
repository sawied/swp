package com.github.sawied.jweb.api;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.jweb.api.bean.CreateEventRequest;
import com.github.sawied.jweb.api.bean.SearchEventRequest;
import com.github.sawied.jweb.entity.EventEntity;
import com.github.sawied.jweb.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Page<EventEntity> searchEvent(SearchEventRequest request){
		Pageable page =new PageRequest(request.getPage(),10);
		return eventService.searchEvent(page);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody EventEntity createEvent(@RequestBody @Valid CreateEventRequest request){
		EventEntity event = new EventEntity();
		event.setText(request.getText());
		event.setCreateTime(new Date());
		event.setStatus(EventEntity.IN_PROGRESS);
		return eventService.createEvent(event);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody EventEntity deleteEvent(@PathVariable("id") Long id){
		return eventService.deleteEvent(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/{id}")
	public @ResponseBody EventEntity toggleEvent(@PathVariable("id") Long id) {
		return eventService.toggleEvent(id);
	}
	
	
}
