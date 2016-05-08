package com.github.sawied.persistent.repositoryTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jpa-repository-context.xml"})
public class UserAuditLogTest {
	
	@Autowired
	private UserAuditLogRepository userAuditLogRepository;
	
	@Test
	public void createUserAuditLogTest(){
		Assert.assertNotNull(userAuditLogRepository);
		UserAuditLog userAuditLog = new UserAuditLog();
		userAuditLog.setCode((short) 400);
		userAuditLog.setMessage("invalid invoke.");
		userAuditLogRepository.save(userAuditLog);
		Assert.assertEquals(1, userAuditLogRepository.count());
	}

}
