package com.tka.flighttracker.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "flights")
@Component
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String airline;

	@Column(nullable = false)
	private String source;

	@Column(nullable = false)
	private String destination;

	@Column(name = "departure_time", nullable = false)
	private LocalDateTime departureTime;

	@Column(name = "arrival_time", nullable = true)
	private LocalDateTime arrivalTime;

	@Column(nullable = false)
	private double price;

	// Constructors
	public Flight() {
	}

	public Flight(String airline, String source, String destination, LocalDateTime departureTime,
			LocalDateTime arrivalTime, double price) {
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

//	public Object getFlightNumber() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setFlightNumber(Object flightNumber) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getFlightNumber() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
