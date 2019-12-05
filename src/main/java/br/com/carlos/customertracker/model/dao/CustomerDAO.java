package br.com.carlos.customertracker.model.dao;

import java.util.List;

import br.com.carlos.customertracker.entities.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
