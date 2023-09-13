package com.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.Login;
import com.onlinebanking.models.User;
import com.onlinebanking.servicesImplementation.Loginservice;



@RestController
@Scope("request")
public class LoginController {
	
	@Autowired
	private Loginservice loginservice;
	
	@PostMapping("/login")
    public String login(@RequestBody Login request) {
        String username = request.getUsername();
        String password = request.getPassword();
        List<User>  users = loginservice.getAllAccounts();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "Login successful!";
            }
        }

        return "Login failed. Invalid username or password.";
    } 
}
	


