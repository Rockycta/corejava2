package com.infybank;

public interface MtoMCustomer {
	public void newAccountNewCustomer(Customer customer, Account account);
	public void newAccountExistingCustomer(int id, Account account);
}