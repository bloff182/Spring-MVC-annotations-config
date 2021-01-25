package com.bloff.springsecurity.dao;

import java.util.List;

import com.bloff.springsecurity.Entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public Customer saveCustomer(Customer theCustomer);
	
	public void delete(int id);
}
