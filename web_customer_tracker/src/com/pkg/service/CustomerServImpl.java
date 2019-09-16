package com.pkg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pkg.dao.customerDAO;
import com.pkg.entity.Customer;

@Service
public class CustomerServImpl implements CustomerService {

	@Autowired
	private customerDAO CustomerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return CustomerDAO.getCustomer();
	}
	
	@Transactional
	public void saveCustomer(Customer customer)
	{
		CustomerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getSpecificCustomer(int id) {
		return CustomerDAO.getSpecificCustomer(id);
		//return null;
	}

	@Override
	@Transactional
	public void delete(int id) {
		CustomerDAO.delete(id);
	}

}
