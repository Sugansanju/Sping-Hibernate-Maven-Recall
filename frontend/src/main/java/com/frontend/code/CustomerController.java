package com.frontend.code;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dexter.backend.model.Customer;
import com.dexter.backend.service.UserService;
import com.dexter.backend.service.UserServiceImpl;

@RestController

@RequestMapping("/customer")
public class CustomerController {
@Autowired
private UserService userService;

private UserServiceImpl userServiceImpl;

private Customer customer;

/*=======Add Customer======*/
/*@RequestMapping(value="/add", method=RequestMethod.POST, 
produces="application/json", consumes="application/json")
public void addCustomer(@RequestBody Customer customer)
{
userServiceImpl.addCustomer(customer);
}*/
/*@RequestMapping(value="/add",method=RequestMethod.POST,consumes ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
public @ResponseBody Customer addProduct(@RequestBody Customer st){
 System.out.println("pr"+st.getName());
return st;
}*/
/*====List All Customers====*/

/*@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,
method=RequestMethod.GET)
public List getAllCustomers()
{
List customerList = userServiceImpl.getAllCustomer();
return customerList;
}*/
@GetMapping("/list")
public ResponseEntity<List<Customer>> getAllCustomers() {
	List<Customer> customers = userService.getAllCustomer();
	if (customers == null) {
		return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
}


/*====Retrive a Single Customer====*/

@GetMapping("/{id}")
public ResponseEntity<Customer> getUser(@PathVariable("id") int id) {
	customer = userService.getById(id);
	if (customer == null) {
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
}

/*
@RequestMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
method=RequestMethod.GET)
public Customer getStudentById(@PathVariable("id") int id)
{
Customer student = userServiceImpl.getById(id);
return student;
}*/

/*====update Customer=====*/
@PutMapping(value="/update", headers="Accept=application/json")
public ResponseEntity<Customer> updateCustomer(@RequestBody Customer currentCustomer)
{
    Customer user = userService.findById(currentCustomer.getId());
    if (user==null) {
        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    user.setId(currentCustomer.getId());
    user.setName(currentCustomer.getName());
    user.setEmail(currentCustomer.getEmail());
    user.setRole(currentCustomer.getRole());
    userService.updateCustomer(user);
    return new ResponseEntity<Customer>(HttpStatus.OK);
}


/*========Delete Customer=======*/


}
