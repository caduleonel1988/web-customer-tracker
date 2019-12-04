package br.com.carlos.customertracker.model.service;

import java.util.List;

import br.com.carlos.customertracker.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
}
