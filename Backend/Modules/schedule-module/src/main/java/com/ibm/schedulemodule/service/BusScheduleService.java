package com.ibm.schedulemodule.service;

import com.ibm.schedulemodule.entity.BusSchedule;

import java.util.List;

public interface BusScheduleService {
	
    Long makeBusSchedule(BusSchedule busSchedule);
    
    List<BusSchedule> findBusScheduleByRouteID(Long routeId);
    
    List<BusSchedule> findBusScheduleByBookingID(Long bookingId);
    
    List<BusSchedule> findAllSchedule();
    
    BusSchedule updateBusSchedule(BusSchedule busSchedule);
    
    BusSchedule getBusScheduleByID(Long id);
    
    boolean removeSchedule(Long id);

}
