package com.cg.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

@Repository
@Transactional
public class FMSDao {

	

	@PersistenceContext
	EntityManager em;
	
	//Flight
		//adding new flight
			public String addFlight(Flight f)
			{
				em.persist(f);
				return "flight added successfully";
			}
			
			//view all flights
			public List<Flight> viewFlight()
			{
				Query query=em.createQuery("select f from Flight f");
				return query.getResultList();
			}

			//view specific flight
			public Flight viewFlight(int flightNumber)
			{
				List <Flight> list=viewFlight();
				Flight f=null;
				Optional <Flight> optional=list.stream().
						filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
				if(optional.isPresent()) {
					f=optional.get();
				}
				return f;
				
			}
			
			//removing unwanted flight
			public String deleteFlight(int flightNumber) {
				em.remove(viewFlight(flightNumber));
				return "Flight deleted successfully";
			}
			
			//modify flight details
			public String modifyFlight(Flight f) {
				em.merge(f);
				return "Flight updated successfully";
			}

			
		//Airport
			
			//adding new airport
			public String addAirport(Airport a)
			{
				em.persist(a);
				return "airport added successfuly";
			}
			
			//view all airports
			public List<Airport> viewAirport()
			{
				Query query=em.createQuery("Select a from Airport a");
				return query.getResultList();
				
			}
			
			//view specific airport
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
			
			//adding new schedule
			public String addSchedule(Schedule s) {
				em.persist(s);
				return "scheduled successfully";
			}
			
			public List<Schedule> viewAllSchedule(){
				
				Query query=em.createQuery("select s from Schedule s");
				return query.getResultList();
			}
		
		//ScheduledFlight
			
			//adding scheduled flight
			
			public String scheduleFlight(ScheduledFlight sf)
			{
				em.persist(sf);
				return "Flight scheduled successfully";
			}
			
			//viewing all scheduled flight
			public List<ScheduledFlight> viewScheduledFlights()
			{
				Query query=em.createQuery("select sf from ScheduledFlight sf");
				return query.getResultList();
			}
			
			//viewing specific scheduled flight
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
			
			//modifying scheduled flihgt
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
			
			//deleting scheduled flight
			
			public String deleteScheduledFlight(int flightNumber) {
				em.remove(viewScheduledFlight(flightNumber));
				return "deleted scheduled flight successfully";
			}
			
			//searching scheduled flight with src, dest airport and date
			
			public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate)
			{
				Query query=em.createQuery("select sf from ScheduledFlight sf where SourceAirport="+sourceAirport+
						"AND DestinationAirport="+destinationAirport+" AND ArrivalDate="+arrivalDate);
				return query.getResultList();
			}
}
