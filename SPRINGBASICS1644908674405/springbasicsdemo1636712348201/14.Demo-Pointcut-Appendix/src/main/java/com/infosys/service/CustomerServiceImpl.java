package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.CustomerDTO;
import com.infosys.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public String createCustomer(CustomerDTO customerDTO) {
		customerRepository.createCustomer(customerDTO);

		return "Customer with " + customerDTO.getPhoneNo() + " added successfully";
	}

	public List<CustomerDTO> fetchCustomer() {
		return customerRepository.fetchCustomer();
	}

	public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {

		return customerRepository.updateCustomer(phoneNumber, customerDTO);
	}

	public String deleteCustomer(long phoneNumber) {

		return customerRepository.deleteCustomer(phoneNumber);
	}
}