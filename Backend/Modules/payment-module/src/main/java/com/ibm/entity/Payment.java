package com.ibm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private int id;
	private int bookingID;  //Foreign key booking id
	private double amount;
	
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
