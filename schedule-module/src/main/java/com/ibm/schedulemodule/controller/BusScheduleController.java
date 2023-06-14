package com.ibm.schedulemodule.controller;
import java.util.List;

import com.ibm.schedulemodule.entity.BusSchedule;
import com.ibm.schedulemodule.service.BusScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/bus-schedules")
public class BusScheduleController {

    private final BusScheduleService busScheduleService;

    public BusScheduleController(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }

    @PostMapping
    public ResponseEntity<Long> makeBusSchedule(@RequestBody BusSchedule busSchedule) {
        Long scheduleId = busScheduleService.makeBusSchedule(busSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleId);
    }

    @GetMapping("/by-route/{routeId}")
    public ResponseEntity<List<BusSchedule>> findBusScheduleByRouteId(@PathVariable Long routeId) {
        List<BusSchedule> busSchedules = busScheduleService.findBusScheduleByRouteId(routeId);
        return ResponseEntity.ok(busSchedules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusSchedule> updateBusSchedule(@PathVariable Long id, @RequestBody BusSchedule busSchedule) {
        BusSchedule existingBusSchedule = busScheduleService.getBusScheduleById(id);
        existingBusSchedule.setDepartureTime(busSchedule.getDepartureTime());
        existingBusSchedule.setArrivalTime(busSchedule.getArrivalTime());
        existingBusSchedule.setAvailableSeats(busSchedule.getAvailableSeats());
        existingBusSchedule.setRouteId(busSchedule.getRouteId());
        existingBusSchedule.setBookingId(busSchedule.getBookingId());

        BusSchedule updatedBusSchedule = busScheduleService.updateBusSchedule(existingBusSchedule);
        return ResponseEntity.ok(updatedBusSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusSchedule> getBusScheduleById(@PathVariable Long id) {
        BusSchedule busSchedule = busScheduleService.getBusScheduleById(id);
        return ResponseEntity.ok(busSchedule);
    }


}

