package com.cg;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.FMSDao;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

@SpringBootApplication
public class FlightManagementSystemSprint2Application implements CommandLineRunner{

	@Autowired
	FMSDao fdao;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemSprint2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome");
		

		Flight f=new Flight(100,"A1","Indigo",200);
		
		fdao.addFlight(f);
		
		
		Airport a=new Airport("VTZ","Vizag Airport","Vishakapatanam");
		Airport a1=new Airport("DEL","IGI Airport","New Delhi");
		
		fdao.addAirport(a);
		fdao.addAirport(a1);
		
		

		Schedule s=new Schedule(1,a,a1,LocalDate.of(2020, 10, 20),LocalDate.of(2020, 10, 20),"12:15","12:30");
		
		
		fdao.addSchedule(s);
		
	
		ScheduledFlight sf=new ScheduledFlight(1, f, 20,s);
		fdao.scheduleFlight(sf);
		
	}

}
