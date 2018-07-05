package com.frontend.code;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dexter.backend.model.Customer;
import com.dexter.backend.service.UserService;

@RestController

@RequestMapping("/customer")
public class CustomerController {
@Autowired
private UserService userService;

private Customer customer;

/*=======Add Customer======*/
@PostMapping("/add")
public ResponseEntity<Customer> add(@RequestBody Customer customer) {
 HttpHeaders headers = new HttpHeaders();
 if (customer == null) {
  return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
 }
userService.add(customer);
 headers.add("Employee Created  - ", String.valueOf(customer.getId()));
 return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
}

/*====List All Customers====*/

@GetMapping("/list")
public ResponseEntity<List<Customer>> getAllCustomer() {
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

/*====update Customer=====*/

@PutMapping("/update")
public ResponseEntity<?> update( @RequestBody Customer customer) {
    userService.update(customer);
    return ResponseEntity.ok().body("Customer has been updated successfully.");
}

/*========Delete Customer=======*/

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id) {
	try {
   userService.delete(id);
   return ResponseEntity.ok().body("customer has been deleted successfully.");
}catch(Exception e){
return ResponseEntity.ok().body("Please Insert Customer In This Id");
}
}
}


/*=======Add Customer======*/
/*@RequestMapping(value="/create", method=RequestMethod.POST, 
produces="application/json", consumes="application/json")
public void createCustomer(@RequestBody Customer customer)
{
userServiceImpl.createCustomer(customer);
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

/*======Retrive a Single Customer=====*/

/*
@RequestMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
method=RequestMethod.GET)
public Customer getStudentById(@PathVariable("id") int id)
{
Customer student = userServiceImpl.getById(id);
return student;
}*/

/*=======Update customer Details=======*/

/*@PutMapping("/update")
public ResponseEntity<Customer> update( @RequestBody Customer customer) {
	Customer currentUser = userService.getById(id);
     
    if (currentUser==null) {
        System.out.println("User with id " + id + " not found");
        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    currentUser.setName(customer.getName());
    currentUser.setEmail(customer.getEmail());
    currentUser.setPassword(customer.getPassword());
    currentUser.setRole(customer.getPassword());
    userService.update(currentUser);
    return new ResponseEntity<Customer>(currentUser, HttpStatus.OK);
}*/

