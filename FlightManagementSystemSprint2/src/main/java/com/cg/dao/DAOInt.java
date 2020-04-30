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
	
	
//Flight	
	/*if admin wants to add a new Flight this 
	function adds data to Oracle with object*/
	
	public String addFlight(Flight flight);
	
	/*if admin wants to view all Flight details
	/this function is used*/
	public List<Flight> viewFlight();
	

	/*if admin wats to search for specififc Flight
	  details this function is used*/
	
	public Flight viewFlight(int flightNumber);

	/* if admin wants to delete a Flight this function is used
	  */
	public String deleteFlight(int flightNumber) ;
	
	/* if admin wants to update some Flight details with 
	 * flight number  this function is used*/
	public String modifyFlight(Flight flight) ;

	
//Airport
	
	/*if admin wants to add a new Airport this 
	function adds data to Oracle with object*/
	
	public String addAirport(Airport airport);
	
	/*if admin wants to view all Airports details
	/this function is used*/
	
	public List<Airport> viewAirport();
	
	/*if admin wats to search for specififc Airport
	  details this function is used*/
	
	public Airport viewAirport(String airportCode);
	
	
//Schedule
	
	/*if admin wants to add a new Schedule of Airports this 
	function adds data to Oracle with object*/
	
	public String addSchedule(Schedule schedule) ;
	
	/*if admin wants to see all Schedules of Airports*/
	
	public List<Schedule> viewAllSchedule();

//ScheduledFlight
	
	/*if admin wants to add a new Scheduled Flight this 
	function adds data to Oracle with object*/
	
	public String scheduleFlight(ScheduledFlight scheduledFlight);
	
	/*if admin wants to view all Scheduled flights this
	 * function is used*/
	
	public List<ScheduledFlight> viewScheduledFlights();
	
	/*if admin wants to search for a specific
	 * flights scheduling this function is used*/
	
	public ScheduledFlight viewScheduledFlight(int flightNumber);
	
	/*if admin wants to modify some Scheduled Flight deatils 
	 * this function is used*/
	
	public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) ;
	
	/*if admin wants to delete a specific Scheduled Flight 
	 * this function is used*/
	
	public String deleteScheduledFlight(int flightNumber);
	
	
//	
//	/if admin wants to search Scheduled Flight based on Source Airport Destination Airport and ArrivalDate
//	
//	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate);
////	///////////////////////////
////	public List<ScheduledFlight> viewScheduledFlights( String sourceAirport, String destinationAirport, LocalDate arrivalDate)
////	{
////		Query query=em.createQuery("select sf from ScheduledFlight sf where Source_Airport="+sourceAirport+
////				" AND Destination_Airport="+destinationAirport+" AND Arrival_Date="+arrivalDate);
////		return query.getResultList();
////		
////		
////	}

}
