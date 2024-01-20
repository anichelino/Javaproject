package com.poised.entity;

import java.util.Date;

public class Project {
	private long projectNumber;
	private String projectName;
	private String buildingType;
	private Address projectAddress;
	private long erfNumber;
	private double totalFeeBeingCharged;
	private double totalFeePaid;
	private Date deadlineDate;
	private Date completionDate;
	private Person architect;
	private Person Contractor;
	private Person Customer;
	private String status;

	public Project(long projectNumber, String projectName, String buildingType, Address projectAddress, long erfNumber,
			double totalFeeBeingCharged,double totalFeePaid, Date deadlineDate, Person architect, Person contractor, Person customer) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.erfNumber = erfNumber;
		this.totalFeeBeingCharged = totalFeeBeingCharged;
		this.totalFeePaid = totalFeePaid;
		this.deadlineDate = deadlineDate;
		this.architect = architect;
		Contractor = contractor;
		Customer = customer;
		this.status = "started";
	}
	public long getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(long projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public double getTotalFeePaid() {
		return totalFeePaid;
	}
	public void setTotalFeePaid(double totalFeePaid) {
		this.totalFeePaid = totalFeePaid;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public Address getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(Address projectAddress) {
		this.projectAddress = projectAddress;
	}
	public long getErfNumber() {
		return erfNumber;
	}
	public void setErfNumber(long erfNumber) {
		this.erfNumber = erfNumber;
	}
	public double getTotalFeeBeingCharged() {
		return totalFeeBeingCharged;
	}
	public void setTotalFeeBeingCharged(double totalFeeBeingCharged) {
		this.totalFeeBeingCharged = totalFeeBeingCharged;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public Person getArchitect() {
		return architect;
	}
	public void setArchitect(Person architect) {
		this.architect = architect;
	}
	public Person getContractor() {
		return Contractor;
	}
	public void setContractor(Person contractor) {
		Contractor = contractor;
	}
	public Person getCustomer() {
		return Customer;
	}
	public void setCustomer(Person customer) {
		Customer = customer;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", projectName=" + projectName + ", buildingType="
				+ buildingType + ", projectAddress=" + projectAddress + ", erfNumber=" + erfNumber
				+ ", totalFeeBeingCharged=" + totalFeeBeingCharged + ", totalFeePaid=" + totalFeePaid
				+ ", deadlineDate=" + deadlineDate + ", completionDate=" + completionDate + ", architect=" + architect
				+ ", Contractor=" + Contractor + ", Customer=" + Customer + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
