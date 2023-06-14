/**
 * Module: User Module
 * Aim: To provide the user related services as RESTful APIs
 * Services: USER REGISTRATION, USER LOGIN, GET USER BY ID, UPDATE USER, DELETE USER, BOOK RIDE, CANCEL RIDE, REVIEW RIDE
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.usermodule.entity.User;
import com.ibm.usermodule.service.UserService;
import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;
import com.ibm.usermodule.vo.ReviewValueObject;

/**
 * Rest Controller for User Module
 * CrossOrigin annotation is used to allow cross origin requests
 */
@CrossOrigin
@RestController
public class UserController {
    
    /**
     * Autowiring the user service
     */
    @Autowired
    private UserService userService;

    /**
     * Method to register a user
     * @param user
     * @return userID
     */
    @PostMapping(value="/user/registeration", consumes="application/json")
    public int registerUser(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * Method to login a user
     * @param user
     * @return userID
     */
    @PostMapping(value="/user/login", consumes="application/json")
    public int loginUser(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }
    
    /**
     * Method to get user by ID
     * @param userID
     * @return user
     */
    @GetMapping(value="/user/get/{userID}", produces="application/json")
    public User getUserByID(@PathVariable int userID) {
        return userService.getUser(userID);
    }

    /**
     * Method to update user
     * @param user
     * @return
     */
    @PutMapping(value="/user/update", consumes="application/json")
    public boolean updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Method to delete user
     * @param userID
     * @return
     */
    @DeleteMapping(value="/user/delete/{userID}")
    public boolean deleteUser(@PathVariable int userID) {
        return userService.delete(userID);
    }

    /**
     * Method to book a bus ride
     * @param booking
     * @param userID
     * @return
     */
    @PostMapping(value="/user/bookRide/{userID}", consumes="application/json", produces="application/json")
    public BookingTemplate bookBusRide(@RequestBody BookingValueObject booking, @PathVariable int userID) {
        return userService.bookBusRide(booking, userID);
    }

    /**
     * Method to cancel a bus ride
     * @param cancellation
     * @param bookingID
     * @return
     */
    @PostMapping(value="/user/cancelRide/{bookingID}", consumes="application/json", produces="application/json")
    public CancellationTemplate cancelBusRide(@RequestBody CancellationValueObject cancellation, @PathVariable int bookingID) {
        return userService.cancelBusRide(cancellation, bookingID);
    }

    /**
     * Method to review a bus ride
     * @param review
     * @param bookingID
     * @return
     */
    @PostMapping(value = "/user/reviewRide/{bookingID}" ,consumes = "application/json" ,produces = "application/json")
    public ReviewTemplate reviewRide(@RequestBody ReviewValueObject review, @PathVariable int bookingID) {
        return userService.reviewBusRide(review, bookingID);
    }

    
}
