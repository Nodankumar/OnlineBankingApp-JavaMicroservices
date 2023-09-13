package com.serviceRegistry.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.serviceRegistry.entities.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient("register-service")
public interface UserRegistrationProxy {
	
	@Retry(name = "register-service")
	@CircuitBreaker(name = "banking-service", fallbackMethod = "addUserFallback")
	@PostMapping("registerUser")
	public void addUser(@RequestBody User user);
	
	public default void addUserFallback(User user, Throwable cause) {
			System.out.println("Exception raised with message: "+cause.getMessage());
	        System.err.println("Fallback: Error occurred while adding a user.");
	}

}
