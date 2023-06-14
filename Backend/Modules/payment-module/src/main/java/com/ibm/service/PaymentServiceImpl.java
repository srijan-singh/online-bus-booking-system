package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Payment;
import com.ibm.repo.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository repo;
	@Override
	public int save(Payment p) {
		repo.save(p);
		return p.getId();
	}
	
	@Override
	public Payment findPaymemtByBookingId(int bookingId) {
		return repo.findByBookingId(bookingId);
	}


}
