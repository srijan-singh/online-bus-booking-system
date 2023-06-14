/**
 * Module: User Module
 * Dependency: ReviewValueObject, BookingValueObject
 * Aim: To provide template for review
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

/**
 * Template for review
 */
public class ReviewTemplate {

    /**
     * Review details
     */
    private ReviewValueObject review;

    /**
     * Booking details
     */
    private BookingValueObject booking;

    /**
     * Constructor
     */
    public ReviewTemplate() {
    }

    /**
     * Getter and Setter
     */
    public ReviewValueObject getReview() {
        return review;
    }

    public void setReview(ReviewValueObject review) {
        this.review = review;
    }
    
    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
