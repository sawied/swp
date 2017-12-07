package com.github.sawied.persistent.repositoryTest;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.Address;
import com.github.sawied.persistent.domain.User;
import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sawied/persistent/test/persistent-test-context.xml" })
public class UsersTest {

	@Autowired
	private UserRepository userRepository;
		
	@Test
	public void saveUserSuccess(){
		User user=new User();
		user.setName("danan");
		
		Address address=new Address();
		address.setAddress("XI'AN");
		user.getAddress().add(address);
		
		
		Address otherAddress=new Address();
		otherAddress.setAddress("GUANGZhou");
		user.getAddress().add(otherAddress);
		
		
		
		UserAuditLog userAduditLog1 = new UserAuditLog();
		userAduditLog1.setMessage("msg1");
		userAduditLog1.setUser(user);
		
		UserAuditLog userAduditLog2 = new UserAuditLog();
		userAduditLog2.setMessage("msg2");
		userAduditLog2.setUser(user);
		
		user.getLogs().add(userAduditLog1);
		user.getLogs().add(userAduditLog2);
		
		userRepository.save(user);
	
		
		List<User> list = userRepository.searchUsers();
		
		Assert.assertNotNull(list.get(0).getLogs().get(0).getMessage());
		
	}
	
}
