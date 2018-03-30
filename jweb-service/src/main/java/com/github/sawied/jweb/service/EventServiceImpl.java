package com.github.sawied.jweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.sawied.jweb.api.bean.Event;
import com.github.sawied.jweb.entity.EventEntity;
import com.github.sawied.jweb.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Event toggleEvent(Long id){
		EventEntity eventEntity=eventRepository.toggleEvent(id);
		
		Event event =new Event();
		event.setId(eventEntity.getId());
		event.setCompleted(event.getCompleted());
		event.setCreateTime(event.getCreateTime());
		event.setStatus(event.getStatus());
		event.setText(event.getText());
		
		return event;
	}
	
	
}
