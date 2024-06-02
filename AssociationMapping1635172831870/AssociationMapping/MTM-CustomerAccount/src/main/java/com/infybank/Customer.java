package com.infybank;
import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private LocalDate dateOfBirth;
	private String address;
	private long phoneNo;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customerAccount", 
            joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "accountNo", referencedColumnName = "accountNo"))
	private List<Account> accounts;
 
        public Customer() {
		super();
	}
 
	public Customer(int customerId, String customerName, LocalDate dateOfBirth, String address, long phoneNo) {
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
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
 
	public long getPhoneNo() {
		return phoneNo;
	}
 
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
 
	public List<Account> getAccounts() {
		return accounts;
	}
 
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}