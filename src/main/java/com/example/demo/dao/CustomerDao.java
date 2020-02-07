package com.example.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.example.demo.model.Customer;
import com.example.demo.util.CustomerUtil;

public class CustomerDao {
	Connection con = CustomerUtil.getConnection();
	 PreparedStatement pst = null;
    Customer details = new Customer();

     public List<Customer> viewCustomer() throws Exception{    
    	    Connection con =null;
    	    PreparedStatement pst = null;
    	    List<Customer> list = new ArrayList<Customer>();
    	    try {
    	        con = CustomerUtil.getConnection();
    	        String sql = "select * from customer";
    	        pst = con.prepareStatement(sql);
    	        ResultSet rs = pst.executeQuery();
    	        while(rs.next()) {
    	            
    	        	Customer details = new Customer();
    	        	details.setId(rs.getInt("id"));
    	            details.setName(rs.getString("name"));
    	            details.setAge(rs.getInt("age"));
    	            list.add(details);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        throw new Exception("cannot  View customer",e);
    	    }
    	    return list;
    	}
     public String insert(Customer c) {
    	 Connection con =null;
 	    PreparedStatement pst = null;
 	   try {
	        con = CustomerUtil.getConnection();
	        String sql = "insert into customer values(?,?,?)";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, c.getId());
	        pst.setString(2, c.getName());
	        pst.setInt(3, c.getAge());
	        int i = pst.executeUpdate();
	        if(i>0)
	        	System.out.println("Inserted Successfully");
	        else {
				System.out.println("Inserted Failed");
			}
 	   }
 	   catch (SQLException e) {
	        e.printStackTrace();	        
	    }
 	    return "inserted Successfull"; 
     }
     
     public String daoDelete(int id) {
    	 Connection con =null;
  	    PreparedStatement pst = null;
  	   try {
 	        con = CustomerUtil.getConnection();
 	        String sql = "delete from customer where id="+id;
 	        pst = con.prepareStatement(sql);
 	        int i = pst.executeUpdate();
 	        if(i>0)
 	        	System.out.println("Deleted Successfully");
 	        else {
 				System.out.println("Deleted Failed");
 			}
  	   }
  	   catch (SQLException e) {
 	        e.printStackTrace();	        
 	    }
  	    return "Deleted Successfull";  
     }
     public String daoUpdate(int id, String name) {
    	 Connection con =null;
   	    PreparedStatement pst = null;
   	   try {
  	        con = CustomerUtil.getConnection();
  	        String sql = "update customer set name=? where id="+id;
  	        pst = con.prepareStatement(sql);
  	        pst.setString(1, name);
  	        int i = pst.executeUpdate();
  	        if(i>0)
  	        	System.out.println("Updated Successfully");
  	        else {
  				System.out.println("Updated Failed");
  			}
   	   }
   	   catch (SQLException e) {
  	        e.printStackTrace();	        
  	    }
    	 return "updated SuccessfullY";
     }
}