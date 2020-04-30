package com.cg.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

@Repository
@Transactional
public class FMSDao implements DAOInt{

	

	@PersistenceContext
	EntityManager em;
	
//	//Flight
	/*if admin wants to add a new Flight this 
	function adds data to Oracle with object*/
	
			public String addFlight(Flight flight)
			{
				em.persist(flight);
				return "flight added successfully";
			}
			
	/*if admin wants to view all Flight details
			/this function is used*/
			public List<Flight> viewFlight()
			{
				Query query=em.createQuery("select f from Flight f");
				return query.getResultList();
			}
			/*if admin wats to search for specififc Flight
			  details this function is used*/
			
			public Flight viewFlight(int flightNumber)
			{
				List <Flight> list=viewFlight();
				Flight flight=null;
				Optional <Flight> optional=list.stream().
						filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
				if(optional.isPresent()) {
					flight=optional.get();
				}
				return flight;
				
			}
			
			/* if admin wants to delete a Flight this function is used
			  */
			
			public String deleteFlight(int flightNumber) {
				em.remove(viewFlight(flightNumber));
				return "Flight deleted successfully";
			}
			
			/* if admin wants to update some Flight details with 
			 * flight number  this function is used*/
			
			public String modifyFlight(Flight flight) {
				em.merge(flight);
				return "Flight updated successfully";
			}

			
		//Airport
			
			/*if admin wants to add a new Airport this 
			function adds data to Oracle with object*/
			
			public String addAirport(Airport airport)
			{
				em.persist(airport);
				return "airport added successfuly";
			}
			
			/*if admin wants to view all Airports details
			/this function is used*/
			
			public List<Airport> viewAirport()
			{
				Query query=em.createQuery("Select a from Airport a");
				return query.getResultList();
				
			}
			
			/*if admin wats to search for specififc Airport
			  details this function is used*/
			public Airport viewAirport(String airportCode)
			{
				List<Airport> list=viewAirport();
				Airport airport=null;
				Optional <Airport> optional=list.stream().
						filter(a1->a1.getAirportCode().equals(airportCode)).findFirst();
						if(optional.isPresent()) {
							airport=optional.get();
						}
				return airport;
				
			}
			
		//Schedule
			
			/*if admin wants to add a new Schedule of Airports this 
			function adds data to Oracle with object*/
			
			public String addSchedule(Schedule schedule) {
				em.persist(schedule);
				return "scheduled successfully";
			}
			
			
			/*if admin wants to see all Schedules of Airports*/
			
			public List<Schedule> viewAllSchedule(){
				
				Query query=em.createQuery("select s from Schedule s");
				return query.getResultList();
			}
		
		//ScheduledFlight
			
			/*if admin wants to add a new Scheduled Flight this 
			function adds data to Oracle with object*/
			
			public String scheduleFlight(ScheduledFlight scheduledFlight)
			{
				em.persist(scheduledFlight);
				return "Flight scheduled successfully";
			}
			
			/*if admin wants to view all Scheduled flights this
			 * function is used*/
			
			public List<ScheduledFlight> viewScheduledFlights()
			{
				Query query=em.createQuery("select sf from ScheduledFlight sf");
				return query.getResultList();
			}
			
			/*if admin wants to search for a specific
			 * flights scheduling this function is used*/
			
			public ScheduledFlight viewScheduledFlight(int flightNumber)
			{
				List<ScheduledFlight> list=viewScheduledFlights();
				ScheduledFlight scheduledFlight=null;
				Optional <ScheduledFlight> optional=list.stream().
						filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
				if(optional.isPresent())
				{
					scheduledFlight=optional.get();
				}
				return scheduledFlight;
			}
			
			/*if admin wants to modify some Scheduled Flight deatils 
			 * this function is used*/
			
			public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
				
				
				List<ScheduledFlight> list=viewScheduledFlights();
				Optional <ScheduledFlight> optional=list.stream().
						filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
				if(optional.isPresent())
				{
					em.merge(flight);
					em.merge(schedule);
				}
				return "modified successfully";
			}
			
			/*if admin wants to delete a specific Scheduled Flight 
			 * this function is used*/
			
			public String deleteScheduledFlight(int flightNumber) {
				em.remove(viewScheduledFlight(flightNumber));
				return "deleted scheduled flight successfully";
			}
			
			/*if admin wants to search Scheduled Flight based on Source
			Airport Destination Airport and ArrivalDate*/
			
		/*	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate)
			{
				String src=sourceAirport.getAirportCode();
				
				String dest=destinationAirport.getAirportCode();
				
//				String src="VTZ";
//				
//				String dest="DEL";
//				
				int day=arrivalDate.getDayOfYear();
				int month=arrivalDate.getMonthValue();
				int year=arrivalDate.getYear();

				String date=day+"-"+month+"-"+year;
				System.out.println("DATE : "+date);
				
				Query query=em.createQuery("from ScheduledFlight sf where s.sourceairport="+src+
						"AND sf.destinationairport="+dest+" AND sf.arrivaldate="+date);
				return query.getResultList();
			}
			*/
//			///////////////////////////
//			public List<ScheduledFlight> viewScheduledFlights( String sourceAirport, String destinationAirport, LocalDate arrivalDate)
//			{
//				Query query=em.createQuery("select sf from ScheduledFlight sf where Source_Airport="+sourceAirport+
//						" AND Destination_Airport="+destinationAirport+" AND Arrival_Date="+arrivalDate);
//				return query.getResultList();
//				
//				
//			}
//			
			
}
