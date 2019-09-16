package com.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pkg.entity.Customer;
import com.pkg.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class customerController {

	@Autowired
	public CustomerService CustomerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel)
	{
		List<Customer> customer = CustomerService.getCustomer(); 
		theModel.addAttribute("lst",customer);
		return "listCustomer";
	}
	
	@RequestMapping("/FormForAdd")
	public String addHandler(Model theModel)
	{
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		return "addCustomer";
	}
	
	@PostMapping("saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		CustomerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/FormForUpdate")
	public String FormForUpdate(@RequestParam("customerID") int id,
								Model theModel)
	{
		Customer customer = CustomerService.getSpecificCustomer(id);
		theModel.addAttribute("customer",customer);
		return "addCustomer";
	}

	@RequestMapping("/FormForDelete")
	public String FormForDelete(@RequestParam("customerID") int id,
								Model theModel)
	{
		CustomerService.delete(id);
		return "redirect:/customer/list";
	}
	
}
