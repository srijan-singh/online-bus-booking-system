package com.ibm.usermodule.service;

import com.ibm.usermodule.entity.Review;
import com.ibm.usermodule.entity.User;
import com.ibm.usermodule.vo.BookingTemplate;
import com.ibm.usermodule.vo.BookingValueObject;
import com.ibm.usermodule.vo.CancellationTemplate;
import com.ibm.usermodule.vo.CancellationValueObject;
import com.ibm.usermodule.vo.ReviewTemplate;

public interface UserService {

    int register(User user);

    boolean login(String email, String password);

    boolean update(User user);

    User getUser(int userID);

    boolean delete(int userID);

    // Additional Service

    BookingTemplate bookBusRide(BookingValueObject booking ,int userID);

    CancellationTemplate cancelBusRide(CancellationValueObject cancellation, int bookingID);

    ReviewTemplate reviewBusRide(Review review, int userID);
}
