package com.github.sawied.persistent.repositoryTest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:sawied/persistent/test/persistent-test-context.xml"})
public class UserAuditLogTest {
	
	@Autowired
	private UserAuditLogRepository userAuditLogRepository;
	
	
	@BeforeClass
	public static void setup(){
		
	}
	
	@Test
	public void createUserAuditLogTest(){
		Assert.assertNotNull(userAuditLogRepository);
		UserAuditLog userAuditLog = new UserAuditLog();
		userAuditLog.setCode((short) 400);
		userAuditLog.setMessage("invalid invoke.");
		userAuditLogRepository.save(userAuditLog);
		Assert.assertEquals(1, userAuditLogRepository.count());
	}
	
	
	public void searchAuditLogTest(){
		userAuditLogRepository.findAll(new Specification<UserAuditLog>(){

			@Override
			public Predicate toPredicate(Root<UserAuditLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return cb.like(root.get("message"), "xx");
			}
			
		}, new PageRequest(0,10));
	}
	
	
	

}
