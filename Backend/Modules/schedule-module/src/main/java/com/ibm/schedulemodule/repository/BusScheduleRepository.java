package com.ibm.schedulemodule.repository;

import com.ibm.schedulemodule.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
	
    List<BusSchedule> findByRouteID(Long routeId);
    
    List<BusSchedule> findByBookingID(Long bookingId);

}
