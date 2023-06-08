/**
 * Module: User Module
 * Aim: To provide the value object for booking
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

/**
 * Value object for booking
 */
public class BookingValueObject {
   
    /**
     * Attributes
     */
    private int id;
    private int seatNumber;
    private String status;
    private int userID;         // Foreign key
    private int scheduleID;     // Foreign key

    /**
     * Constructor
     */
    public BookingValueObject() {
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

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
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
