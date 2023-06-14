/**
 * Module: User Module
 * Aim: To provide template for review
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.vo;

public class ReviewValueObject {
    
    /**
     * Attributes
     */
    private int id;

    private int rating;

    private String comment;

    private int userID;

    /**
     * Constructor
     */
    public ReviewValueObject() {
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
