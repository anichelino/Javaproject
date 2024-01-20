package com.poised.entity;

public class Person {
	private String name;
	private String telephoneNumber;
	private String emailAddress;
	private Address physicalAddress;

	public Person(String name, String telephoneNumber, String emailAddress, Address physicalAddress) {
		super();
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Address getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(Address physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", telephoneNumber=" + telephoneNumber + ", emailAddress=" + emailAddress
				+ ", physicalAddress=" + physicalAddress + "]";
	}
}
