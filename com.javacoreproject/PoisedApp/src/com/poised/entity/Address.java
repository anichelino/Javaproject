package com.poised.entity;

public class Address {
	private int zipcode;
	private String city;
	private String state;
	private String addressline;

	public Address(int zipcode, String city, String state, String addressline) {
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.addressline = addressline;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddressline() {
		return addressline;
	}
	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", addressline=" + addressline
				+ "]";
	}

}
