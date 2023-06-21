package com.ibm.schedulemodule.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.schedulemodule.entity.BusSchedule;
import com.ibm.schedulemodule.repository.BusScheduleRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    private final BusScheduleRepository busScheduleRepository;

    public BusScheduleServiceImpl(BusScheduleRepository busScheduleRepository) {
        this.busScheduleRepository = busScheduleRepository;
    }

    /**
     * Creates a new bus schedule.
     *
     * @param busSchedule the bus schedule to be created
     * @return the created bus schedule
     */
    @Override
    public BusSchedule makeBusSchedule(BusSchedule busSchedule) {
        return busScheduleRepository.save(busSchedule);
    }

    /**
     * Retrieves a list of bus schedules by the given route ID.
     *
     * @param routeId the ID of the route
     * @return a list of bus schedules for the specified route ID
     */
    @Override
    public List<BusSchedule> findBusScheduleByRouteID(Long routeId) {
        return busScheduleRepository.findByRouteID(routeId);
    }

    /**
     * Updates an existing bus schedule.
     *
     * @param busSchedule the bus schedule to be updated
     * @return the updated bus schedule
     */
    @Override
    public BusSchedule updateBusSchedule(BusSchedule busSchedule) {
        return busScheduleRepository.save(busSchedule);
    }

    /**
     * Retrieves a bus schedule by its ID.
     *
     * @param id the ID of the bus schedule to retrieve
     * @return the bus schedule with the specified ID
     * @throws EntityNotFoundException if the bus schedule is not found
     */
    @Override
    public BusSchedule getBusScheduleByID(Long id) {
        return busScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus Schedule not found with id: " + id));
    }

    /**
     * Removes a bus schedule by its ID.
     *
     * @param id the ID of the bus schedule to remove
     * @return true if the bus schedule was found and removed, false otherwise
     */
    @Override
    public boolean removeSchedule(Long id) {
        BusSchedule busSchedule = busScheduleRepository.findById(id).orElse(null);

        if (busSchedule != null) {
            busScheduleRepository.delete(busSchedule);
            return true;
        }

        return false;
    }

    /**
     * Retrieves all bus schedules.
     *
     * @return a list of all bus schedules
     */
    @Override
    public List<BusSchedule> findAllSchedule() {
        return busScheduleRepository.findAll();
    }

    /**
     * Returns the number of booked schedules for a given departure time and route ID.
     *
     * @param departureTime the departure time
     * @param routeID       the ID of the route
     * @return the number of booked schedules
     */
    @Override
    public int getBookedSchedules(LocalDateTime departureTime, Long routeID) {
        return busScheduleRepository.countByDepartureTimeAndRouteID(departureTime, routeID);
    }
}
