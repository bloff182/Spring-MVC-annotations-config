package com.bloff.springsecurity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bloff.springsecurity.Entity.Customer;

@Repository
public class CustomerDaoImplement implements CustomerDAO {

	@Autowired
	@Qualifier("customerSessionFactory") // dodane gdy mamy multidataSources
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// rozpoczniemy sesje Hibernate
		Session session = factory.getCurrentSession();
		
		// pobierzemy liste obiektow
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);	
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {

		Session session = factory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
		return theCustomer;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
