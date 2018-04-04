package com.github.sawied.jweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.sawied.jweb.entity.EventEntity;

public interface EventService {

	EventEntity toggleEvent(Long id);
	
	Page<EventEntity> searchEvent(Pageable request);
	
	EventEntity createEvent(EventEntity event);
	
	EventEntity deleteEvent(Long id);

}
