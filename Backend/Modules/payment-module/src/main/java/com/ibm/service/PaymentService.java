package com.ibm.service;

import java.util.List;

import com.ibm.entity.Payment;

public interface PaymentService {

	int save(Payment p);
	
	Payment findPaymemtByBookingId(int bookingId);
	
	List<Payment> findAllPayments();
}
