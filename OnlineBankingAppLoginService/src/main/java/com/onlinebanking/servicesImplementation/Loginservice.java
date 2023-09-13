package com.onlinebanking.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.User;
import com.onlinebanking.repositories.UserRepo;
import com.onlinebanking.services.ILoginService;

@Service
public class Loginservice implements ILoginService {
	@Autowired
	private UserRepo userrepo;

	@Override
	public List<User> getAllAccounts() {
		
		return userrepo.findAll();
	}
}
