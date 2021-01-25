package com.bloff.springsecurity.service;

import java.util.List;

import com.bloff.springsecurity.Entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public Customer saveCustomer(Customer theCustomer);
	
	public void delete(int id);
}
