package com.ibm.apiregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer	
@SpringBootApplication
public class ApiRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRegistryApplication.class, args);
	}

}
