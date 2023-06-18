package com.ibm.routemodule.service;

import java.time.LocalTime;
import java.util.List;

import com.ibm.routemodule.entity.BusRoute;
import com.ibm.routemodule.entity.RouteFare;

public interface BusRouteService {
    
    int addBusRoute(BusRoute busRoute);

    BusRoute getBusRoute(int id);
    
    BusRoute findByOriginAndDestination(String origin, String destination);

    List<String> getAllOrigins();
    
    List<String> getAllDestinations();
    
    List<LocalTime> getAllSlots();
    
    RouteFare getRouteFare(int fareId);
    
    List<BusRoute> getBusRoutesByOrigin(String origin);

    List<BusRoute> getBusRoutes();

    boolean removebusRoute(int id);
}

