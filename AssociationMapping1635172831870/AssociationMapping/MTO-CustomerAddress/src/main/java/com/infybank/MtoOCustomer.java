package com.infybank;

public interface MtoOCustomer {
	public void newCustomerNewAddress(Customer customer, Address loan);
	public void newCustomerExistingAddress(int id, Address loan);
}