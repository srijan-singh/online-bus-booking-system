/**
 * Module: Booking Module
 * Sub Modules: Booking, Cancellation, Review
 * Aim: To provide the service implementation for booking module
 * Author: Srijan Singh
 * Date: 07/06/2023 
 */
package com.ibm.bookingmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.bookingmodule.entity.Booking;
import com.ibm.bookingmodule.entity.Cancellation;
import com.ibm.bookingmodule.entity.Review;
import com.ibm.bookingmodule.repo.BookingRepository;
import com.ibm.bookingmodule.repo.CancellationRepository;
import com.ibm.bookingmodule.repo.ReviewRepository;

@Repository
public class BookingServiceImpl implements BookingService {

    /**
     * Autowiring the booking repository
     */
    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Autowiring the cancellation repository
     */
    @Autowired
    private CancellationRepository cancellationRepository;

    /**
     * Autowiring the review repository
     */
    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Method to make a booking
     * @param booking
     * @return bookingID
     */
    @Override
    public int makeBooking(Booking booking) {
        bookingRepository.save(booking);
        return booking.getId();
    }

    /**
     * Method to get booking details
     * @param bookingID
     * @return booking
     */
    @Override
    public Booking getBookingDetails(int bookingID) {
        return bookingRepository.findById(bookingID).orElse(null);
    }
    
    /**
     * Method to get bookings from userID
     * @param userID
     * @return List<booking>
     */
    @Override
	public List<Booking> getBookingDetailsByUserID(int userID) {
		return bookingRepository.getBookingsByUserID(userID);
	}

    /**
     * Method to cancel a booking
     * @param cancellation
     * @param bookingID
     * @return cancellationID
     */
    @Override
    public int cancelBooking(Cancellation cancellation, int bookingID) {
        Booking booking = bookingRepository.findById(bookingID).orElse(null);
        if(booking != null) {
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
            cancellation.setBooking(booking);
            cancellationRepository.save(cancellation);
            return cancellation.getId();
        }   
        return -1;
    }

    /**
     * Method to get cancellation details
     * @param cancellationID
     * @return cancellation
     */
    @Override
    public Cancellation getCancellationDetails(int cancellationID) {
        return cancellationRepository.findById(cancellationID).orElse(null);
    }

    /**
     * Method to review a booking
     * @param review
     * @param bookingID
     * @return reviewID
     */
    @Override
    public int reviewBooking(Review review, int bookingID) {
        Booking booking = bookingRepository.findById(bookingID).orElse(null);
        if(booking != null) {
            booking.setStatus("Reviewed");
            review.setUserID(booking.getUserID());
            reviewRepository.save(review);
            return review.getId();
        }
        return -1;
    }

    /**
     * Method to get review details
     * @param reviewID
     * @return review
     */
    @Override
    public Review getReviewDetails(int reviewID) {
        return reviewRepository.findById(reviewID).orElse(null);
    }
    
}
