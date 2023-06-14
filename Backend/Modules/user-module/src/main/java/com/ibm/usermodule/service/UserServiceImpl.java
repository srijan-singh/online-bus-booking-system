/**
 * Module: User Module
 * Dependencies: Booking Module
 * Aim: To provide the service implementation for user
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import com.ibm.usermodule.entity.User;

import java.util.List;

import com.ibm.usermodule.repo.UserRepository;

import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;
import com.ibm.usermodule.vo.ReviewValueObject;

/**
 * Implementation for User Service
 */
@Repository
public class UserServiceImpl implements UserService {

    /**
     * URL for booking module
     */
    private static final String BOOKING_MODULE_URL = "http://localhost:9002/booking/";
    /**
     * URL for cancellation module
     */
    private static final String CANCELLATION_MODULE_URL = "http://localhost:9002/booking/cancel/";
    /**
     * URL for review module
     */
    private static final String REVIEW_MODULE_URL = "http://localhost:9002/booking/review/";

    /**
     * Autowired RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Autowired UserRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to register a user
     * @param user
     */
    @Override
    public int register(User user) {
        userRepository.save(user);
        return user.getId();
    }

    /**
     * Method to login a user
     * @param email
     * @param password
     * @return
     */
    @Override
    public int login(String email, String password) {
        if (userRepository.findByEmailAndPassword(email, password) != null) {
            return userRepository.findByEmail(email).getId();
        }
        return -1;
    }

    /**
     * Method to return a user
     * @param user
     * @return
     */
    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);        
    }

    /**
     * Method to get all users
     * @return List<User>
     */
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Method to update a user
     * @param userID
     * @return
     */
    @Override
    public boolean update(User userNew) {
        User userOld = userRepository.findById(userNew.getId()).orElse(null);
        if (userOld != null) {
            userOld.setName(userNew.getName());
            userOld.setEmail(userNew.getEmail());
            userOld.setPassword(userNew.getPassword());
            userRepository.save(userOld);
            return true;
        }
        return false;
    }

    /**
     * Method to delete a user by ID
     * @param userID
     * @return
     */
    @Override
    public boolean delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    /**
     * Method to book a bus ride
     * @param booking
     * @param userID
     * @return
     */
    @Override
    public BookingTemplate bookBusRide(BookingValueObject booking, int userID) {
        /**
         * Template for booking
         */
        BookingTemplate bookingTemplate = new BookingTemplate();
        
        /**
         * User object to be fetched from database
         */
        User user = userRepository.findById(userID).orElse(null);

        /**
         * If user is not null, then proceed to book the bus ride
         */
        if (user != null) {
            /**
             * Booking ID returned from booking module
             */
            Integer bookingID = restTemplate.postForObject(BOOKING_MODULE_URL, booking, Integer.class);
            /**
             * Booking object returned from booking module
             */
            BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + bookingID, BookingValueObject.class);
            /**
             * Set the booking and user in the template
             */
            bookingTemplate.setBooking(bookingValueObject);
            bookingTemplate.setUser(user);
        }

        return bookingTemplate;
    }

    /**
     * Method to cancel a bus ride
     * @param cancellation
     * @param bookingID
     * @return
     */
    @Override
    public CancellationTemplate cancelBusRide(CancellationValueObject cancellation, int bookingID) {
        /**
         * Template for cancellation
         */
        CancellationTemplate cancellationTemplate = new CancellationTemplate();

        /**
         * Booking object to be fetched from database
         */
        BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + bookingID, BookingValueObject.class);

        /**
         * If booking is not null, then proceed to cancel the bus ride
         */
        if (bookingValueObject != null) {
            /**
             * Cancellation ID returned from cancellation module
             */
            Integer cancellationID = restTemplate.postForObject(CANCELLATION_MODULE_URL + bookingID, cancellation, Integer.class);
            /**
             * Cancellation object returned from cancellation module
             */
            CancellationValueObject cancellationValueObject = restTemplate.getForObject(CANCELLATION_MODULE_URL + "get/" + cancellationID, CancellationValueObject.class);
            /**
             * Set the cancellation and booking in the template
             */
            cancellationTemplate.setCancellation(cancellationValueObject);
            cancellationTemplate.setBooking(bookingValueObject);
        }

        return cancellationTemplate;
    }

    /**
     * Method to review a bus ride
     * @param review
     * @param bookingID
     * @return
     */
    @Override
    public ReviewTemplate reviewBusRide(ReviewValueObject review, int bookingID) {
        /**
         * Template for review
         */
        ReviewTemplate reviewTemplate = new ReviewTemplate();

        /**
         * Booking object to be fetched from database
         */
        BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + bookingID, BookingValueObject.class);

        /**
         * If booking is not null, then proceed to review the bus ride
         */
        if (bookingValueObject != null) {
            /**
             * Review ID returned from review module
             */
            Integer reviewID = restTemplate.postForObject(REVIEW_MODULE_URL + bookingID, review, Integer.class);
            /**
             * Review object returned from review module
             */
            review = restTemplate.getForObject(REVIEW_MODULE_URL + "get/" + reviewID, ReviewValueObject.class);
            /**
             * Set the review and booking in the template
             */
            reviewTemplate.setReview(review);
            reviewTemplate.setBooking(bookingValueObject);
        }

        return reviewTemplate;
    }
    
}
