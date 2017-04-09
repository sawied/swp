package com.danan.business.smot.rest;

import java.util.List;

import com.danan.business.smot.domain.Event;
import com.danan.business.smot.rest.bean.SearchAuditLogResponse;

/**
 * Rest service for Event Manager
 * @author James X W Zhang
 *
 */

public interface EventManager {
	
  
    List<Event> retrieveEvent( String id) throws Exception;
    
    List<SearchAuditLogResponse> searchAuditLog();

}
