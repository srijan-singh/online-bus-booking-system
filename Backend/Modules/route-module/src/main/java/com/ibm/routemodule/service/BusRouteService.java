package com.ibm.routemodule.service;

import java.util.List;

import com.ibm.routemodule.entity.BusRoute;

public interface BusRouteService {
    
    int addBusRoute(BusRoute busRoute);

    BusRoute getBusRoute(int id);

    List<String> getAllOrigin();
    
    List<BusRoute> getBusRoutesByOrigin(String origin);

    List<BusRoute> getBusRoutes();

    boolean removebusRoute(int id);
}

