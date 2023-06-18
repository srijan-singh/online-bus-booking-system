package com.ibm.schedulemodule.repository;

import com.ibm.schedulemodule.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
	
    List<BusSchedule> findByRouteID(Long routeId);
    
    @Query("SELECT COUNT(b) FROM BusSchedule b WHERE b.arrivalTime = :arrivalTime AND b.routeID = :routeID")
    int countByArrivalTimeAndRouteID(@Param("arrivalTime") LocalDateTime arrivalTime, @Param("routeID") Long routeID);

    @Query("SELECT COUNT(b) FROM BusSchedule b WHERE b.departureTime = :departureTime AND b.routeID = :routeID")
    int countByDepartureTimeAndRouteID(@Param("departureTime") LocalDateTime departureTime, @Param("routeID") Long routeID);
}
