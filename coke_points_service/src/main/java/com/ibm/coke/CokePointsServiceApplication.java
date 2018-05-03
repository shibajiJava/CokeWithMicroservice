package com.ibm.coke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan; 



@SpringBootApplication
@ComponentScan("com.ibm")
@EnableFeignClients("com.ibm.cok.proxy")
@EnableDiscoveryClient
public class CokePointsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CokePointsServiceApplication.class, args);
	}
	

}
