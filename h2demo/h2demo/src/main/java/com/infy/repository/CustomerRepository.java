package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
