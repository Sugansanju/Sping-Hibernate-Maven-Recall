package com.dexter.backend.service;

import java.util.List;

import com.dexter.backend.model.Customer;

public interface UserService {
	List<Customer> getAllCustomer();
  	Customer getById(int id);
  	Customer getByEmailId(String emailId); 
  	void saveCustomer(Customer customer); 
  	void updateCustomer(Customer customer); 
  	Customer validate (Customer customer);
  	List<Customer> findAllCustomers(Customer customer);
  	Customer findById(long id);  
}
