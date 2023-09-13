package com.onlinebanking.services;

import java.util.List;
import java.util.Optional;

import com.onlinebanking.models.User;

public interface UserService {
	
	
	
	public Optional<User> getUserById(int user_id);
	
	public Optional<User> getUserByName(String username);
	
	public List<User> getAllUsers();
}
