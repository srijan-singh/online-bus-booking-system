package com.ibm.onlinebusbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class OnlineBusBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBusBookingApplication.class, args);
	}

}
