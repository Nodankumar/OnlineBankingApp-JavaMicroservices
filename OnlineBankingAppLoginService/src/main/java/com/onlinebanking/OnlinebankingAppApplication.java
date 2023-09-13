package com.onlinebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.onlinebanking.models.User;
import com.onlinebanking.repositories.UserRepo;

import brave.sampler.Sampler;

@EnableEurekaClient
@SpringBootApplication
public class OnlinebankingAppApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingAppApplication.class, args);
	}
	
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	
	

}
