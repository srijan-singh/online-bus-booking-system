package com.ibm.onlinebusbooking.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.onlinebusbooking.entity.FallBack;

import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin
@RestController
public class FallBackController {
	
	private FallBack fallBack;
    
    public FallBackController() {
		this.fallBack = new FallBack();
	}

	@GetMapping(value="/userFallBack")
    public FallBack userFallBack(){
        fallBack.setServiceName("User");
    	return fallBack;
    }

    @GetMapping(value = "/bookingFallBack")
    public FallBack bookingFallBack(){
    	fallBack.setServiceName("Booking");
    	return fallBack;
    }
    
    @GetMapping(value = "/routeFallBack")
    public FallBack routeFallBack(){
    	fallBack.setServiceName("Route");
    	return fallBack;
    }
    
    @GetMapping(value = "/scheduleFallBack")
    public FallBack scheduleFallBack(){
    	fallBack.setServiceName("Schedule");
    	return fallBack;
    }
    
    @GetMapping(value = "/paymentFallBack")
    public FallBack paymentFallBack(){
    	fallBack.setServiceName("Payment");
    	return fallBack;
    }
}
