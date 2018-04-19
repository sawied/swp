package com.github.sawied.jweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.sawied.jweb.entity.EventEntity;
import com.github.sawied.jweb.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	
	/**
	 *toggle specific event's status and retrieve latest data. 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public EventEntity toggleEvent(Long id){
		 
		 return eventRepository.toggleEvent(id);
	}


	@Override
	public Page<EventEntity> searchEvent(Pageable request) {
		
		return eventRepository.findAll(request);
	}


	@Override
	public EventEntity createEvent(EventEntity event) {
		return eventRepository.save(event);
	}


	@Override
	public EventEntity deleteEvent(Long id) {
		EventEntity event = eventRepository.findOne(id);
		eventRepository.delete(event);
		return event;
	}
	
	
}
