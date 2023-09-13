package com.serviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OnlinebankingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingEurekaServerApplication.class, args);
	}

}
