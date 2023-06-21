package com.ibm.schedulemodule.service;

import com.ibm.schedulemodule.entity.BusSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface BusScheduleService {
	
	// Get the number of booked schedules for a specific departure time and route ID
	int getBookedSchedules(LocalDateTime departureTime, Long routeID);
	
	// Make a new bus schedule
	BusSchedule makeBusSchedule(BusSchedule busSchedule);
    
    // Find bus schedules by route ID
    List<BusSchedule> findBusScheduleByRouteID(Long routeId);
    
    // Get all bus schedules
    List<BusSchedule> findAllSchedule();
    
    // Update a bus schedule
    BusSchedule updateBusSchedule(BusSchedule busSchedule);
    
    // Get a bus schedule by its ID
    BusSchedule getBusScheduleByID(Long id);
    
    // Remove a bus schedule by its ID
    boolean removeSchedule(Long id);
}

