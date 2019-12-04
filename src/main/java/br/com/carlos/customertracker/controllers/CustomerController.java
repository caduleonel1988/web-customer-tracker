package br.com.carlos.customertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import br.com.carlos.customertracker.dao.CustomerDAO;
import br.com.carlos.customertracker.entities.Customer;

@Controller
@RequestMapping(value = "/customer")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CustomerController {

	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value = "/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers = customerDAO.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";

	}
}
