package com.infybank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class CustomerDAO implements MtoOCustomer {
	SessionFactory factory;
	 
	public void newCustomerNewAddress(Customer customer, Address address) {
		customer.setAddress(address);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);     
		tx.commit();
		session.close();
	}
 
	public void newCustomerExistingAddress(int id, Address address) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		customer.setAddress(address);
		Transaction tx = session.beginTransaction();
		session.save(customer);      
		tx.commit();
		session.close();
		
	}
}
