package com.ibm.bookingmodule.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.bookingmodule.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
 
	List<Booking> getBookingsByUserID(int userID);
}
