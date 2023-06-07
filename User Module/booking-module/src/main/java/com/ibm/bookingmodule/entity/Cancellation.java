/**
 * Main Module: Booking Module
 * Sub Module: Cancellation
 * Description: Contains required details for Cancellation
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
    
    @Id
    @GeneratedValue
    @Column(name = "cancellation_id")
    private int id;

    private String reason;

    // Booking
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Cancellation(String reason) {
        this.reason = reason;
    }

    public Cancellation() {
    }

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
