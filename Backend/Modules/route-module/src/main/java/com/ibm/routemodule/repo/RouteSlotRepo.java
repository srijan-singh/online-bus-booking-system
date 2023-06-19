package com.ibm.routemodule.repo;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.routemodule.entity.RouteSlot;

public interface RouteSlotRepo extends JpaRepository<RouteSlot, Integer> {
	
	// To find all origin in a list
    @Query("SELECT DISTINCT slot FROM route_slot")
    List<LocalTime> findAllSlot();
    

}
