/**
 * Module: Booking Module
 * Sub Modules: Booking, Cancellation, Review
 * Aim: To provide the service for booking module
 * Author: Srijan Singh
 * Date: 07/06/2023 
 */
package com.ibm.bookingmodule.service;

import com.ibm.bookingmodule.entity.Booking;
import com.ibm.bookingmodule.entity.Cancellation;
import com.ibm.bookingmodule.entity.Review;

/**
 * Interface for Booking Service
 */
public interface BookingService {
    
    /**
     * Method to make a booking
     * @param booking
     * @return
     */
    int makeBooking(Booking booking);

    /**
     * Method to get booking details
     * @param bookingID
     * @return
     */
    Booking getBookingDetails(int bookingID);

    /**
     * Method to cancel a booking
     * @param cancellation
     * @param bookingID
     * @return
     */
    int cancelBooking(Cancellation cancellation, int bookingID);

    /**
     * Method to get cancellation details
     * @param cancellationID
     * @return
     */
    Cancellation getCancellationDetails(int cancellationID);

    /**
     * Method to review a booking
     * @param review
     * @param bookingID
     * @return
     */
    int reviewBooking(Review review, int bookingID);

    /**
     * Method to get review details
     * @param reviewID
     * @return
     */
    Review getReviewDetails(int reviewID);
}
