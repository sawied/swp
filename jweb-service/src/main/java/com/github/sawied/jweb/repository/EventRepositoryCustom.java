package com.github.sawied.jweb.repository;

import com.github.sawied.jweb.entity.EventEntity;

public interface EventRepositoryCustom {

	EventEntity toggleEvent(Long id);
	
}
