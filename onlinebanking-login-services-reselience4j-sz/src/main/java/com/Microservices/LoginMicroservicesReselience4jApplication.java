package com.Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableFeignClients

@SpringBootApplication
public class LoginMicroservicesReselience4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginMicroservicesReselience4jApplication.class, args);
		
	}
	@Bean
	public Sampler getSampler() {
		
		return Sampler.ALWAYS_SAMPLE;
	}

}
