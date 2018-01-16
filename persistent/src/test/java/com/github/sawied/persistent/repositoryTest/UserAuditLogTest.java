package com.github.sawied.persistent.repositoryTest;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.AuditLogDetail;
import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sawied/persistent/test/persistent-test-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAuditLogTest {

    @Autowired
    private UserAuditLogRepository userAuditLogRepository;

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void createUserAuditLogTest() {
	Assert.assertNotNull(userAuditLogRepository);
	UserAuditLog userAuditLog = new UserAuditLog();
	userAuditLog.setCode((short) 400);
	userAuditLog.setMessage("000");
	AuditLogDetail details=new AuditLogDetail("logon","user "+userAuditLog.getCode() +"sign in system.");
	details.setAuditLog(userAuditLog);
	userAuditLog.getLogDetails().add(details);
	UserAuditLog result = userAuditLogRepository.save(userAuditLog);
	Assert.assertNotNull(result);
    }
    

    @Test
    public void searchUserSuccess(){
    	Assert.assertEquals(1, userAuditLogRepository.count());
    	List<UserAuditLog> logs = userAuditLogRepository.searchLastAuditLog("400");
    	Assert.assertTrue("should have a record with 400 code", !logs.isEmpty());
    }
    

  
    @Test
    @Ignore
    public void searchAuditLogTest() {
    	
	Sort.Order order = new Sort.Order(Direction.ASC,"message");
    
	Sort sort = new Sort(order);
    	
	PageRequest page = new PageRequest(0, 10,sort);
	HashMap<String, Object> map = new HashMap<String, Object>();
	//map.put("message", "0");
	
	Page<UserAuditLog> result = userAuditLogRepository.searchUserLog(map, page);
	Assert.assertEquals(1, result.getTotalElements());

    }

}
