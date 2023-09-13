package com.serviceRegistry;

import brave.sampler.Sampler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OnlinebankingRegisterUserFeignResilence4jSzApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingRegisterUserFeignResilence4jSzApplication.class, args);
	}
	
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
