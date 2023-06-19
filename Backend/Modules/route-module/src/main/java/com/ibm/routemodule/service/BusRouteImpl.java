package com.ibm.routemodule.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.routemodule.entity.BusRoute;
import com.ibm.routemodule.entity.RouteFare;
import com.ibm.routemodule.repo.BusRouteRepository;
import com.ibm.routemodule.repo.RouteFareRepo;
import com.ibm.routemodule.repo.RouteSlotRepo;

@Repository
public class BusRouteImpl implements BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepo;
    
    @Autowired
    private RouteSlotRepo routeSlotRepo;
    
    @Autowired
    private RouteFareRepo routeFareRepository;

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
	public List<String> getAllOrigins() {
		return busRouteRepo.findAllOrigin();
	}
	
	@Override
	public List<String> getAllDestinations() {
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

	@Override
	public RouteFare getRouteFare(int fareId) {
		return routeFareRepository.findById(fareId).orElse(null);
	}

	@Override
	public List<LocalTime> getAllSlots() {
		return routeSlotRepo.findAllSlot();
	}

}
