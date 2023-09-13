package com.Microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Microservices.entity.Login;
import com.Microservices.proxy.LoginServiceProxy;


@RestController
public class Loginclientcontroller {
	
	@Autowired
	private LoginServiceProxy loginserviceproxy;
	
	private Logger log = LoggerFactory.getLogger(Loginclientcontroller.class);

	@PostMapping("/login")
	private String Login(@RequestBody Login request) {
		
	log.debug("Request:"+request);
	return loginserviceproxy.login(request);
		 
	}
}
