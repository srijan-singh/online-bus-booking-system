package com.ibm.schedulemodule.repository;

import com.ibm.schedulemodule.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
    List<BusSchedule> findByRouteId(Long routeId);

}
