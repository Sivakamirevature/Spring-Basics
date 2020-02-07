package com.example.demo.service;
import java.util.List;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
public class CustomerService {
	CustomerDao customerdao = new CustomerDao();
	Customer details = new Customer();
	
	
	public List<Customer> CustomerView() throws Exception {
		System.out.println("hi");
        List<Customer> list = null;     
        try
        {
            list = customerdao.viewCustomer();
             StringBuilder cust=new StringBuilder();
 	      cust.append("\n Id\tName\t\n");
 	       for (Customer customer : list) 
 	       {
 	    	  cust.append(customer.getId()).append("\t");
 	    	  cust.append(customer.getName()).append("\t");
 	          cust.append("\n");
 	       }
 	       System.out.println(cust);       
        } 
        catch (Exception e) {
            e.printStackTrace();
        }  
        return customerdao.viewCustomer();
	}
	
	public void insertCustomer(Customer c) {
		customerdao.insert(c);	
	}
	
	public String serviceDelete(int id) {
		return customerdao.daoDelete(id);
	}
	
	public String serviceUpdate(int id, String name) {
		return customerdao.daoUpdate(id, name);
	}
}