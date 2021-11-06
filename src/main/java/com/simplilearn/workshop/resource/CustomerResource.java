package com.simplilearn.workshop.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.exception.CustomerNotFoundException;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;

@RestController
public class CustomerResource {
	@Autowired
	public CustomerService customerService;

	@GetMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// Get all the customers URI (/customers)
	// HTTP method GET
//	@RequestMapping(path = "/customers",method = RequestMethod.GET)
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerService.getCustomers();
	}

	// GET URI: localhost:8080/customers/101 .. 102 ... 103 so on
	@GetMapping("/customers/{theId}")
	public Customer retriveCustomer(@PathVariable Integer theId) {
		Customer theCustomer = customerService.getCustomer(theId);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("id - " + theId);
		}
		return theCustomer;
	}

	// POST URI : localhost:8080/customers
	// Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to
	// parameter
	// Response : status code : 201 , URI --- > new resource in a response header
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.saveCustomer(theCustomer);

		// location : localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}")
				.buildAndExpand(savedCustomer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer theId) {
		Customer theCustomer = customerService.getCustomer(theId);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("id -" + theId);
		}
		customerService.deleteCustomer(theId);
	}

	@PutMapping("/customers/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Customer updateCustomer(@PathVariable Integer theId, @RequestBody Customer theCustomer) {
		Customer saveCustomer = customerService.getCustomer(theId);
		saveCustomer.setId(theId);
		saveCustomer.setFirstName(theCustomer.getFirstName());
		saveCustomer.setLastName(theCustomer.getLastName());
		saveCustomer.setEmail(theCustomer.getEmail());
		return saveCustomer;

	}

}
