package com.danan.business.smot.rest.impl;

import com.danan.business.smot.domain.Event;
import com.danan.business.smot.rest.EventManager;
import com.danan.business.smot.rest.NotEventException;
import com.danan.business.smot.rest.bean.SearchAuditLogResponse;
import com.github.sawied.persistent.domain.SearchAuditResponse;
import com.github.sawied.persistent.repository.UserAuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events/*")
@ResponseBody
public class EventManagerImpl implements EventManager {
    
    @Autowired(required=false)
    private UserAuditLogRepository userAuditLogRepository=null;

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public List<Event> retrieveEvent(@PathVariable String id) throws Exception {

	if (StringUtils.isEmpty(id) || id.length() > 3) {
	    throw new NotEventException(Long.valueOf(id),
		    "cann't find the event entity in database");
	}

	List<Event> events = new ArrayList<Event>();
	events.add(new Event("1", "New project Created"));
	return events;
    }

    @Override
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public List<SearchAuditLogResponse> searchAuditLog() {
	 List<SearchAuditResponse> searchAuditUseResultMapping = userAuditLogRepository.searchAuditUseResultMapping();
	 return null;
    }

}
