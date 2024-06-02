package com.infy.dto;


public class CustomerDTO {
	private Integer customerId;
	private String emailId;
	private String firstName;
	private String lastName;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	

	
}
