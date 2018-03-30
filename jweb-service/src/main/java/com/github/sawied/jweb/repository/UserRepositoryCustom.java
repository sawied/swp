package com.github.sawied.jweb.repository;

import com.github.sawied.jweb.entity.User;

public interface UserRepositoryCustom {
	
	User loadUserById(Long id);
	
	User saveUser(User user);

}
