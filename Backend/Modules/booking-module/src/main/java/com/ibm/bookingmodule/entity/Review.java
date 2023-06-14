/**
 * Module: Booking Module
 * Sub Module: Review
 * Dependencies: User
 * Aim: To provide the entity for review module
 * Author: Srijan Singh
 * Date: 07/06/2023 
 */
package com.ibm.bookingmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    /**
     * Review ID
     */
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private int id;

    /**
     * Rating
     */
    @Column(name = "rating")
    private int rating;

    /**
     * Comment
     */
    @Column(length = 50)
    private String comment;

    /**
     * User ID
     * Foreign key from User Module
     */
    @Column(name = "user_id")
    private int userID;         //Foreign key from User Module

    /**
     * Constructor
     */
    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Review() {
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
