package com.infy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String addCustomer(CustomerDTO customerDTO) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerDTO.getCustomerId());
		if (optional.isPresent())
			throw new InfyBankException("Service.EMPLOYEE_FOUND");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customerRepository.saveAndFlush(customer);
		return "Employee details added successfully";
	}

}
