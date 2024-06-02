package com.infybank;

 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
public class CustomerAccountDemo 
{
	static Logger logger = Logger.getLogger(CustomerAccountDemo.class);
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		logger.info("1. New Account to new customer ");
		logger.info("2. New Account to existing customer");
		logger.info("Choose one option");
		int opt = sc.nextInt();
		switch (opt) {
		case 1:
			newAccountNewCustomer(sc);
			break;
		case 2:
			newAccountExistingCustomer(sc);
			break;
		default:
			logger.info("Choose correct option");
		}
 
	}
 
	public static void newAccountNewCustomer(Scanner sc) {
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
			System.out.println("Enter the Customer address");
			String address = sc.next();
			System.out.println("Enter the Customer phoneNo");
			long phone = sc.nextLong();
			
			System.out.println("Enter the Account details");
			System.out.println("Enter the Account No");
			Long accountId = sc.nextLong();
			System.out.println("Enter the Account type");
			String accountType = sc.next();
			System.out.println("Enter the Account opening date in dd-MMM-yyyy format(Correct format is 22-Apr-1993)");
			String openingDatestr = sc.next();
			LocalDate openingDate = LocalDate.parse(openingDatestr, formatter);
			
			System.out.println("Enter the balance");
			Double balance = sc.nextDouble();
			System.out.println("Enter the account status");
			String status = sc.next();
			
			Account account = new Account(accountId, accountType, openingDate, balance, status);
			Customer customer = new Customer(id, name, dob, address, phone);
			customerdao.newAccountNewCustomer(customer, account);
			logger.info("One record created");
			sc.close();
		} catch (HibernateException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
	}
 
	public static void newAccountExistingCustomer(Scanner sc) {
		CustomerDAO customerdao = new CustomerDAO();
		try {
			System.out.println("Enter the Customer Id");
			int id = sc.nextInt();
			
			System.out.println("Enter the Account details");
			System.out.println("Enter the Account No");
			Long accountId = sc.nextLong();
			System.out.println("Enter the Account type");
			String accountType = sc.next();
			System.out.println("Enter the Account opening date in dd-MMM-yyyy format(Correct format is 22-Apr-1993)");
			String openingDatestr = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate openingDate = LocalDate.parse(openingDatestr, formatter);
			System.out.println("Enter the balance");
			Double balance = sc.nextDouble();
			System.out.println("Enter the account status");
			String status = sc.next();
			
			Account account = new Account(accountId, accountType, openingDate, balance, status);
			customerdao.newAccountExistingCustomer(id, account);
			logger.info("One record created");
			sc.close();
		} catch (HibernateException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}	
	}
}
