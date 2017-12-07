package com.github.sawied.persistent.repositoryTest;

import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.AuditLogDetail;
import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;
import com.github.sawied.persistent.repository.UserAuditLogRepositoryImpl;

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
	userAuditLog.setMessage("000");
	AuditLogDetail details=new AuditLogDetail("logon","user "+userAuditLog.getCode() +"sign in system.");
	details.setAuditLog(userAuditLog);
	userAuditLog.getLogDetails().add(details);
	userAuditLogRepository.save(userAuditLog);
	Assert.assertEquals(1, userAuditLogRepository.count());
    }
    
    @Ignore
    @Test
    public void searchUserSuccess(){
    	final String name ="0";
    	/** List<UserAuditLog> result = userAuditLogRepository.findAll(new Specification<UserAuditLog>() {
			@Override
			public Predicate toPredicate(Root<UserAuditLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.<String>get("message"), "%"+name+"%");
			}
		});
    	Assert.assertEquals(1, result.size());
    	**/
    }
    

  
    @Test
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
