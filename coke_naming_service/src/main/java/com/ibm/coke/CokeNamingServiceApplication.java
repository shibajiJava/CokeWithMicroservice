package com.ibm.coke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CokeNamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CokeNamingServiceApplication.class, args);
	}
	
}
