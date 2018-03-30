package com.github.sawied.jweb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.sawied.jweb.entity.EventEntity;

public class EventRepositoryImpl implements EventRepositoryCustom {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public EventEntity toggleEvent(Long id) {
		EventEntity event=entityManager.getReference(EventEntity.class, id);
		event.setCompleted(!event.getCompleted());
		entityManager.persist(event);
		return event;
	}

}
