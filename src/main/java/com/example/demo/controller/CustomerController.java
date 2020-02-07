package com.example.demo.controller;
import com.example.demo.service.CustomerService;
import com.example.demo.model.Customer;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController
{
	CustomerService cs=new CustomerService();
	@GetMapping("view")
	public List<Customer> view() throws Exception{
  
        return cs.CustomerView();
	}
	@PostMapping("insert")
	public void insert(@RequestBody Customer c) {
		cs.insertCustomer(c);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		 return cs.serviceDelete(id);
		}
	
	@RequestMapping(value = "/update/{id}/{name}", method = RequestMethod.GET)
	public String update(@PathVariable int id, @PathVariable String name) {
		System.out.println("Name is" +name);
		 return cs.serviceUpdate(id,name);
		}
	
}
