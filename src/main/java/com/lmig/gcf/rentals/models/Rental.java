package com.lmig.gcf.rentals.models;

public class Rental {

	private Car vehicle;
	private Person customer;
	
	public Rental(Car vehicle, Person customer) {
		this.customer = customer;
		this.vehicle = vehicle;
	}

	public Car getVehicle() {
		return vehicle;
	}

	public Person getCustomer() {
		return customer;
	}
	
}
