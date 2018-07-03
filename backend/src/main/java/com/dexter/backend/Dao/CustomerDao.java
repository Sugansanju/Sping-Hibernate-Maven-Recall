package com.dexter.backend.Dao;

import java.util.Set;

import com.dexter.backend.Model.Customer;

public interface CustomerDao {
	public void save(Customer entity);
	public void delete(int id);
	public void update(Customer entity);
	public Customer findByEmail(String email);
	public boolean validate(String email,String password);
	public Set<Customer> findAll();
}
