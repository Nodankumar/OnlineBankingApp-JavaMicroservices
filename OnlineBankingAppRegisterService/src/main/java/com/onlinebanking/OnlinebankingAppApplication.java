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
public class OnlinebankingAppApplication implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingAppApplication.class, args);
	}
	
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepo.save(new User(null, "Nodankumar", "reddy", "9063607176", "Grogu_dev@gmail.com", "Grogudev", "asdf1234"));
		userRepo.save(new User(null, "Navya", "Meda", "9993607176", "navya@gmail.com", "navya", "asdf1234"));
		userRepo.save(new User(null, "Srikanth", "reddy", "9063331234", "srikanth@gmail.com", "Srikanth", "asdf1234"));
	}
	

}
