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

    @Override
    public BusSchedule makeBusSchedule(BusSchedule busSchedule) {
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> findBusScheduleByRouteID(Long routeId) {
        return busScheduleRepository.findByRouteID(routeId);
    }

    @Override
    public BusSchedule updateBusSchedule(BusSchedule busSchedule) {
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public BusSchedule getBusScheduleByID(Long id) {
        return busScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus Schedule not found with id: " + id));
    }

	@Override
	public boolean removeSchedule(Long id) {
		BusSchedule busSchedule = busScheduleRepository.findById(id).orElse(null);
		
		if(busSchedule != null) {
			busScheduleRepository.delete(busSchedule);
			return true;
		}
		
		return false;
	}

	@Override
	public List<BusSchedule> findAllSchedule() {
		return busScheduleRepository.findAll();
	}

	@Override
	public int getBookedSchedules(LocalDateTime departureTime, Long routeID) {
		return busScheduleRepository.countByDepartureTimeAndRouteID(departureTime, routeID);
	}


}
