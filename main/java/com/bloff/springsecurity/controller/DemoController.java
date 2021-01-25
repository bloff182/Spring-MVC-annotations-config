package com.bloff.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bloff.springsecurity.Entity.Customer;
import com.bloff.springsecurity.service.CustomerService;

@Controller
@RequestMapping("/api")
public class DemoController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/home")
	public String list(Model theModel) {
		
		//pobieramy liste klientow z db
		List<Customer> customers = customerService.getCustomers();
		
		// dodajemy liste do atrybutu modelu
		theModel.addAttribute("customers", customers);
				
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String save(@ModelAttribute("customer")Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/api/home";
	}

}
