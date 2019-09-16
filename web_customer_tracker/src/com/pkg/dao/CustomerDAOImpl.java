package com.pkg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pkg.entity.Customer;

@Repository
public class CustomerDAOImpl implements customerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> lst = theQuery.getResultList();
		return lst;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getSpecificCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
//		Customer customer = session.get(Customer.class, id);
//		session.delete(customer);

		Query theQuery = session.createQuery("delete from customer where id := customerID");
		theQuery.setParameter("customerID",id);
		theQuery.executeUpdate();
	}
}
