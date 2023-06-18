package com.ibm.routemodule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.routemodule.entity.RouteFare;


public interface RouteFareRepo extends JpaRepository<RouteFare, Integer> {

}
