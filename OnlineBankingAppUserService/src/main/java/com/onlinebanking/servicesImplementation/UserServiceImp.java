package com.onlinebanking.servicesImplementation;

import java.util.List;
import java.util.Optional;

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
	public Optional<User> getUserById(int user_id) {
		
		return registerRepo.findById(user_id);
	}

	@Override
	public Optional<User> getUserByName(String username) {
		
		return registerRepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		
		return registerRepo.findAll();
	}
	



}
