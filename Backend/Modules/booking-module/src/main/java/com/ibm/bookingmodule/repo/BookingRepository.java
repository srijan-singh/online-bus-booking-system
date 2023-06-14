package com.ibm.bookingmodule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.bookingmodule.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
