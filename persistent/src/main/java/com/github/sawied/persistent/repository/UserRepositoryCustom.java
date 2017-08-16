package com.github.sawied.persistent.repository;


import java.util.List;

import com.github.sawied.persistent.domain.Address;
import com.github.sawied.persistent.domain.User;

public interface UserRepositoryCustom {

	User saveOrUpdateUser(User User);

	Address saveOrUpdateAddress(Address address);

	void deleteEntity();

	Address loadAddress(Address id);
	
	List<User> searchUsers();

}