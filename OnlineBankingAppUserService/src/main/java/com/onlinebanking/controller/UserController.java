package com.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.User;
import com.onlinebanking.servicesImplementation.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@GetMapping("getUserById")
	public Optional<User> getUserById(@RequestParam("id") int id) {
		
		return userService.getUserById(id);	
	}
	
	@GetMapping("getUserByName")
	public Optional<User> getUserByName(@RequestParam("username") String username) {	
		
		return userService.getUserByName(username);	
	}
	
	@GetMapping("getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
