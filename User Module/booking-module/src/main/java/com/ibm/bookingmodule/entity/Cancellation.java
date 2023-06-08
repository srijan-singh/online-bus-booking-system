/**
 * Main Module: Booking Module
 * Sub Module: Cancellation
 * Dependencies: Booking
 * Aim: To provide the entity for cancellation
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.bookingmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cancellation {
    
    /**
     * Cancellation ID
     */
    @Id
    @GeneratedValue
    @Column(name = "cancellation_id")
    private int id;

    /**
     * Reason for cancellation
     */
    private String reason;

    /**
     * Booking ID
     * Foreign key from Booking Module
     */
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    /**
     * Constructor
     */
    public Cancellation(String reason) {
        this.reason = reason;
    }

    public Cancellation() {
    }

    /**
     * Getters and Setters
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
}
