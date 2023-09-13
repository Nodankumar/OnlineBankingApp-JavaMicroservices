package com.withdraw;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients
public class OnlinebankingWithdrawResilience4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingWithdrawResilience4jApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}