package com.infybank;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private LocalDate dateOfBirth;
	@ManyToOne(cascade  =CascadeType.ALL) 
	@JoinColumn(name = "addressId")      
	private Address address;
	private long phoneNo;
 
        public Customer() {
		super();
	}	
 
	public Customer(int customerId, String customerName, LocalDate dateOfBirth, Address address, long phoneNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
	}
 
	public int getCustomerId() {
		return customerId;
	}
 
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
 
	public String getCustomerName() {
		return customerName;
	}
 
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
 
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
 
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
 
	public Address getAddress() {
		return address;
	}
 
	public void setAddress(Address address) {
		this.address = address;
	}
 
	public long getPhoneNo() {
		return phoneNo;
	}
 
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}