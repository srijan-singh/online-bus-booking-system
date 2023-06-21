package com.ibm.routemodule.rest;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.routemodule.entity.BusRoute;
import com.ibm.routemodule.entity.RouteFare;
import com.ibm.routemodule.service.BusRouteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BusRouteController {
    
    @Autowired
    BusRouteService busRouteService;

    //ADDBUSROUTE
    @PostMapping(value="/route/add", consumes="application/json", produces="application/json")
    public int addBusRoute(@RequestBody BusRoute busRoute) {
        return busRouteService.addBusRoute(busRoute);
    }

    //RETRIEVE FUNCTION FOR ID
    @GetMapping(value="/route/get/{id}", produces="application/json")
    public BusRoute getBusRoute(@PathVariable int id) {
        return busRouteService.getBusRoute(id);
    }
    //RETRIEVE FUNCTION FOR ORIGIN
    @GetMapping(value="/route/origin/all", produces="application/json")
    public List<String> getAllOrigin() {
        return busRouteService.getAllOrigins();
    }
    //RETRIEVE FUNCTION FOR DESTINATION
    @GetMapping(value="/route/destination/all", produces="application/json")
    public List<String> getAllDestination() {
        return busRouteService.getAllDestinations();
    }
    //RETRIEVE FUNCTION FOR SLOTS
    @GetMapping(value="/route/slot/all", produces="application/json")
    public List<LocalTime> getAllSlots(){
    	return busRouteService.getAllSlots();
    }
    //RETRIEVE FUNCTION FOR FARE ID
    @GetMapping(value="/route/fare/{fareID}", produces="application/json")
    public RouteFare getRouteFareByRouteFareId(@PathVariable int fareID) {
    	return busRouteService.getRouteFare(fareID);
    }
    //RETRIEVE FUNCTION ROUTEBYORIGIN
    @GetMapping(value="/route/origin/{origin_city}", produces="application/json")
    public List<BusRoute> getBusRoutesByOrigin(@PathVariable String origin_city) {
        return busRouteService.getBusRoutesByOrigin(origin_city);
    }
    //RETRIEVE FUNCTION ROUTESBYORIGINANDDESTINATION
    @GetMapping(value="/route/origin/{origin_city}/destination/{destination_city}", produces="application/json")
    public BusRoute getBusRoutesByOriginAndDestination(@PathVariable String origin_city, @PathVariable String destination_city) {
        return busRouteService.findByOriginAndDestination(origin_city, destination_city);
    }
    
   //RETRIVEFUNCTION ALL ROUTES
    @GetMapping(value="/route/all", produces="application/json")
    public List<BusRoute> getBusRoutes() {
        return busRouteService.getBusRoutes();
    }

    //DELETEBUSROUTE
    @DeleteMapping(value="/route/remove/{id}", produces="application/json")
    public boolean removeRoute(@PathVariable int id) {
    	return busRouteService.removebusRoute(id);
    }
}

