package com.gsa.domain;

import com.google.android.gms.maps.model.LatLng;

public class TruckRoamingHistory {
	private int id;
	private Truck truck;
	private LatLng startPosition;
	private LatLng endPosition;
	private String duration;
	private String status;
	
	public TruckRoamingHistory(){ 
		
	}

	public TruckRoamingHistory(int id, Truck truck, LatLng startPosition,
			LatLng endPosition, String duration, String status) {
		super();
		this.id = id;
		this.truck = truck;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.duration = duration;
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

	public LatLng getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(LatLng startPosition) {
		this.startPosition = startPosition;
	}

	public LatLng getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(LatLng endPosition) {
		this.endPosition = endPosition;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
