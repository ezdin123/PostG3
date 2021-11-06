package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service(value ="customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.getCustomers();
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		return customerRepository.saveCustomer(theCustomer) ;
	}

	@Override
	public Customer getCustomer(Integer theId) {
		return customerRepository.getCustomer(theId);
	}

	@Override
	public void deleteCustomer(Integer theid) {
		customerRepository.deleteCustomer(theid);
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		customerRepository.updateCustomer(theCustomer);
		
	}

}
