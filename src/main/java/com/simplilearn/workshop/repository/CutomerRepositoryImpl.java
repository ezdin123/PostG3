package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;

@Repository(value ="customerRepository")
public class CutomerRepositoryImpl implements CustomerRepository {
	private static List<Customer> customers_list = new ArrayList<Customer>();

	private static Integer customerCount  = 3;
	// Add three customers
	static {
		customers_list.add(new Customer(101, "vinodh", "mahendra", "vinodh@pivotal.io"));
		customers_list.add(new Customer(102, "bhavya", "vinodh", "bhavya@collins.com"));
		customers_list.add(new Customer(103, "samarth", "vishnu", "smarth.vishnu@gmail.com"));

	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customers_list;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		if (theCustomer.getId() == null) {
			theCustomer.setId(++customerCount);
		}
		customers_list.add(theCustomer); // add to list
		return theCustomer;
	}

	@Override
	public Customer getCustomer(Integer theId) {
		for(Customer theCustomer: customers_list) {
			if(theCustomer.getId() == theId) {
				return theCustomer;
			}
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		Iterator<Customer> iterator = customers_list.iterator();
		while(iterator.hasNext()) {
			Customer theCustomer = iterator.next();
			if(theCustomer.getId() == id) {
				iterator.remove();
				return theCustomer;
			}
		}
		return null;
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
	}

}
