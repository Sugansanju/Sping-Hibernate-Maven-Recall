package com.dexter.backend.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexter.backend.dao.CustomerDao;
import com.dexter.backend.model.Customer;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	public Customer getById(int id) {
		  return customerDao.getById(id); 
		  }

	public int save(Customer customer) {
		
		return customerDao.save(customer);
		
	}
	public void update(Customer customer) {
	customerDao.update(customer);
	}

	public void delete(int id) {
		customerDao.delete(id);
	}

	public boolean add(Customer customer) {
		return customerDao.add(customer);
	}
	
/*	   @PersistenceContext
	    private EntityManager entityManager;

	   @SuppressWarnings("unchecked")
	   public List<Customer> getAllCustomer() {
		return entityManager.createQuery("select cus from Customer cus").getResultList();
	}

	public Customer getById(int id) {		
		return entityManager.find(Customer.class,id);
	}

	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}*/
}
