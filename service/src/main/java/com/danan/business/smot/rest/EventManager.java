package com.danan.business.smot.rest;

import java.util.List;

import com.danan.business.smot.domain.Event;

/**
 * Rest service for Event Manager
 * @author James X W Zhang
 *
 */

public interface EventManager {
	
  
    List<Event> retrieveEvent( String id) throws Exception;

}
