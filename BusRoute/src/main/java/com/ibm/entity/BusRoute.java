package com.ibm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BusRoute")
public class BusRoute {
	@Id
	private int id;
	@Column(length = 20)
	private String origin;
	@Column(length =20)
	private String destination;
	
	
	public BusRoute(int id, String origin, String destination) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public BusRoute() {
		
	}
	
	
	
	
	

}
