package com.ibm.routemodule.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.routemodule.entity.BusRoute;
import com.ibm.routemodule.service.BusRouteService;

@CrossOrigin
@RestController
public class BusRouteController {
    
    @Autowired
    BusRouteService busRouteService;

    @PostMapping(value="/route/add", consumes="application/json", produces="application/json")
    public int addBusRoute(@RequestBody BusRoute busRoute) {
        return busRouteService.addBusRoute(busRoute);
    }

    @GetMapping(value="/route/get/{id}", produces="application/json")
    public BusRoute getBusRoute(@PathVariable int id) {
        return busRouteService.getBusRoute(id);
    }

    @GetMapping(value="/route/origin/{origin_city}", produces="application/json")
    public List<BusRoute> getBusRoutesByOrigin(@PathVariable String origin_city) {
        return busRouteService.getBusRoutesByOrigin(origin_city);
    }

    @GetMapping(value="/route/all", produces="application/json")
    public List<BusRoute> getBusRoutes() {
        return busRouteService.getBusRoutes();
    }
}

