package com.gsa.domain;

public class Truck {
	private int id;
	private String truckName;
	
	public Truck(){}

	public Truck(int id, String truckName) {
		super();
		this.id = id;
		this.truckName = truckName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	

}
