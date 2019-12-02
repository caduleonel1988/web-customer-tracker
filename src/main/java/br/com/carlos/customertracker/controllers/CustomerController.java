package br.com.carlos.customertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carlos.customertracker.dao.CustomerDAO;
import br.com.carlos.customertracker.entities.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value = "/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers = customerDAO.getCustomers();
		
		// add the customers to the model
		model.addAttribute(customers);
		
		return "list-customers";

	}
}
