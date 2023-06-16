package com.ibm.schedulemodule.rest;
import java.util.List;

import com.ibm.schedulemodule.entity.BusSchedule;
import com.ibm.schedulemodule.service.BusScheduleService;
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

    @PostMapping(value="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Long> makeBusSchedule(@RequestBody BusSchedule busSchedule) {
        Long scheduleId = busScheduleService.makeBusSchedule(busSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleId);
    }

    @GetMapping(value="/findByRoute/{routeId}", produces = "application/json")
    public ResponseEntity<List<BusSchedule>> findBusScheduleByRouteId(@PathVariable Long routeId) {
        List<BusSchedule> busSchedules = busScheduleService.findBusScheduleByRouteID(routeId);
        return ResponseEntity.ok(busSchedules);
    }
    
    @GetMapping(value="/findByBooking/{bookingId}", produces = "application/json")
    public ResponseEntity<List<BusSchedule>> findBusScheduleByBookinId(@PathVariable Long bookingId) {
        List<BusSchedule> busSchedules = busScheduleService.findBusScheduleByBookingID(bookingId);
        return ResponseEntity.ok(busSchedules);
    }
    
    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<BusSchedule>> findAll() {
        List<BusSchedule> busSchedules = busScheduleService.findAllSchedule();
        return ResponseEntity.ok(busSchedules);
    }
    

    @PutMapping(value="/{id}", consumes = "application/json")
    public ResponseEntity<BusSchedule> updateBusSchedule(@PathVariable Long id, @RequestBody BusSchedule busSchedule) {
        BusSchedule existingBusSchedule = busScheduleService.getBusScheduleByID(id);
        existingBusSchedule.setDepartureTime(busSchedule.getDepartureTime());
        existingBusSchedule.setArrivalTime(busSchedule.getArrivalTime());
        existingBusSchedule.setAvailableSeats(busSchedule.getAvailableSeats());
        existingBusSchedule.setRouteID(busSchedule.getRouteID());
        existingBusSchedule.setBookingID(busSchedule.getBookingID());

        BusSchedule updatedBusSchedule = busScheduleService.updateBusSchedule(existingBusSchedule);
        return ResponseEntity.ok(updatedBusSchedule);
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

