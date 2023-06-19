package com.ibm.schedulemodule.entity;


import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "bus_schedule")
public class BusSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "route_id")
    private Long routeID;
    
    @Column(name = "amount")
    private Double amount;

	public BusSchedule() {
    }

    public BusSchedule(Long id, LocalDateTime departureTime, LocalDateTime arrivalTime,
			Long routeID,Double amount) {
		super();
		this.id = id;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.routeID = routeID;
		this.amount = amount;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long routeId) {
        this.routeID = routeId;
    }
    
    public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


}
