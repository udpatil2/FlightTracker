package com.tka.flighttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlighttrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlighttrackerApplication.class, args);
		System.err.println("Flight Tracker System Started Sucessfully");
	}

}
