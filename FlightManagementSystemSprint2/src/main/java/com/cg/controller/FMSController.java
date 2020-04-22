package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;
import com.cg.service.FMSService;


@Component
@RestController
public class FMSController {

	@Autowired
	FMSService fmsService;
	
	//Flight
	
		@GetMapping("/flight")
		public List<Flight> viewFlight()
		{
			return fmsService.viewFlight();
		}
		
		@GetMapping(value="/flight/{flightNumber}",produces= {"application/json"})
		public Flight viewFlight(@PathVariable int flightNumber) {
			return fmsService.viewFlight(flightNumber);
		}
		
		@PostMapping(value="/flight/add",consumes={"application/json"})
		public String addFlight(@RequestBody Flight flight){
			return fmsService.addFlight(flight);
		}

		@DeleteMapping("/flight/delete/{flightNumber}")
		public String deleteFlight(@PathVariable int flightNumber){
			return fmsService.deleteFlight(flightNumber);
		}
		
		@PutMapping(value="/flight/modify",consumes= {"application/json"})
		public String modifyFlight(@RequestBody Flight flight){
			return fmsService.modifyFlight(flight);
		}
		
		
		//Airport
		
			@PostMapping(value="/airport/add",consumes= {"application/json"})
			public String addAirport(@RequestBody Airport airport) {
				return fmsService.addAirport(airport);
				
			}
		
			@GetMapping(value="/airport")
			public List<Airport> viewAirport(){
				return fmsService.viewAirport();
			}
			
			@GetMapping(value="/airport/{airportCode}")
			public Airport viewAirport(@PathVariable String airportCode) {
				return fmsService.viewAirport(airportCode);
			}
			

			//ScheduledFlight
			
			@GetMapping("/scheduledFight")
			public List<ScheduledFlight> viewScheduledFlights(){
				return fmsService.viewScheduledFlights();
			}
			
			@GetMapping(value="/scheduledFight/{flightNumber}",produces= {"application/json"})
			public ScheduledFlight viewScheduledFlight(@PathVariable int flightNumber) {
				return fmsService.viewScheduledFlight(flightNumber);
			}
			
			@PostMapping(value="/scheduledFight/add",produces= {"application/json"})
			public String scheduleFlight(@RequestBody ScheduledFlight scheduledFlight) {
				return fmsService.scheduleFlight(scheduledFlight);
			}
			
			@PutMapping(value="/scheduledFight/modify",consumes= {"application/json"})
			public String modifyScheduledFlight(@RequestBody Flight flight,Schedule schedule,int flightNumber) {
				return fmsService.modifyScheduledFlight(flight, schedule, flightNumber);
			}
			
			@DeleteMapping(value="/scheduledFight/delete/{flightNumber}")
			public String deleteScheduledFlight(@PathVariable int flightNumber) {
				return fmsService.deleteFlight(flightNumber);
			}
			
			//doubt
			@GetMapping(value="/scheduledFight/search",produces= {"application/json"})
			public List<ScheduledFlight> viewScheduledFlights(@RequestBody Airport sourceAirport,@RequestBody Airport destinationAirport,@RequestBody LocalDate arrivalDate){
				return fmsService.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
			}
			
			//Schedule
			
			@GetMapping("/schedule")
			public List<Schedule> viewAllSchedule(){
				return fmsService.viewAllSchedule();
			}
//			
//			@PostMapping(value="/schedule/add",produces="{application/json}")
//			public String addSchedule(@RequestBody Schedule s)
//			{
//				return fmsService.addSchedule(s);
//			}
}
