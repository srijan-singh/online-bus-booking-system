package com.ibm.routemodule.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "route_slot")
public class RouteSlot {
	
	@Id
	@GeneratedValue
	@Column(name="slot_id")
	private int id;
	
	private LocalTime slot;

	public RouteSlot(int id, LocalTime slot) {
		super();
		this.id = id;
		this.slot = slot;
	}
	
	public RouteSlot() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getSlot() {
		return slot;
	}

	public void setSlot(LocalTime slot) {
		this.slot = slot;
	}
	
	

}
