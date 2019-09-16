package com.pkg.service;

import java.util.List;

import com.pkg.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomer(); 
	public void saveCustomer(Customer theCustomer);
	public Customer getSpecificCustomer(int id);
	public void delete(int id);
}
