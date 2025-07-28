package com.tka.flighttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.flighttracker.dao.Flightdao;
import com.tka.flighttracker.entity.Flight;



@Service
public class FlightService {
	
	@Autowired
	private Flightdao flightdao;

	public boolean saveFlightDetails(Flight flightDetails) {
		
		  boolean  ack = flightdao.saveFlightDetails(flightDetails);

		return ack;
	}

	

	public Flight getFlightDetails(Long id) {
		// Flight obj = flightdao.getFlightDetails(id);
		return flightdao.getFlightDetails(id);
	}

	public boolean updateFlightDetails(Flight updatedFlight) {
	    return flightdao.updateFlightDetails(updatedFlight);
	}



	public boolean cancelFlight(Long id) {
		
		return flightdao.deleteFlight(id);
	}
	

}
