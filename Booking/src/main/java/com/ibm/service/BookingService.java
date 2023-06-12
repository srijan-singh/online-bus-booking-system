package com.ibm.service;

import java.util.List;

import com.ibm.entity.Booking;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Integer bookingId);
    void deleteBooking(Integer bookingId);
    Booking updateBooking(Booking booking);
  
}
