package com.dexter.backend.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dexter.backend.dao.CustomerDao;
import com.dexter.backend.model.Customer;

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
	public Customer findByEmail(String email, String password) {
		Session session=sessionFactory.openSession();
		String hql = "FROM Customer u WHERE u.email = '" + email +"'AND u.password ='" + password + "'" ;
		Query query = session.createQuery(hql);
		List results=null;
		results = query.list();
	/*	List results = query.list();*/
		if(results.size()>0)
			return (Customer) results.get(0);
		
		else
			return null;	
	}


	public boolean validate(String email, String password) {
		Session session=sessionFactory.openSession();
		String hql = "FROM Customer u WHERE u.email = '" + email +"' AND u.password ='" + password + "'" ;
		Query query = session.createQuery(hql);
		List results = query.list();
		if(results!=null)
			return true;
		else
			return false;				
	}

	public Set<Customer> findAll() {

		return null;
	}
	public List<Customer> listCustomers() {
	
		return null;
	}
	
}
