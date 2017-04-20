package com.github.sawied.persistent.repositoryTest;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.Address;
import com.github.sawied.persistent.domain.User;
import com.github.sawied.persistent.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sawied/persistent/test/persistent-test-context.xml" })
public class UsersTest {

	@Autowired
	private UserRepository userRepository;
	
	private Address address=null;
	
	@Before
	public void setup(){
		address=new Address();
		address.setAddress("XI'AN");
		address= userRepository.saveOrUpdateAddress(address);
	}
	
	@Test
	public void saveUserAndAddress(){
		User user=new User();
		user.setName("danan");
		//Address address=userRepository.loadAddress(this.address);
		//user.getAddress().add(address);
		//address.getUsers().add(user);
		userRepository.save(user);
	}
	
	
	
	
	@Test
	public void saveUserSuccess(){
		User user=new User();
		user.setName("danan");
		Address address=new Address();
		address.setAddress("XI'AN");
		user.getAddress().add(address);
		userRepository.save(user);
	}
	
}
