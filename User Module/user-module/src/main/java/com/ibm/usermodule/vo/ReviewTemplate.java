package com.ibm.usermodule.vo;

import com.ibm.usermodule.entity.Review;

public class ReviewTemplate {

    private Review review;

    private BookingValueObject booking;

    public ReviewTemplate() {
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    
    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
