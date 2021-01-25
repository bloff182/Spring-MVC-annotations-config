package com.bloff.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloff.springsecurity.Entity.Customer;
import com.bloff.springsecurity.dao.CustomerDAO;

@Service
public class CustomerServiceImplement implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional("customerTransactionManager") // dodane gdy mamy multidataSources
	// @Transactional 
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional("customerTransactionManager") // dodane gdy mamy multidataSources
	// @Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional("customerTransactionManager") // dodane gdy mamy multidataSources
	// @Transactional
	public Customer saveCustomer(Customer theCustomer) {
		return customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional("customerTransactionManager") // dodane gdy mamy multidataSources
	// @Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}

}
