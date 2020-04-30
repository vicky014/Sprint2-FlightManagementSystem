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
//		//adding new flight
			public String addFlight(Flight flight)
			{
				em.persist(flight);
				return "flight added successfully";
			}
			
			//view all flights
			public List<Flight> viewFlight()
			{
				Query query=em.createQuery("select f from Flight f");
				return query.getResultList();
			}
/////////////////////////////////
			//view specific flight
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
//////////////////////////////////			
			//removing unwanted flight
			public String deleteFlight(int flightNumber) {
				em.remove(viewFlight(flightNumber));
				return "Flight deleted successfully";
			}
			
			//modify flight details
			public String modifyFlight(Flight flight) {
				em.merge(flight);
				return "Flight updated successfully";
			}

			
		//Airport
			
			//adding new airport
			public String addAirport(Airport airport)
			{
				em.persist(airport);
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
			public String addSchedule(Schedule schedule) {
				em.persist(schedule);
				return "scheduled successfully";
			}
			
			public List<Schedule> viewAllSchedule(){
				
				Query query=em.createQuery("select s from Schedule s");
				return query.getResultList();
			}
		
		//ScheduledFlight
			
			//adding scheduled flight
			
			public String scheduleFlight(ScheduledFlight scheduledFlight)
			{
				em.persist(scheduledFlight);
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
