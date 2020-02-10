package com.example.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.DeleteBatches;
import com.example.demo.dto.UpdateBatchClass;
import com.example.demo.exception.ExceptionHandling;
import com.example.demo.model.Customer;
import com.example.demo.util.CustomerUtil;
import com.example.demo.util.MessageConstants;



public class CustomerDao {
	Connection con = CustomerUtil.getConnection();
	 PreparedStatement pst = null;
	 
	 private static final Logger LOGGER=LoggerFactory.getLogger(CustomerDao.class);
    
    @Autowired
    MessageConstants MessageConstantsobj;
   
     public List<Customer> viewCustomer() throws ExceptionHandling{    
    	    Connection con =null;
    	    PreparedStatement pst = null;
    	    List<Customer> list = new ArrayList<Customer>();
    	    try {
    	        con = CustomerUtil.getConnection();
    	        String sql = "select *  from customer";
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
    	    	throw new ExceptionHandling(MessageConstantsobj.SHOW_CANT_PERFORMED ,e);
    	    }
    	    return list;
    	}
     public String insert(Customer c)throws ExceptionHandling {
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
	        	LOGGER.info("Inserted Successfully");
	        else {
	        	LOGGER.info("Inserted Failed");
			}
 	   }
 	   catch (SQLException e) {
	        e.printStackTrace();
	        throw new ExceptionHandling(MessageConstantsobj.INSERTED_CANT_PERFORMED ,e);
	    }
 	    return "inserted Successfull"; 
     }
     
     
     public String daoDelete(int id) throws ExceptionHandling{
    	 Connection con =null;
  	    PreparedStatement pst = null;
  	   try {
 	        con = CustomerUtil.getConnection();
 	        String sql = "delete from table customer where id="+id;
 	        pst = con.prepareStatement(sql);
 	        int i = pst.executeUpdate();
 	        if(i>0)
 	        	LOGGER.info("Deleted Successfully");
 	        else {
 	        	LOGGER.info("Deleted Failed");
 			}
  	   }
  	   catch (SQLException e) {
  		 e.printStackTrace();
 	       throw  new ExceptionHandling(MessageConstantsobj.DELETED_CANT_PERFORMED ,e);	        
 	    }
  	    return "Deleted Successfull";  
     }
     public String daoUpdate(int id, String name) throws ExceptionHandling{
    	 Connection con =null;
   	    PreparedStatement pst = null;
   	   try {
  	        con = CustomerUtil.getConnection();
  	        String sql = "update customer set name="+name+" where id="+id;
  	        pst = con.prepareStatement(sql);
  	        int i = pst.executeUpdate();
  	        if(i>0)
  	        	LOGGER.info("Updated Successfully");
  	        else {
  	        	LOGGER.info("Updated Failed");
  			}
   	   }
   	   catch (SQLException e) {
   		throw  new ExceptionHandling(MessageConstantsobj.DELETED_CANT_PERFORMED ,e);   
  	    }
    	 return "updated SuccessfullY";
     }
     
     public String daoUpdateBatch(UpdateBatchClass updatebatchobj)throws ExceptionHandling{
    	 Connection con =null;
    	 PreparedStatement pst = null;
    	   try {
   	        con = CustomerUtil.getConnection();
   	        String sql = "update customer set name=?, age=? where id=?";
   	        pst = con.prepareStatement(sql);
   	        pst.setString(1, updatebatchobj.getName());
   	        pst.setInt(2, updatebatchobj.getAge());
   	        pst.setInt(3, updatebatchobj.getId());
   	        int i = pst.executeUpdate();
   	        if(i>0)
   	        	LOGGER.info("Updated Successfully");
   	        else {
   	        	LOGGER.info("Updated Failed");
   			}
    	   }
    	   catch (SQLException e) {
    		throw  new ExceptionHandling(MessageConstantsobj.DELETED_CANT_PERFORMED ,e);   
   	    }
    	 return "updated Successfull";
     }
	public String daoDeleteBatch(DeleteBatches deletebatches)throws ExceptionHandling {
		deletebatches.delarray;
		String deleteIdString = "";
		Connection con =null;
		PreparedStatement pst = null;
		deleteIdString += a[0];
	 		
   	 	for(i=1;i<delarray.length;i++) {
   	 		
   	 		deleteIdString += ",";
   	 	deleteIdString += delarray[i];
   	 	}
	
			 try {
		   	        con = CustomerUtil.getConnection();
		   	        String sql = "DELETE FROM customer WHERE id IN("+deleteIdString+")";
		   	        pst = con.prepareStatement(sql);
		   	        int k = pst.executeUpdate();	
			 	}
			 catch(SQLException e){
				 throw  new ExceptionHandling(MessageConstantsobj.DELETED_CANT_PERFORMED ,e); 
			 	}
		
		return "Batch Deleted Successfull";
	}
}