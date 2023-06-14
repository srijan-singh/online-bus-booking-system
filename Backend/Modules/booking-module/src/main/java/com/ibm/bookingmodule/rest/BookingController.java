/**
 * Modeule: Booking Module
 * Sub Modules: Booking, Cancellation, Review
 * Aim: To provide REST API services for booking module
 * Author: Srijan Singh
 * Date: 07/06/2023 
 */
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
import com.ibm.bookingmodule.entity.Review;
import com.ibm.bookingmodule.service.BookingService;

@CrossOrigin
@RestController
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    /**
     * This method uses Post Request to book a bus ride
     * @param booking
     * @return bookingID
     */
    @PostMapping(value="/booking", consumes="application/json")
    public int bookBusRide(@RequestBody Booking booking) {
        return bookingService.makeBooking(booking);
    }

    /**
     * This method uses Get Request to get the details of a booked bus ride
     * @param bookingID
     * @return booking
     */
    @GetMapping(value="/booking/get/{bookingID}", produces="application/json")
    public Booking getBusRideDetails(@PathVariable int bookingID) {
        return bookingService.getBookingDetails(bookingID);
    }

    /**
     * This method uses Post Request to cancel a booked bus ride
     * @param cancellation
     * @param bookingID
     * @return cancellationID
     */
    @PostMapping(value="/booking/cancel/{bookingID}", consumes="application/json")
    public int cancelBusRide(@RequestBody Cancellation cancellation, @PathVariable int bookingID) {
        return bookingService.cancelBooking(cancellation, bookingID);
    }

    /**
     * This method uses Get Request to get the details of a cancelled bus ride
     * @param cancellationID
     * @return cancellation
     */
    @GetMapping(value="/booking/cancel/get/{cancellationID}", produces="application/json")
    public Cancellation getCancelledBusRideDetails(@PathVariable int cancellationID) {
        return bookingService.getCancellationDetails(cancellationID);
    }

    /**
     * This method uses Post Request to review a booked bus ride
     * @param review
     * @param bookingID
     * @return reviewID
     */
    @PostMapping(value="/booking/review/{bookingID}", consumes="application/json")
    public int reviewBusRide(@RequestBody Review review, @PathVariable int bookingID) {
        return bookingService.reviewBooking(review, bookingID);
    }

    /**
     * This method uses Get Request to get the details of a reviewed bus ride
     * @param reviewID
     * @return review
     */
    @GetMapping(value="/booking/review/get/{reviewID}", produces="application/json")
    public Review getReviewedBusRideDetails(@PathVariable int reviewID) {
        return bookingService.getReviewDetails(reviewID);
    } 

}
