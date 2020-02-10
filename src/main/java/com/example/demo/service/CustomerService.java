package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dto.UpdateBatchClass;
import com.example.demo.exception.ExceptionHandling;
import com.example.demo.model.Customer;
public class CustomerService {
	CustomerDao customerdao = new CustomerDao();
	
	public List<Customer> CustomerView() throws ExceptionHandling {
		
        List<Customer> list = null;     
        try
        {
            list = customerdao.viewCustomer();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }  
        return customerdao.viewCustomer();
	}
	
	public void insertCustomer(Customer c)throws ExceptionHandling {
		customerdao.insert(c);	
	}
	
	public String serviceDelete(int id) throws ExceptionHandling {
		return customerdao.daoDelete(id);
	}
	
	public String serviceUpdate(int id, String name)throws ExceptionHandling  {
		return customerdao.daoUpdate(id, name);
	}

	public String serviceUpdateBatch(UpdateBatchClass update_batch_obj)throws ExceptionHandling {

		return customerdao.daoUpdateBatch(update_batch_obj);
		
	}
	public String deleteBatch(int a[]) throws ExceptionHandling {
		return customerdao.daoDeleteBatch(a);
	
	}
}