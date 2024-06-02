package com.infybank;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "account")
public class Account {
	@Id
	private Long accountNo;
	private String accountType;
	private LocalDate openingDate;
	private Double balance;
	private String accountStatus;
	// Generate Getters and Setters
 
	public Long getAccountNo() {
		return accountNo;
	}
 
	public Account(Long accountNo, String accountType, LocalDate openingDate, Double balance, String accountStatus) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.balance = balance;
		this.accountStatus = accountStatus;
	}
 
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
 
	public String getAccountType() {
		return accountType;
	}
 
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
 
	public LocalDate getOpeningDate() {
		return openingDate;
	}
 
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
 
	public Double getBalance() {
		return balance;
	}
 
	public void setBalance(Double balance) {
		this.balance = balance;
	}
 
	public String getAccountStatus() {
		return accountStatus;
	}
 
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
 
}