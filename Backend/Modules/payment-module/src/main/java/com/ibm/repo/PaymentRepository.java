package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	Payment findByBookingId(int bookingId);
}
