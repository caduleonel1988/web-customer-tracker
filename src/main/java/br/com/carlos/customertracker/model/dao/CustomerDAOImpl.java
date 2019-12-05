package br.com.carlos.customertracker.model.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.carlos.customertracker.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create and execute a query to get a customers list
		List<Customer> customers = currentSession.createQuery("from Customer", Customer.class).getResultList();
		
		// return the results as an unmodifiable list
		return Collections.unmodifiableList(customers);
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// save the customer using the session
		sessionFactory.getCurrentSession().save(customer);
	}

}
