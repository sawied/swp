package com.danan.intg.http;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danan.business.smot.integration.http.HTTPExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/http/spring-integration-http.xml"})
public class HttpExecutorTest {
	
	@Autowired
	private HTTPExecutor executor;
	
	
	@Test
	public void executeHttpRequestSuccess() {
		
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("url", "http://sawied.top");
		map.put("method", "GET");
		Object obj=executor.execute(map, 1);
		System.out.println(obj);
	}

}
