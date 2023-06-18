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

	@Override
	public List<String> getAllOrigin() {
		return busRouteRepo.findAllOrigin();
	}
	
	@Override
	public List<String> getAllDestination() {
		return busRouteRepo.findAllDestination();
	}

	@Override
	public boolean removebusRoute(int id) {
		
		BusRoute busRoute = busRouteRepo.findById(id).orElse(null);
		
		if(busRoute != null) {
			busRouteRepo.delete(busRoute);
			return true;
		}
		
		return false;
	}

	@Override
	public BusRoute findByOriginAndDestination(String origin, String destination) {
		return busRouteRepo.findByOriginAndDestination(origin, destination);
	}

}
