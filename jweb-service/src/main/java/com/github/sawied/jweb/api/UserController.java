package com.github.sawied.jweb.api;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.jweb.api.bean.PersonInfo;
import com.github.sawied.jweb.entity.UserEntity;
import com.github.sawied.jweb.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody UserEntity save(@Valid @RequestBody PersonInfo personInfo) {
		UserEntity user=new UserEntity();
		user.setName(personInfo.getName());
		return userService.saveUser(user);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public @ResponseBody UserEntity getOne(@PathVariable("id") Long id) {
		return userService.findUser(id);
	}
	
	
}
