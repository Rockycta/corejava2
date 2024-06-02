package com.infybank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
public class CustomerAddressDemo 
{
	static Logger logger = Logger.getLogger(CustomerAddressDemo.class);
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		logger.info("1. New loan to new customer ");
		logger.info("2. New loan to existing customer");
		logger.info("Choose one option");
		int opt = sc.nextInt();
		switch (opt) {
		case 1:
			newCustomerNewAddress(sc);
			break;
		case 2:
			newCustomerExistingAddress(sc);
			break;
		default:
			logger.info("Choose correct option");
		}
 
	}
 
	public static void newCustomerNewAddress(Scanner sc) {
		CustomerDAO customerdao = new CustomerDAO();
		try {
			logger.info("Enter the Customer details");
			System.out.println("Enter the Customer Id");
			int id = sc.nextInt();
			System.out.println("Enter the Customer name");
			String name = sc.next();
			System.out.println("Enter the Customer date of birth in dd-MMM-yyyy format(Correct format is 22-Apr-1993)");
			String dobInString = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate dob = LocalDate.parse(dobInString, formatter);
			
			System.out.println("Enter the Customer phoneNo");
			long phone = sc.nextLong();
			System.out.println("Do you want to enter the address(Y/N)");
			String isAddress = sc.next();
			Address address = null;
			if (isAddress.compareToIgnoreCase("y") == 0) {
				System.out.println("Enter the Address details");
				System.out.println("Enter the Address Id");
				String addId = sc.next();
				System.out.println("Enter the Address Line");
				String line = sc.next();
				System.out.println("Enter the district");
				String dist = sc.next();
				System.out.println("Enter the State");
				String state = sc.next();
				System.out.println("Enter the Pincode");
				Long pincode = sc.nextLong();
				address = new Address(addId, line, dist, state, pincode);
			}
			Customer customer = new Customer(id, name, dob, address, phone);
			customerdao.newCustomerNewAddress(customer, address);
			logger.info("One record created");
			sc.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
	}
 
	public static void newCustomerExistingAddress(Scanner sc) {
		CustomerDAO customerdao = new CustomerDAO();
		try {
			System.out.println("Enter the Customer Id");
			Integer id=sc.nextInt();
			System.out.println("Enter the Address details");
			System.out.println("Enter the Address Id");
			String addId = sc.next();
			System.out.println("Enter the Address Line");
			String line = sc.next();
			System.out.println("Enter the district");
			String dist = sc.next();
			System.out.println("Enter the State");
			String state = sc.next();
			System.out.println("Enter the Pincode");
			Long pincode = sc.nextLong();
			Address address = new Address(addId, line, dist, state, pincode);
			customerdao.newCustomerExistingAddress(id, address);
			logger.info("One record created");
			sc.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
