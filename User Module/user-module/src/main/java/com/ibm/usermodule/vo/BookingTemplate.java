package com.ibm.usermodule.vo;

import com.ibm.usermodule.entity.User;

public class BookingTemplate {

    private User user;

    private BookingValueObject booking;

    public BookingTemplate() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
