package br.com.carlos.customertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import br.com.carlos.customertracker.entities.Customer;
import br.com.carlos.customertracker.model.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CustomerController {

	// inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/list")
	public String listCustomers(Model model) {
		
		// get customers from the service layer
		List<Customer> customers = customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";

	}
}
