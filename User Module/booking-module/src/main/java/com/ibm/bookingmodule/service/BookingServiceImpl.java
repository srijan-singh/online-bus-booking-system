package com.ibm.bookingmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.bookingmodule.entity.Booking;
import com.ibm.bookingmodule.entity.Cancellation;
import com.ibm.bookingmodule.repo.BookingRepository;
import com.ibm.bookingmodule.repo.CancellationRepository;

@Repository
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CancellationRepository cancellationRepository;

    @Override
    public int makeBooking(Booking booking) {
        bookingRepository.save(booking);
        return booking.getId();
    }

    @Override
    public Booking getBookingDetails(int bookingID) {
        return bookingRepository.findById(bookingID).orElse(null);
    }

    @Override
    public int cancelBooking(Cancellation cancellation, int bookingID) {
        Booking booking = bookingRepository.findById(bookingID).orElse(null);
        if(booking != null) {
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
            cancellation.setBooking(booking);
            cancellationRepository.save(cancellation);
            return cancellation.getId();
        }   
        return -1;
    }

    @Override
    public Cancellation getCancellationDetails(int cancellationID) {
        return cancellationRepository.findById(cancellationID).orElse(null);
    }
    
}
