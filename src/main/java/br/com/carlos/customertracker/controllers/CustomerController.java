package br.com.carlos.customertracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@RequestMapping(value = "list")
	public String listCustomers(Model model) {
			
		return "list-customers";

	}
}
