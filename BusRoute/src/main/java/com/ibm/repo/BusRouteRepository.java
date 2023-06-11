package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute,Integer> {

}
