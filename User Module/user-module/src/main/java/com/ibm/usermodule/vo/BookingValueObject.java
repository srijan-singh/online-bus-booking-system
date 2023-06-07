package com.ibm.usermodule.vo;

public class BookingValueObject {
    
    private int id;

    private int seaNumber;

    private String status;

    //Foreign key from User Module
    private int userID;
    //Foreigh key from Bus Schedule Module
    private int scheduleID;
    
    public BookingValueObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeaNumber() {
        return seaNumber;
    }

    public void setSeaNumber(int seaNumber) {
        this.seaNumber = seaNumber;
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
