/**
 * Module: User Module
 * Dependencies: Booking Module
 * Aim: To provide the service for user
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.service;

import com.ibm.usermodule.entity.User;

import java.util.List;

import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;
import com.ibm.usermodule.vo.ReviewValueObject;

/**
 * Interface for User Service
 */
public interface UserService {

    /**
     * Method to register a user
     * @param user
     */
    int register(User user);

    /**
     * Method to login a user
     * @param email
     * @param password
     * @return userID
     */
    int login(String email, String password);

    /**
     * Method to update a user
     * @param user
     * @return 
     */
    boolean update(User user);

    /**
     * Method to get a user by ID
     * @param userID
     * @return User
     */
    User getUser(int userID);

    /**
     * Method to get all users
     * @return List<User>
     */
    List<User> getAllUsers();

    /**
     * Method to delete a user
     * @param userID
     * @return
     */
    boolean delete(int userID);

    // Booking Services

    /**
     * Method to book a bus ride
     * @param booking
     * @param userID
     * @return
     */
    BookingTemplate bookBusRide(BookingValueObject booking ,int userID);

    /**
     * Method to cancel a bus ride
     * @param cancellation
     * @param bookingID
     * @return
     */
    CancellationTemplate cancelBusRide(CancellationValueObject cancellation, int bookingID);

    /**
     * Method to review a bus ride
     * @param review
     * @param userID
     * @return
     */
    ReviewTemplate reviewBusRide(ReviewValueObject review, int userID);
}
