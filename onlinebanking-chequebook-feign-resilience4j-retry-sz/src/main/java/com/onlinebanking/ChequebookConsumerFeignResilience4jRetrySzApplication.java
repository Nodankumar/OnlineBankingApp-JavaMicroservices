package com.onlinebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients
@SpringBootApplication
public class ChequebookConsumerFeignResilience4jRetrySzApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChequebookConsumerFeignResilience4jRetrySzApplication.class, args);
	}
	
	@Bean
	public Sampler getSampler() {
		
		return Sampler.ALWAYS_SAMPLE;
	}

}
