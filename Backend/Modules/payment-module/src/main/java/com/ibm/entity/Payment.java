package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="booking_id")
	private int bookingID;  //Foreign key booking id
	private double amount;
	
	
	
	public Payment(int id, int bookingID, double amount) {
		super();
		this.id = id;
		this.bookingID = bookingID;
		this.amount = amount;
	}
	public Payment() {
		super();
	}
	public int getID() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingId) {
		this.bookingID = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}
