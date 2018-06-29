package com.dexter.backend.Impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dexter.backend.Dao.CustomerDao;
import com.dexter.backend.Model.Customer;

@Repository
public class CustomerImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Customer entity) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Customer entity) {
		// TODO Auto-generated method stub
		
	}

	public Customer findById(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validate(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
