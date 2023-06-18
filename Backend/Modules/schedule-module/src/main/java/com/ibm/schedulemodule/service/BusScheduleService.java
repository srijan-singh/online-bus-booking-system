package com.ibm.schedulemodule.service;

import com.ibm.schedulemodule.entity.BusSchedule;

import java.time.LocalDateTime;
import java.util.List;


public interface BusScheduleService {
	
	int getBookedSchedules(LocalDateTime departureTime, Long routeID);
	
	BusSchedule makeBusSchedule(BusSchedule busSchedule);
    
    List<BusSchedule> findBusScheduleByRouteID(Long routeId);
    
    List<BusSchedule> findAllSchedule();
    
    BusSchedule updateBusSchedule(BusSchedule busSchedule);
    
    BusSchedule getBusScheduleByID(Long id);
    
    boolean removeSchedule(Long id);

}
