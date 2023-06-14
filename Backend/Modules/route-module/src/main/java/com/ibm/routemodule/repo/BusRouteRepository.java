package com.ibm.routemodule.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.routemodule.entity.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {
 
    List<BusRoute> findByOrigin(String origin);
    
}