package com.github.sawied.jweb.repository;

import com.github.sawied.jweb.entity.UserEntity;

public interface UserRepositoryCustom {
	
	UserEntity loadUserById(Long id);
	
	UserEntity saveUser(UserEntity user);

}
