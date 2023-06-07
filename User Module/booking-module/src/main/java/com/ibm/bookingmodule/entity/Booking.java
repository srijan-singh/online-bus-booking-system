/**
 * Module: Booking Module
 * Aimed to store the booking details of the user
 * IBM - FSD Assignment
 * Author: Srijan Singh
 * Date: 07/06/2023
 * Dependent entities: User, BusSchedule
 */

package com.ibm.bookingmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "status")
    private String status;

    //Foreign key from User Module
    @Column(name = "user_id")
    private int userID;
    //Foreigh key from Bus Schedule Module
    @Column(name = "schedule_id")
    private int scheduleID;

    public Booking(int seatNumber, String status, int userID, int scheduleID) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    public Booking() {
    }

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
