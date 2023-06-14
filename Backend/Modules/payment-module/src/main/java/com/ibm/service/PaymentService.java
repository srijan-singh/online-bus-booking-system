package com.ibm.service;

import com.ibm.entity.Payment;

public interface PaymentService {

	int save(Payment p);
	Payment findPaymemtByBookingId(int bookingId);
}
