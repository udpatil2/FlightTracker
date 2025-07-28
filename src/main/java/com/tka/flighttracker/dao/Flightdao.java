package com.tka.flighttracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.flighttracker.entity.Flight;

@Repository
public class Flightdao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveFlightDetails(Flight flightDetails) {
//		Flight f1 = new Flight();
//		f1.setFlightNumber(flightDetails.getFlightNumber());
		try {
			Session openSession = sessionFactory.openSession();
			Transaction tx = openSession.beginTransaction();
			openSession.save(flightDetails);
			tx.commit();
			openSession.close();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Flight getFlightDetails(Long id) {
		
		Flight flight = null;
		
		try {
			Session openSession = sessionFactory.openSession();
			 flight = openSession.get(Flight.class, id);
			openSession.close();
			return flight;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteFlight(Long id) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction tx = session.beginTransaction();
	        Flight flight = session.get(Flight.class, id);
	        if (flight != null) {
	            session.delete(flight);
	            tx.commit();
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public boolean updateFlightDetails(Flight updatedFlight) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction tx = session.beginTransaction();
	        session.update(updatedFlight);
	        tx.commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	

}
