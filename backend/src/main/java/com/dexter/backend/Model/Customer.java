package com.dexter.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Customer")
@Component
public class Customer {
		@Id
		@GeneratedValue
		private int id;
		private String name;
		private String email;
		private String password;
		private boolean enabled;
		private String role;
		/* public Customer()
		    {
		        super();
		    }
		    public Customer(int id, String name, String email,String password,boolean enabled,String role)
		    {
		        super();
		        this.id = id;
		        this.name = name;
		        this.email = email;
		        this.password=password;
		        this.enabled=enabled;
		        this.role=role;
		    }*/
		    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		/* @Override
		    public String toString()
		    {
		        return "Customer [id=" + id + ", name=" + name + ", email=" + email +",password="+password+ ",enabled="+enabled+",role="+role+"]";
		    }*/
}
