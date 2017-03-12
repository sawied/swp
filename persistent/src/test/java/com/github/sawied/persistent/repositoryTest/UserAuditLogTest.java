package com.github.sawied.persistent.repositoryTest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sawied/persistent/test/persistent-test-context.xml" })
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
	userAuditLog.setMessage("0");
	userAuditLogRepository.save(userAuditLog);
	Assert.assertEquals(1, userAuditLogRepository.count());
    }

    @Test
    public void searchAuditLogTest() {
	PageRequest page = new PageRequest(10, 1);
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("message", "0");
	Page<UserAuditLog> result = userAuditLogRepository.searchUserLog(map, page);
	Assert.assertEquals(1, result.getSize());

    }

}
