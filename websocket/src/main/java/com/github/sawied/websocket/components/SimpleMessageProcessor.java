package com.github.sawied.websocket.components;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleMessageProcessor {

	private static final Logger LOGER = LoggerFactory.getLogger(SimpleMessageProcessor.class);

	@Autowired
	private SimpMessagingTemplate template;

	@SubscribeMapping(value = "/time")
	public String subscribeTime(@Headers Map<String, Object> headers) {
		LOGER.info("subecribed with header", headers);
		return "time subscriber";
	}

	@RequestMapping(path = "/triggerTime", method = RequestMethod.GET)
	@ResponseBody
	public String triggerTime() {
		template.convertAndSend("/topic/time", System.currentTimeMillis());
		return "DONE";
	}

	@MessageMapping("time")
	@SendTo("/topic/time")
	public String handle(String greeting) {
		return String.valueOf(System.currentTimeMillis());
	}

}
