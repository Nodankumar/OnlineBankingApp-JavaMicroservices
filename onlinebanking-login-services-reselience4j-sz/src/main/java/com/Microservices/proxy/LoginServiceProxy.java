package com.Microservices.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Microservices.entity.Login;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("login-service")
public interface LoginServiceProxy {
	
	@Retry(name="login-service")
	@CircuitBreaker(name="login-service",fallbackMethod="fallbackmethodforLogin")
	@PostMapping("/login")
    public String login(@RequestBody Login request);
	
	public default String fallbackmethodforLogin(Login request,Throwable cause) {
		
		System.out.println("Exception raised due to :"+cause.getMessage());
		return "fallback method";
    
}	
}
	


