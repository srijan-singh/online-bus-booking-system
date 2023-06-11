package com.ibm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.BusRoute;
import com.ibm.service.BusRouteService;

@RestController
public class BusRouteController {
	@Autowired
	private BusRouteService service;
	
	@PostMapping(value="/{id}",produces="application/json")
	public BusRoute getBusRoute(@PathVariable int id) {
		return service.find(id);
	}
	
	
	@PostMapping(value="/",produces="application/json")
	public BusRoute saveBusRoute(@PathVariable BusRoute origin) {
		return service.setorigin(origin);
	}
	
	@PostMapping(value="/",produces="application/json")
	public BusRoute saveBusRoute1(@PathVariable BusRoute Destination) {
		return service.setDestination(Destination);
	}
	
	
	
	
	

}
