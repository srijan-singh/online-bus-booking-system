package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
