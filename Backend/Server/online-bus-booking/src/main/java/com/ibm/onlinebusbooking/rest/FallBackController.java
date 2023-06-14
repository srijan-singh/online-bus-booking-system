package com.ibm.onlinebusbooking.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin
@RestController
public class FallBackController {
    
    @GetMapping(value="/userFallBack")
    public String userFallBack(){
        return "User Service is taking longer than Expected.\n" +
                " Please try again later";
    }

    @GetMapping(value = "/bookingFallBack")
    public String bookingFallBack(){
        return "Booking Service is taking longer than Expected.\n" +
                " Please try again later";
    }
    
    @GetMapping(value = "/routeFallBack")
    public String rootFallBack(){
        return "Routing Service is taking longer than Expected.\n" +
                " Please try again later";
    }
    
    @GetMapping(value = "/scheduleFallBack")
    public String scheduleFallBack(){
        return "Scheduling Service is taking longer than Expected.\n" +
                " Please try again later";
    }
    
    @GetMapping(value = "/paymentFallBack")
    public String paymentFallBack(){
        return "Payment Service is taking longer than Expected.\n" +
                " Please try again later";
    }
}
