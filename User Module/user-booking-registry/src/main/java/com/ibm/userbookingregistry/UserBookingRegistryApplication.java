package com.ibm.userbookingregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer	
@SpringBootApplication
public class UserBookingRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserBookingRegistryApplication.class, args);
	}

}
