package com.aurionpro.model;

public class Profile {

	private String name;
	private String mobileNumber;
	private String address;
	public Profile(String name, String mobileNumber, String address) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
