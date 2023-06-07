package com.ibm.bookingmodule.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bookingmodule.entity.Booking;
import com.ibm.bookingmodule.entity.Cancellation;
import com.ibm.bookingmodule.service.BookingService;

@CrossOrigin
@RestController
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping(value="/booking", consumes="application/json")
    public int bookBusRide(@RequestBody Booking booking) {
        return bookingService.makeBooking(booking);
    }

    @GetMapping(value="/booking/get/{bookingID}", produces="application/json")
    public Booking getBusRideDetails(@PathVariable int bookingID) {
        return bookingService.getBookingDetails(bookingID);
    }

    @PostMapping(value="/booking/cancel/{bookingID}", consumes="application/json")
    public int cancelBusRide(@RequestBody Cancellation cancellation, @PathVariable int bookingID) {
        return bookingService.cancelBooking(cancellation, bookingID);
    }

    @GetMapping(value="/booking/cancel/get/{cancellationID}", produces="application/json")
    public Cancellation getCancelledBusRideDetails(@PathVariable int cancellationID) {
        return bookingService.getCancellationDetails(cancellationID);
    }

}
