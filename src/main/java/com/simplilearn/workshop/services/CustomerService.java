package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public void deleteCustomer(Integer theid);
	public void updateCustomer(Customer theCustomer);

}
