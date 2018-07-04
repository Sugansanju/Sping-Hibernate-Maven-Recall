package com.dexter.backend.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.dexter.backend.model.Customer;

@Service
public class UserServiceImpl implements UserService {
	
	   @PersistenceContext
	    private EntityManager entityManager;
	
	/*@Autowired
	private CustomerDao customerDao;
	public CustomerDao getcustomerDao() {
		return customerDao;
	}*/
	   @SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		 /*  return customerDao.listCustomers();*/
		return entityManager.createQuery("select cus from Customer cus").getResultList();
	}

	public Customer getById(int id) {		
		return entityManager.find(Customer.class,id);
	}

	public Customer getByEmailId(String emailId) {
		
		return null;
	}

	public void saveCustomer(Customer customer) {
		
	}

	public void updateCustomer(Customer customer) {
	
		entityManager.merge(customer);
	}

	public Customer validate(Customer customer) {
	
		return null;
	}

	public List<Customer> findAllCustomers(Customer customer) {
	
		return null;
	}

	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
