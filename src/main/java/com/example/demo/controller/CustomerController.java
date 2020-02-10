package com.example.demo.controller;
import com.example.demo.service.CustomerService;
import com.example.demo.dto.DeleteBatches;
import com.example.demo.dto.UpdateBatchClass;
import com.example.demo.exception.ExceptionHandling;
import com.example.demo.model.Customer;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController
{
	CustomerService serviceObject=new CustomerService();
	@GetMapping("view")
	public List<Customer> view() throws ExceptionHandling{
        return serviceObject.CustomerView();
	}
	@PostMapping("insert")
	public void insert(@RequestBody Customer c)throws ExceptionHandling {
		serviceObject.insertCustomer(c);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) throws ExceptionHandling {
		 return serviceObject.serviceDelete(id);
	}
	
	@PutMapping(value = "/update/{id}/{name}")
	public String update(@PathVariable int id, @PathVariable String name) throws ExceptionHandling {
		System.out.println("Name is" +name);
		return serviceObject.serviceUpdate(id,name);
		}
	@PostMapping(value="/UpdateBatch")
	public String UpdateBatch(@RequestBody UpdateBatchClass c) throws ExceptionHandling {
		return serviceObject.serviceUpdateBatch(c);
	}
	@DeleteMapping(value="/deleteBatch")
	public String deleteBatch(@RequestBody DeleteBatches deletebatches) throws ExceptionHandling {
		
		return serviceObject.deleteBatch(deletebatches);
	}
}
