package com.pkg.dao;

import java.util.List;

import com.pkg.entity.Customer;

public interface customerDAO {
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getSpecificCustomer(int id);

	public void delete(int id);
}
