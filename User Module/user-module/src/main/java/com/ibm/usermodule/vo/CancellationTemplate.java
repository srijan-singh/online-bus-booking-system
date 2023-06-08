/**
 * Module: User Module
 * Dependency: CancellationValueObject, BookingValueObject
 * Aim: To provide template for cancellation
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

/**
 * Template for Cancellation
 */
public class CancellationTemplate {

    /**
     * Booking details
     */
    private BookingValueObject booking;

    /**
     * Cancellation details
     */
    private CancellationValueObject cancellation;

    /**
     * Constructor
     */
    public CancellationTemplate() {
    }

    /**
     * Getter and Setter
     */
    public CancellationValueObject getCancellation() {
        return cancellation;
    }

    public void setCancellation(CancellationValueObject cancellation) {
        this.cancellation = cancellation;
    }

    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
