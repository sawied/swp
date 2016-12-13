package com.danan.business.smot.rest.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danan.business.smot.domain.Event;
import com.danan.business.smot.rest.EventManager;

@RestController
@RequestMapping("/event/*")
public class EventManagerImpl implements EventManager {

	@Override
	public List<Event> retrieveEvent() throws Exception {
		return null;
	}





}
