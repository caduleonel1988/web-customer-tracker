package br.com.carlos.customertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import br.com.carlos.customertracker.entities.Customer;
import br.com.carlos.customertracker.model.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
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

	@GetMapping(value = "/addCustomerForm")
	public String showAddCustomerForm(Model model) {
		
		// model attribute to bind form data
		Customer customer = new Customer();
		
		// add the attribute to the model
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping(value="/saveCustomer")
	public String saveCustomer(@ModelAttribute(name="customer") Customer customer) {
		
		// save the customer using the service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping(value="updateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") long id, Model model) {
		
		// get the customer from database
		Customer customer = customerService.getCustomer(id);
		
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
}
