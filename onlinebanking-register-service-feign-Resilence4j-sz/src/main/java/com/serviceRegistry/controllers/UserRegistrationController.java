package com.serviceRegistry.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serviceRegistry.entities.User;
import com.serviceRegistry.proxies.UserRegistrationProxy;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationProxy userRegistrationProxy;
	
	private Logger log = LoggerFactory.getLogger(UserRegistrationController.class);
	
	@PostMapping("registerUser")
	public  void addUser(@RequestBody User user) {
		log.debug("In Adduser, user is - "+ user);
		userRegistrationProxy.addUser(user);
	}

}
