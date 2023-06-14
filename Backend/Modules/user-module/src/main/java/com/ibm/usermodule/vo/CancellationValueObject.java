/**
 * Module: User Module
 * Dependency: BookingValueObject
 * Aim: To provide value object for cancellation
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

/**
 * Value object for cancellation
 */
public class CancellationValueObject {

    /**
     * Attributes
     */
    private int id;

    private String reason;

    private BookingValueObject booking;

    /**
     * Constructor
     */
    public CancellationValueObject() {
    }

    /**
     * Getter and Setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
