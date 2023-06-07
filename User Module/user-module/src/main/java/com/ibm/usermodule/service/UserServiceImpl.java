package com.ibm.usermodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ibm.usermodule.entity.Review;
import com.ibm.usermodule.entity.User;
import com.ibm.usermodule.entity.repo.UserRepository;
import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;

@Repository
public class UserServiceImpl implements UserService {

    private static final String BOOKING_MODULE_URL = "http://localhost:9002/booking/";
    private static final String CANCELLATION_MODULE_URL = "http://localhost:9002/booking/cancel/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public int register(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public boolean login(String email, String password) {
        if (userRepository.findByEmailAndPassword(email, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);        
    }

    @Override
    public boolean update(User userNew) {
        User userOld = userRepository.findById(userNew.getId()).orElse(null);
        if (userOld != null) {
            userOld.setName(userNew.getName());
            userOld.setEmail(userNew.getEmail());
            userOld.setPasword(userNew.getPasword());
            userRepository.save(userOld);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public BookingTemplate bookBusRide(BookingValueObject booking, int userID) {
        BookingTemplate bookingTemplate = new BookingTemplate();
        
        User user = userRepository.findById(userID).orElse(null);

        if (user != null) {
            restTemplate.postForObject(BOOKING_MODULE_URL, booking, BookingTemplate.class);
            BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + booking.getId(), BookingValueObject.class);
            bookingTemplate.setBooking(bookingValueObject);
            bookingTemplate.setUser(user);
        }

        return bookingTemplate;
    }

    @Override
    public CancellationTemplate cancelBusRide(CancellationValueObject cancellation, int bookingID) {
        CancellationTemplate cancellationTemplate = new CancellationTemplate();

        BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + bookingID, BookingValueObject.class);

        if (bookingValueObject != null) {
            restTemplate.postForObject(CANCELLATION_MODULE_URL, cancellation, CancellationTemplate.class);
            CancellationValueObject cancellationValueObject = restTemplate.getForObject(CANCELLATION_MODULE_URL + "get/" + cancellation.getId(), CancellationValueObject.class);
            cancellationTemplate.setCancellation(cancellationValueObject);
            cancellationTemplate.setBooking(bookingValueObject);
        }

        return cancellationTemplate;
    }

    @Override
    public ReviewTemplate reviewBusRide(Review review, int bookingID) {
        ReviewTemplate reviewTemplate = new ReviewTemplate();

        BookingValueObject bookingValueObject = restTemplate.getForObject(BOOKING_MODULE_URL + "get/" + bookingID, BookingValueObject.class);

        if (bookingValueObject != null) {
            restTemplate.postForObject(CANCELLATION_MODULE_URL, review, ReviewTemplate.class);
            Review reviewValueObject = restTemplate.getForObject(CANCELLATION_MODULE_URL + "get/" + review.getId(), Review.class);
            reviewTemplate.setReview(reviewValueObject);
            reviewTemplate.setBooking(bookingValueObject);
        }

        return reviewTemplate;
    }
    
}
