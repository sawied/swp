package com.github.sawied.jweb.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.github.sawied.jweb.entity.UserEntity;
import com.github.sawied.jweb.repository.UserRepository;


public class UserServiceImpl implements UserService{

	private Resource resource = new ClassPathResource("github/sawied/jweb/notes.xml");
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		try {
			user.setXmlData(IOUtils.toByteArray(resource.getInputStream()));
			return userRepository.save(user);
			
		} catch (IOException e) {
		}
		return user;
	}

	@Override
	public UserEntity findUser(Long id) {
		return userRepository.findOne(id);
	}

}
