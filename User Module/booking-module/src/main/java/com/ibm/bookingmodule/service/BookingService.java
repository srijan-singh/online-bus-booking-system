/**
 * Module: Booking Service
 * Aim: To provide the service for booking module
 * IBM - FSD Assignment
 * Author: Srijan Singh
 * Date: 07/06/2023 
 */
package com.ibm.bookingmodule.service;

import com.ibm.bookingmodule.entity.Booking;
import com.ibm.bookingmodule.entity.Cancellation;

public interface BookingService {
    
    int makeBooking(Booking booking);

    Booking getBookingDetails(int bookingID);

    int cancelBooking(Cancellation cancellation, int bookingID);

    Cancellation getCancellationDetails(int cancellationID);
}
