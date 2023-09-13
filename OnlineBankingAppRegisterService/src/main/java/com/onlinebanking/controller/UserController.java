package com.onlinebanking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.User;
import com.onlinebanking.servicesImplementation.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("registerUser")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		log.debug("In addUsee, user id - "+ user);
		userService.addUser(user);
	}
	
	
	
}
