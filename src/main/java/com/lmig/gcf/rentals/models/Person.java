package com.lmig.gcf.rentals.models;

public class Person {

	private String firstName;
	private String lastName;
	private String licenseNumber;
	private String state;
	
	public Person(String firstName, String lastName, String licenseNumber, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.licenseNumber = licenseNumber;
		this.state = state;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getState() {
		return state;
	}
	
}
