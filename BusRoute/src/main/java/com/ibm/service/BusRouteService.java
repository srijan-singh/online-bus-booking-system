package com.ibm.service;

import com.ibm.entity.BusRoute;

public interface BusRouteService {
	
	BusRoute find(int id);
	
	BusRoute setorigin(BusRoute origin );
	
	BusRoute setDestination(BusRoute Destination);
	

}
