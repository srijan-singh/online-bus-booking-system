package com.ibm.usermodule.vo;

public class CancellationValueObject {

    private int id;

    private int rating;

    private String comment;

    private BookingValueObject booking;

    public CancellationValueObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}
