package com.danan.business.smot.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danan.business.smot.domain.Event;
import com.danan.business.smot.rest.EventManager;

@RestController
@RequestMapping("/event/*")
@ResponseBody
public class EventManagerImpl implements EventManager {

    
    	
	@Override
	  @RequestMapping(method=RequestMethod.GET,path="/{id}")
	public List<Event> retrieveEvent(@PathVariable String id) throws Exception {
	    
	    List<Event> events = new ArrayList<Event>();
	    events.add(new Event("1","New project Created"));
		return events;
	}





}
