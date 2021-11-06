package com.simplilearn.workshop.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	private Integer id;
	//@NotNull @Size (min = 2, message = "first name should have atleast 2 characters")
	private String firstName;
	//@NotNull @Size (min = 2, message = "last name should have atleast 2 characters")
	private String lastName;
	//@NotEmpty @Email(message = "email is a required field", regexp = "")
	private String email;

	public Customer() {
		super();
	}

	public Customer(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, firstName=%s, lastName=%s, email=%s]", id, firstName, lastName, email);
	}

}
