package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.entity.BusRoute;
import com.ibm.repo.BusRouteRepository;

public class BusRouteServiceImpl implements BusRouteService {
	
	
	@Autowired
	private BusRouteRepository repo;

	@Override
	public BusRoute find(int id) {
		return repo.findById(id).get();
	}

	@Override
	public BusRoute setorigin(BusRoute origin) {
	
		return repo.save(origin);
	}
	@Override
	public BusRoute setDestination(BusRoute Destination) {
	
		return repo.save(Destination);
	}

}
