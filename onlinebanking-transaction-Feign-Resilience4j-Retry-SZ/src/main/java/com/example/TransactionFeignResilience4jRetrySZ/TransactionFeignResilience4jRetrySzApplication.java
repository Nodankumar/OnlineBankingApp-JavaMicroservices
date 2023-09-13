package com.example.TransactionFeignResilience4jRetrySZ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableFeignClients
@SpringBootApplication
public class TransactionFeignResilience4jRetrySzApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionFeignResilience4jRetrySzApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


}
