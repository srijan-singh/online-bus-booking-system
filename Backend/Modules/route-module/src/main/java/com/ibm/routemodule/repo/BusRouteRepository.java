package com.ibm.routemodule.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.routemodule.entity.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {
 
    List<BusRoute> findByOrigin(String origin);

    // To find all origin in a list
    @Query("SELECT DISTINCT origin FROM bus_route")
    List<String> findAllOrigin();

    
}