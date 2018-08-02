package com.github.sawied.jweb.service;


import org.springframework.data.domain.Page;

import com.github.sawied.jweb.entity.UserEntity;

public interface UserService {

	public UserEntity saveUser(UserEntity user);
	
	public UserEntity findUser(Long id);
	
	public Page<UserEntity> list();
	
}
