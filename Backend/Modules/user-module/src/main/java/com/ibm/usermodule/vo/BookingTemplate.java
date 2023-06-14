/**
 * Module: User Module
 * Dependency: User, BookingValueObject
 * Aim: To provide template for booking
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

import com.ibm.usermodule.entity.User;

/**
 * Template for booking
 */
public class BookingTemplate {

    /**
     * User who is booking
     */
    private User user;

    /**
     * Booking details
     */
    private BookingValueObject booking;

    /**
     * Constructor
     */
    public BookingTemplate() {
    }

    /**
     * Getter and Setter
     */
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
