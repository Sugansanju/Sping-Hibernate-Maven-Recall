package com.dexter.backend.dao;

import java.util.List;
import java.util.Set;

import com.dexter.backend.model.Customer;

public interface CustomerDao {
	public void save(Customer entity);
	public void delete(int id);
	public void update(Customer entity);
	public Customer findByEmail(String email,String password);
	public boolean validate(String email,String password);
	public Set<Customer> findAll();
	public List<Customer> listCustomers();
}
