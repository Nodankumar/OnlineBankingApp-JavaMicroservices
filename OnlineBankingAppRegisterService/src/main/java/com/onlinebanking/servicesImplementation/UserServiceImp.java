package com.onlinebanking.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.User;
import com.onlinebanking.repositories.UserRepo;
import com.onlinebanking.services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepo registerRepo;
	
	@Override
	public void addUser(User user) {
	    registerRepo.save(user);
	}

	
	



}
