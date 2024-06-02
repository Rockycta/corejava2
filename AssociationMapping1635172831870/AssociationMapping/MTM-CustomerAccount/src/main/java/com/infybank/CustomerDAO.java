package com.infybank;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAO implements MtoMCustomer {
	SessionFactory factory;
 
	public void newAccountNewCustomer(Customer customer, Account account) {
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		customer.setAccounts(accounts);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);     
		tx.commit();
		session.close();
	}
 
	public void newAccountExistingCustomer(int id, Account account) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		List<Account> accounts = customer.getAccounts();
		if(accounts !=null){
			accounts.add(account);
		}else{
			accounts = new ArrayList<Account>();
			accounts.add(account);
		}
		Transaction tx = session.beginTransaction();
		session.save(customer);       
		tx.commit();
		session.close();
	}
	
}