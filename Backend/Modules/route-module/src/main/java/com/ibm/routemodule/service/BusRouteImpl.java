package com.ibm.routemodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.routemodule.entity.BusRoute;
import com.ibm.routemodule.repo.BusRouteRepository;

@Repository
public class BusRouteImpl implements BusRouteService {

    @Autowired
    BusRouteRepository busRouteRepo;

    @Override
    public int addBusRoute(BusRoute busRoute) {
        busRouteRepo.save(busRoute);
        return busRoute.getId();
    }

    @Override
    public BusRoute getBusRoute(int id) {
        return busRouteRepo.findById(id).orElse(null);
    }

    @Override
    public List<BusRoute> getBusRoutesByOrigin(String origin) {
        return busRouteRepo.findByOrigin(origin);
    }

    @Override
    public List<BusRoute> getBusRoutes() {
        return busRouteRepo.findAll();
    }
    
}
