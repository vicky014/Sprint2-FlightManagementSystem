package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.FMSDao;
import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

@Service
public class FMSService {

	@Autowired
	private FMSDao flightDao;
	
	//Flight
			public List<Flight> viewFlight(){
				return flightDao.viewFlight();
			}
			
			public Flight viewFlight(int flightNumber) {
				return flightDao.viewFlight(flightNumber);
			}
			
			public String addFlight(Flight flight) {
				return flightDao.addFlight(flight);
			}
			
			public String deleteFlight(int flightNumber) {
				return flightDao.deleteFlight(flightNumber);
			}
			
			public String modifyFlight(Flight flight) {
				return flightDao.modifyFlight(flight);
			}
			
	//Airport
			
			public String addAirport(Airport a) {
				return flightDao.addAirport(a);
			}
			
			public List<Airport> viewAirport(){
				return flightDao.viewAirport();
			}
			
			public Airport viewAirport(String airportCode) {
				return flightDao.viewAirport(airportCode);
			}	
			
	//ScheduledFlight
			
			public List<ScheduledFlight> viewScheduledFlights(){
				return flightDao.viewScheduledFlights();
			}
			
			public ScheduledFlight viewScheduledFlight(int flightNumber) {
				return flightDao.viewScheduledFlight(flightNumber);
			}
			
			public String scheduleFlight(ScheduledFlight scheduledFlight) {
				return flightDao.scheduleFlight(scheduledFlight);
			}
			
			public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
				return flightDao.modifyScheduledFlight(flight, schedule, flightNumber);
			}
			
			public String deleteScheduledFlight(int flightNumber) {
				return flightDao.deleteScheduledFlight(flightNumber);
			}
			
			public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate){
				return flightDao.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
			}
			
	//Schedule
			
			public List<Schedule> viewAllSchedule()
			{
				return flightDao.viewAllSchedule();
			}
			
			public String addSchedule(Schedule s)
			{
				return flightDao.addSchedule(s);
			}
	
}
