package com.ibm.schedulemodule.service;

import com.ibm.schedulemodule.entity.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    Long makeBusSchedule(BusSchedule busSchedule);
    List<BusSchedule> findBusScheduleByRouteId(Long routeId);
    BusSchedule updateBusSchedule(BusSchedule busSchedule);
    BusSchedule getBusScheduleById(Long id);

}
