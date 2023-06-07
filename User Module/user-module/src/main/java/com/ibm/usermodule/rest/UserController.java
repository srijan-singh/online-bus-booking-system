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

import com.ibm.usermodule.entity.Review;
import com.ibm.usermodule.entity.User;
import com.ibm.usermodule.service.UserService;
import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping(value="/user/registeration", consumes="application/json")
    public int registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping(value="/user/login", consumes="application/json")
    public boolean loginUser(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPasword());
    }
    
    @GetMapping(value="/user/get/{userID}", produces="application/json")
    public User getUserByID(@PathVariable int userID) {
        return userService.getUser(userID);
    }

    @PutMapping(value="/user/update", consumes="application/json")
    public boolean updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value="/user/delete/{userID}")
    public boolean deleteUser(@PathVariable int userID) {
        return userService.delete(userID);
    }

    @PostMapping(value="/bookRide/{userID}", consumes="application/json", produces="application/json")
    public BookingTemplate bookBusRide(@RequestBody BookingValueObject booking, @PathVariable int userID) {
        return userService.bookBusRide(booking, userID);
    }

    @PostMapping(value="/cancelRide/{bookingID}", consumes="application/json", produces="application/json")
    public CancellationTemplate cancelBusRide(@RequestBody CancellationValueObject cancellation, @PathVariable int bookingID) {
        return userService.cancelBusRide(cancellation, bookingID);
    }

    @PostMapping(value = "/reviewRide/{bookingID}" ,consumes = "application/json" ,produces = "application/json")
    public ReviewTemplate reviewRide(@RequestBody Review review, @PathVariable int bookingID) {
        return userService.reviewBusRide(review, bookingID);
    }

    
}
