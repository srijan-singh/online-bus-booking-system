/**
 * Module: Booking Module
 * Sub Module: Booking
 * Dependencies: User, BusSchedule
 * Aim: To provide the entity for booking
 * Author: Srijan Singh
 * Date: 07/06/2023
 */

package com.ibm.bookingmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
    
    /**
     * Booking ID
     */
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int id;

    /**
     * Seat Number
     */
    @Column(name = "seat_number")
    private int seatNumber;

    /**
     * Status of the booking
     * Booked
     * Cancelled
     * Reviwed
     */
    @Column(name = "status")
    private String status;

    /**
     * User ID
     * Foreign key from User Module
     */
    @Column(name = "user_id")
    private int userID;         //Foreign key from User Module
    
    /**
     * Schedule ID
     * Foreign key from Bus Schedule Module
     */
    @Column(name = "schedule_id")
    private int scheduleID;     //Foreigh key from Bus Schedule Module

    /**
     * Constructor
     */
    public Booking(int id, int seatNumber, String status, int userID, int scheduleID) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.status = status;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }
    
    public Booking() {
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

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seaNumber) {
        this.seatNumber = seaNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }


}
