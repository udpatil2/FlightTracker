package com.tka.flighttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.flighttracker.entity.Flight;
import com.tka.flighttracker.service.FlightService;

@RestController
@RequestMapping("/flight-tracker")
public class FlightController {
	
	@Autowired
	 private FlightService flightService;
	
	
	 
	
	@PostMapping("/book-flight")
	public String bookFlight (@RequestBody Flight flightDetails) {
		
		boolean ack = flightService.saveFlightDetails(flightDetails);
		
		if(!ack) {
			return "Flight booking failed. Please try again.";
		}else {
			return "Flight booked sucessfully with details:" + flightDetails;
			
		}
	
//		
//		
//		Session openSession = sessionFactory.openSession();		
//		Transaction tx = openSession.beginTransaction();
//	    openSession.save(flightDetails);
//	    tx.commit();
//	    openSession.close();
//		return "Flight booked sucessfully with details:" ;
	}
	@GetMapping("/get-flight-details")
	public Flight getFlightDetails(Long id) {
		
		Flight obj = flightService.getFlightDetails(id);
		return obj;
	}
	
	@DeleteMapping("/cancel-flight")
	public String cancelFlightDetails(@RequestParam Long id) {
	    boolean ack = flightService.cancelFlight(id);

	    if (!ack) {
	        return "Flight deletion failed. Flight not found.";
	    } else {
	        return "Flight with ID " + id + " deleted successfully.";
	    }
	}
	@PutMapping("/update-flight")
	public String updateFlight(@RequestBody Flight updatedFlight) {
	    boolean ack = flightService.updateFlightDetails(updatedFlight);

	    if (!ack) {
	        return "Flight update failed. Please check details.";
	    } else {
	        return "Flight updated successfully with details: " + updatedFlight;
      }
	}
	
	

}
