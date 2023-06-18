package com.ibm.schedulemodule.rest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.List;

import com.ibm.schedulemodule.entity.BusSchedule;
import com.ibm.schedulemodule.service.BusScheduleService;

import valueobject.BusScheduleValueObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/schedule")
public class BusScheduleController {

    private final BusScheduleService busScheduleService;

    public BusScheduleController(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }
    
    @GetMapping(value="/booked/route/{routeID}/departure/{departureTime}", produces="application/json")
    public ResponseEntity<Integer> getBookedSchedules(@PathVariable Long routeID, @PathVariable String departureTime){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime departureDateTime = LocalDateTime.parse(departureTime, formatter);
      	Integer bookedSchedule = busScheduleService.getBookedSchedules(departureDateTime, routeID);
      	return ResponseEntity.ok(bookedSchedule);
    }

    @PostMapping(value="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BusSchedule> makeBusSchedule(@RequestBody BusScheduleValueObject busScheduleValueObject) {
        
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    	
        LocalDateTime arrival = LocalDateTime.parse(busScheduleValueObject.getArrivalTime(), formatter);
        LocalDateTime departure = LocalDateTime.parse(busScheduleValueObject.getDepartureTime(), formatter);
    	
    	BusSchedule busSchedule = new BusSchedule();
    	
    	busSchedule.setArrivalTime(arrival);
    	busSchedule.setDepartureTime(departure);
    	
    	busSchedule.setRouteID(busScheduleValueObject.getRouteID());
    	busSchedule.setAmount(busScheduleValueObject.getAmount());
   
    	return ResponseEntity.status(HttpStatus.CREATED).body(busScheduleService.makeBusSchedule(busSchedule));
    }

    @GetMapping(value="/findByRoute/{routeId}", produces = "application/json")
    public ResponseEntity<List<BusSchedule>> findBusScheduleByRouteId(@PathVariable Long routeId) {
        List<BusSchedule> busSchedules = busScheduleService.findBusScheduleByRouteID(routeId);
        return ResponseEntity.ok(busSchedules);
    }
    
    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<BusSchedule>> findAll() {
        List<BusSchedule> busSchedules = busScheduleService.findAllSchedule();
        return ResponseEntity.ok(busSchedules);
    }


    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<BusSchedule> getBusScheduleById(@PathVariable Long id) {
        BusSchedule busSchedule = busScheduleService.getBusScheduleByID(id);
        return ResponseEntity.ok(busSchedule);
    }

    
    @DeleteMapping(value="/remove/{id}", produces="application/json")
    public boolean removeSchedule(@PathVariable long id) {
    	return busScheduleService.removeSchedule(id);
    }

}

