package com.github.sawied.websocket;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.sawied.websocket.config.Jackson2Config;
import com.github.sawied.websocket.paging.UserInfo;
/**
 * solution1: implement SimpleModule
 * solution2: JsonDeserializer
 * @author James X W Zhang
 *  JsonComponentModule
 */ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {Jackson2Config.class})
public class JacksonPagingTest {
	
	private ObjectMapper objectMapper;
	
	private Page<UserInfo> pi=null;
	
	@Autowired
	private JsonComponentModule jsonComponentModule;
	
	@Before
	public void init() {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(jsonComponentModule);
		
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo ui = new UserInfo();ui.setId(1L);ui.setName("sawied");
		list.add(ui);
		
		Sort sort = new Sort("name");
		//page ,size,order
		Pageable pageable = new PageRequest(0,1,sort);
		
		pi=new PageImpl<UserInfo>(list, pageable, 10);
		
	}

	@Test
	public void testDeserializeSuccess() throws IOException {
		
			String str=objectMapper.writeValueAsString(pi);
			System.out.println("JSON: \n" + str);
			Assert.assertNotNull(str);
			Page<UserInfo> page=objectMapper.readValue(str,new TypeReference<Page<UserInfo>>(){});
			System.out.println("result:" + page);
		
	}

}
