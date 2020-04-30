package com.cg.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

public interface DAOInt {
	
	public String addFlight(Flight flight);
	
	//view all flights
	public List<Flight> viewFlight();
/////////////////////////////////
	//view specific flight
	public Flight viewFlight(int flightNumber);
//////////////////////////////////	
	//removing unwanted flight
	public String deleteFlight(int flightNumber) ;
	
	//modify flight details
	public String modifyFlight(Flight flight) ;

	
//Airport
	
	//adding new airport
	public String addAirport(Airport airport);
	
	//view all airports
	public List<Airport> viewAirport();
	
	//view specific airport
	public Airport viewAirport(String airportCode);
	
//Schedule
	
	//adding new schedule
	public String addSchedule(Schedule schedule) ;
	
	public List<Schedule> viewAllSchedule();

//ScheduledFlight
	
	//adding scheduled flight
	
	public String scheduleFlight(ScheduledFlight scheduledFlight);
	
	//viewing all scheduled flight
	public List<ScheduledFlight> viewScheduledFlights();
	
	//viewing specific scheduled flight
	public ScheduledFlight viewScheduledFlight(int flightNumber);
	
	//modifying scheduled flihgt
	public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) ;
	
	//deleting scheduled flight
	
	public String deleteScheduledFlight(int flightNumber);
	
	//searching scheduled flight with src, dest airport and date
	
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate);
//	///////////////////////////
//	public List<ScheduledFlight> viewScheduledFlights( String sourceAirport, String destinationAirport, LocalDate arrivalDate)
//	{
//		Query query=em.createQuery("select sf from ScheduledFlight sf where Source_Airport="+sourceAirport+
//				" AND Destination_Airport="+destinationAirport+" AND Arrival_Date="+arrivalDate);
//		return query.getResultList();
//		
//		
//	}

}
