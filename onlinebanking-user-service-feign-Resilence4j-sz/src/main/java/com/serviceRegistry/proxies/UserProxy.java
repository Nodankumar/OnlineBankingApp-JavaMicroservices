package com.serviceRegistry.proxies;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serviceRegistry.entities.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient("user-service")
public interface UserProxy {
	
	@Retry(name = "user-service")
	@CircuitBreaker(name = "user-service", fallbackMethod = "getUserByIdfallback")
	@GetMapping("getUserById")
	public Optional<User> getUserById(@RequestParam("id") int id);
	
	@Retry(name = "user-service")
	@CircuitBreaker(name = "user-service", fallbackMethod = "getUserByNamefallback")
	@GetMapping("getUserByName")
	public Optional<User> getUserByName(@RequestParam("username") String username);
	
	@Retry(name = "user-service")
	@CircuitBreaker(name = "user-service", fallbackMethod = "getAllUsersfallback")
	@GetMapping("getAllUsers")
	public List<User> getAllUsers();
	
	public default Optional<User> getUserByIdfallback(int id, Throwable cause) {
    	System.out.println("Exception raised due to "+cause.getMessage());
        return Optional.empty();
    }

    public default Optional<User> getUserByNamefallback(String username, Throwable cause) {
    	System.out.println("Exception raised due to "+cause.getMessage());
        return Optional.empty();
    }

    public default List<User> getAllUsersfallback(Throwable cause) {
    	System.out.println("Exception raised due to "+cause.getMessage());
        return Collections.emptyList();
    }

}
