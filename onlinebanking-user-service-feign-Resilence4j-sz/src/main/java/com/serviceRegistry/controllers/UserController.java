package com.serviceRegistry.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serviceRegistry.entities.User;
import com.serviceRegistry.proxies.UserProxy;

@RestController
public class UserController {
	
	@Autowired
	private UserProxy userProxy;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("getUserById")
	public Optional<User> getUserById(@RequestParam("id") int id){
		log.debug("In getUserBYId, id is - "+ id);
		Optional<User> user =  userProxy.getUserById(id);
		log.debug("In getUserBYId, user is - "+ user);
		return user;
	};
	
	@GetMapping("getUserByName")
	public Optional<User> getUserByName(@RequestParam("username") String username){
		Optional<User> user =  userProxy.getUserByName(username);
		log.debug("In getUserByUsername, user is - "+ user);
		return user;
	};
	
	@GetMapping("getAllUsers")
	public List<User> getAllUsers(){
		List<User> users = userProxy.getAllUsers();
		log.debug("In getAllUsers, users is - "+ users);
		return users;
	};

}
