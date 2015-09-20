package com.gsa.domain;

import java.util.Date;

import com.google.android.gms.maps.model.LatLng;

public class TruckCurrentStatus {
	private int id;
	private Truck truck;
	private String addressGoing;
	private LatLng currentPosition;
	private Date reportingTime;
	private String status;
	
	public TruckCurrentStatus(){
		
	}

	public TruckCurrentStatus(int id, Truck truck, String addressGoing,
			LatLng currentPosition, Date reportingTime, String status) {
		super();
		this.id = id;
		this.truck = truck;
		this.addressGoing = addressGoing;
		this.currentPosition = currentPosition;
		this.reportingTime = reportingTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public String getAddressGoing() {
		return addressGoing;
	}

	public void setAddressGoing(String addressGoing) {
		this.addressGoing = addressGoing;
	}

	public LatLng getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(LatLng currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Date getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	

	
	
	

}
