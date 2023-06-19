package com.ibm.routemodule.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "bus_route")
public class BusRoute {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    int id;

    private String origin;

    public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	private String destination;
    
    private double distance;
    
    private LocalTime duration;
    
    @Column(name = "available_seats")
    private int available_seats;

	public BusRoute(int id, String origin, String destination, double distance, LocalTime duration,
			int available_seats) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
		this.available_seats = available_seats;
	}

	public BusRoute() {
    }

    public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
    
    

}
