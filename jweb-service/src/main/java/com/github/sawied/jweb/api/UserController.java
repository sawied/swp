package com.github.sawied.jweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<UserEntity> getAll(){
		return userService.list();
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public @ResponseBody UserEntity getOne(@PathVariable("id") Long id) {
		return userService.findUser(id);
	}
	
	@RequestMapping("/portrait")
	public void uploadImage(MultipartFile file,HttpServletResponse response) throws IOException {
		IOUtils.copy(file.getInputStream(), response.getOutputStream());
	}
	
	
}
