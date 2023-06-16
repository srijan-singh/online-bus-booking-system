package com.ibm.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate*/

@SpringBootApplication
public class UserModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserModuleApplication.class, args);
	}

	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

}
