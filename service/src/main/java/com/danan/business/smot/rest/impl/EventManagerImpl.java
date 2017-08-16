package com.danan.business.smot.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danan.business.smot.domain.Event;
import com.danan.business.smot.rest.EventManager;
import com.danan.business.smot.rest.NotEventException;
import com.danan.business.smot.rest.bean.SearchAuditLogResponse;
import com.github.sawied.persistent.domain.SearchAuditResponse;
import com.github.sawied.persistent.repository.UserAuditLogRepository;

@RestController
@RequestMapping("/events/*")
@ResponseBody
public class EventManagerImpl implements EventManager {
    
    @Autowired
    private UserAuditLogRepository userAuditLogRepository=null;
    

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
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
