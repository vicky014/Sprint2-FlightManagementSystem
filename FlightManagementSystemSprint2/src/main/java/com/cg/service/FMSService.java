package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.DAOInt;
import com.cg.dao.FMSDao;
import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;
import com.cg.exception.FMSException;

@Service
public class FMSService {


	//private FMSDao flightDao;
	@Autowired
	private DAOInt daoInt;
	
	//Flight
			public List<Flight> viewFlight(){
				return daoInt.viewFlight();
			}
			
			public Flight viewFlight(int flightNumber) throws FMSException {
				
				
				List<Flight> list=viewFlight();
				Optional <Flight> optional=list.stream().
						filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
				
				if(optional.isPresent())
				{
					return daoInt.viewFlight(flightNumber);
				}
				
				else
					throw new FMSException("flight Number does not exist");
				
				
				
				
//				Flight flight1=(Flight) viewFlight().listIterator(flightNumber);
//				
//				if(flight1!=null)
//				{
//					return flightDao.viewFlight(flightNumber);
//				}
//				else
//					throw new FMSException("flight Number does not exist");
//				
				
				
				//return flightDao.viewFlight(flightNumber);
			}
			
			public String addFlight(Flight flight) throws FMSException {
				
				List<Flight> list=viewFlight();
				Optional <Flight> optional=list.stream().
						filter(f1->f1.getFlightNumber()==flight.getFlightNumber()).findFirst();
				
				if(optional.isPresent())
				{
					throw new FMSException("flight Number already exist try new one");
					
				}
				
				else
					return daoInt.addFlight(flight);
							
				
				
//				return flightDao.addFlight(flight);
			}
			
			public String deleteFlight(int flightNumber) {
				return daoInt.deleteFlight(flightNumber);
			}
			
			public String modifyFlight(Flight flight) throws FMSException {
				///////
				int flightNumber=flight.getFlightNumber();
				
				Flight flight1=viewFlight(flightNumber);
				
				if(flight1!=null)
				{
					return daoInt.modifyFlight(flight);
				}
				else
					throw new FMSException("flight Number does not exist");
				
				//////////
				//return flightDao.modifyFlight(flight);
			}
			
	//Airport
			
			public String addAirport(Airport airport) throws FMSException {
				
				List<Airport> list=viewAirport();
				Optional <Airport> optional=list.stream().
						filter(a1->a1.getAirportCode().equalsIgnoreCase(airport.getAirportCode())).findFirst();
				
				if(optional.isPresent())
				{
					throw new FMSException("Airport Code already exist try new one");
					
				}
				
				else
					return daoInt.addAirport(airport);
				
				//return flightDao.addAirport(airport);
			}
			
			public List<Airport> viewAirport(){
				return daoInt.viewAirport();
			}
			
			public Airport viewAirport(String airportCode) throws FMSException {
				
				List<Airport> list=viewAirport();
				Optional <Airport> optional=list.stream().
						filter(a1->a1.getAirportCode().equalsIgnoreCase(airportCode)).findFirst();
				
				if(optional.isPresent())
				{
					return daoInt.viewAirport(airportCode);
				}
				
				else
					throw new FMSException("Airport Code does not exist");
				
				
				
				//return flightDao.viewAirport(airportCode);
			}	
			
	//ScheduledFlight
			
			public List<ScheduledFlight> viewScheduledFlights(){
				return daoInt.viewScheduledFlights();
			}
			
			public ScheduledFlight viewScheduledFlight(int flightNumber) throws FMSException {
				
				List<ScheduledFlight> list=viewScheduledFlights();
				Optional <ScheduledFlight> optional=list.stream().
						filter(a1->a1.getFlight().getFlightNumber()==flightNumber).findFirst();
				
				if(optional.isPresent())
				{
					return daoInt.viewScheduledFlight(flightNumber);
					
					
				}
				
				else
					throw new FMSException("flightnumber does not exist");
				
				//return flightDao.viewScheduledFlight(flightNumber);
			}
			
			public String scheduleFlight(ScheduledFlight scheduledFlight) throws FMSException {
				
//				List<ScheduledFlight> list=viewScheduledFlights();
//				Optional <ScheduledFlight> optional=list.stream().
//						filter(sf1->sf1.getScheduledFlightId()==scheduledFlight.getScheduledFlightId()).findFirst();
//				
//				if(optional.isPresent())
//				{
//					throw new FMSException("This ID already exist try new one");
//					
//				}
//				
//				else
//					return flightDao.scheduleFlight(scheduledFlight);
				return daoInt.scheduleFlight(scheduledFlight);
			}
			
			public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
				return daoInt.modifyScheduledFlight(flight, schedule, flightNumber);
			}
			
//			public String deleteScheduledFlight(int flightNumber) {
//				return flightDao.deleteScheduledFlight(flightNumber);
//			}
			
			public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate){
				return daoInt.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
			}
//			
//			public List<ScheduledFlight> viewScheduledFlights(String sourceAirport,String destinationAirport,LocalDate arrivalDate){
//				return flightDao.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
//			}
			
			
			
	//Schedule
			
			public List<Schedule> viewAllSchedule()
			{
				return daoInt.viewAllSchedule();
			}
//			
//			public String addSchedule(Schedule schedule) throws FMSException
//			{
//				List<Schedule> list=viewAllSchedule();
//				Optional <Schedule> optional=list.stream().
//						filter(s1->s1.getScheduleId()==schedule.getScheduleId()).findFirst();
//				
//				if(optional.isPresent())
//				{
//					throw new FMSException("This ID id already taken ");
//					
//				}
//				
//				else
//					return flightDao.addSchedule(schedule);
//				
//				
//				
//				//return flightDao.addSchedule(schedule);
//			}
	
}
