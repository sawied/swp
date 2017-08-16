package com.danan.business.smot.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.sawied.ws.model.hub.OpDefRqst;
import com.github.sawied.ws.model.hub.RqstPayload;

@Controller
public class WebServiceClient {

	
	@Autowired
	@Qualifier("wsInputChannel")
	private MessageChannel mc =null;
	
	@RequestMapping("/cdValue")
	@ResponseBody
	public String invokeWebService() {
		MessagingTemplate mt =new MessagingTemplate(mc);
		OpDefRqst rqst = new OpDefRqst();
		rqst.setSeq("1");
		rqst.setValue("<>26358");
		
		RqstPayload repy = new RqstPayload();
		repy.setOpDefRqst(rqst);
		Message<RqstPayload> request = MessageBuilder.withPayload(repy).build();
		
		mt.sendAndReceive(request);
		
		return "DONE";
	}
	
}
