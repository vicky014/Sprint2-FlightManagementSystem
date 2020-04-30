package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
	
	
	@Id
	private int scheduleId;
	
	@OneToOne
	@JoinColumn(name="sourceairport",referencedColumnName = "airportCode")
	private Airport sourceAirport;

//	private String sourceAirport;
	
	@OneToOne
	@JoinColumn(name="destinationairport",referencedColumnName = "airportCode")
	private Airport destinationAirport;

//	private String destinationAirport;
	
	@Column(name="arrivaldate")
	private LocalDate arrivalDate;
	
	@Column(name="DepartureDate")
	private LocalDate departureDate;
	
	@Column(name="ArrivalTime")
	private String arrivalTime;
	
	@Column(name="DepartureTime")
	private String departureTime;
	
	
	
	
////////////////////////////////
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="sf",referencedColumnName = "scheduledFlightId")
	private ScheduledFlight scheduledFlight2;
//////////////////////////////
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(int scheduleId, Airport sourceAirport, Airport destinationAirport, LocalDate arrivalDate,
			LocalDate departureDate, String arrivalTime, String departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	
	
	

	public int getScheduleId() {
		return scheduleId;
	}

//	public Schedule(int scheduleId, String sourceAirport, String destinationAirport, LocalDate arrivalDate,
//		LocalDate departureDate, String arrivalTime, String departureTime) {
//	super();
//	this.scheduleId = scheduleId;
//	this.sourceAirport = sourceAirport;
//	this.destinationAirport = destinationAirport;
//	this.arrivalDate = arrivalDate;
//	this.departureDate = departureDate;
//	this.arrivalTime = arrivalTime;
//	this.departureTime = departureTime;
//}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

//	public String getSourceAirport() {
//		return sourceAirport;
//	}
//
//	public void setSourceAirport(String sourceAirport) {
//		this.sourceAirport = sourceAirport;
//	}
//
//	public String getDestinationAirport() {
//		return destinationAirport;
//	}
//
//	public void setDestinationAirport(String destinationAirport) {
//		this.destinationAirport = destinationAirport;
//	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	
	
	

}
