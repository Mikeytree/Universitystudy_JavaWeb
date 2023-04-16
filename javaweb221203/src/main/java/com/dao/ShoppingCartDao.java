package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.LoginUser;
import com.model.ShoppingCart;

public class ShoppingCartDao extends BaseDao{
	public boolean addUser(ShoppingCart user2){  	  
	   	   String sql = "INSERT INTO shoppingcart" +
	   	   		"(username,id,pname,price,quantity)"+"VALUES(?,?,?,?,?)";	   
	   	   try{
	   		PreparedStatement pstmt=dbconn.prepareStatement(sql);

	   	     pstmt.setString(1,user2.getUsername());
	   	     pstmt.setInt(2,user2.getId());
	   	     pstmt.setString(3,user2.getPname());
	   	     pstmt.setFloat(4,user2.getPrice());
	   	     pstmt.setInt(5,user2.getQuantity());
	   	     
	   	     pstmt.executeUpdate();
	   	     return true;
	   	   }catch(SQLException se){
	   	  	  se.printStackTrace();
	   		  return false;
	   	   }
	   } 
	
	public boolean updateUser(String username,int id,int quantity){
		String sql="update shoppingcart set quantity=? where username=? and id=?";
		   try{
	   			PreparedStatement pstmt=dbconn.prepareStatement(sql);
	  
	   			
	   		if(ishave(id)){
	   			pstmt.setInt(1, quantity);
	   			pstmt.setString(2,username);
	   			pstmt.setInt(3,id);
	   			
		   	     
		   	     pstmt.executeUpdate();
		   	     return true;
	   		}
	   		else 
	   			return false;
	   	     
	   	   }catch(SQLException se){
	   	  	  se.printStackTrace();
	   		  return false;
	   	   }
	}

	
	public boolean deleteUser(String username,int id){  	  
	   	   String sql = "delete from shoppingcart where username=? and id=?";	


	   	   try{
	   		PreparedStatement pstmt=dbconn.prepareStatement(sql);
	   			 
	   		if(ishave(username,id)){
	   			pstmt.setString(1,username);
	   			pstmt.setInt(2,id);
		   	     
		   	     pstmt.executeUpdate();
		   	     return true;
	   		}
	   		else 
	   			return false;
	   	     
	   	   }catch(SQLException se){
	   	  	  se.printStackTrace();
	   		  return false;
	   	   }
	   } 
	public ArrayList<ShoppingCart> findByName(String username){ 
		ArrayList<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
	   	  String sql = "SELECT * FROM shoppingcart where username=?";
	   	  try{ 	
	   			PreparedStatement pstmt=dbconn.prepareStatement(sql);
	   			pstmt.setString(1,username);
	   			ResultSet rst = pstmt.executeQuery(); 
	   		  		 
	   	      while(rst.next()){
	   	    	ShoppingCart  cart1 = new ShoppingCart();
	   	    	cart1.setUsername(rst.getString("username"));
	   	    	cart1.setPname(rst.getString("pname"));
	   	    	cart1.setId(rst.getInt("id"));
	   	    	cart1.setPrice(rst.getFloat("price"));
	   	    	cart1.setQuantity(rst.getInt("quantity"));
	   	        cartList.add(cart1);	
	   	     
	   	    }	     
	   	   
	   	  }catch(SQLException e){
	   	      e.printStackTrace();
	   		 //return null;
	   	  }
	   	return cartList;
	   }
 
	   
	  
	   public ShoppingCart findByName(String username,int id){ 
		      String sql = "SELECT * FROM shoppingcart WHERE username=? and id=?";
		      ShoppingCart  user2 = new ShoppingCart();
		     // user2.setId(0);
		   
	      try{
	    		  PreparedStatement pstmt=dbconn.prepareStatement(sql);
	    		  pstmt.setString(1,username);
	    		  pstmt.setInt(2,id);
		        	ResultSet rst = pstmt.executeQuery(); 
	   	  
	   	     while(rst.next()){
	   	    	user2.setUsername(rst.getString("username"));
	   	    	user2.setId(rst.getInt("id"));
	   	    	user2.setPname(rst.getString("pname"));
	   	    	user2.setPrice(rst.getFloat("price"));
	   	    	user2.setQuantity(rst.getInt("quantity"));
	   	    	
	   	     }
	   	    
	      }catch(SQLException se){
	   	  	
	   	  }
	   	  return user2;
	   }
	   public boolean ishave(int id){ 
		      String sql = "SELECT *" +
		  		             " FROM shoppingcart WHERE id=?";
	     //User  user = new User();
	      try{
	    		  PreparedStatement pstmt=dbconn.prepareStatement(sql);
	    		  pstmt.setInt(1,id);
		        	ResultSet rst = pstmt.executeQuery(); 
	   	   
	   	     if(rst.next()){
	   	    	return true;
	   	     }
	   	     else
	   	    	 return false;
	   	    
	      }catch(SQLException se){
	   	  	
	   	  }
	   	  return false;
	   }
	   public boolean ishave(String username){ 
		      String sql = "SELECT *" +
		  		             " FROM shoppingcart WHERE username=?";

	      try{
	    		  PreparedStatement pstmt=dbconn.prepareStatement(sql);
	    		  pstmt.setString(1,username);
		        	ResultSet rst = pstmt.executeQuery(); 
	   	   
	   	     if(rst.next()){
	   	    	return true;
	   	     }
	   	     else
	   	    	 return false;
	   	    
	      }catch(SQLException se){
	   	  	
	   	  }
	   	  return false;
	   }
	   
	   public boolean ishave(String username,int id){ 
		      String sql = "SELECT *" +
		  		             " FROM shoppingcart WHERE username=? and id=?";

	      try{
	    		  PreparedStatement pstmt=dbconn.prepareStatement(sql);
	    		  pstmt.setString(1,username);
	    		  pstmt.setInt(2,id);
		        	ResultSet rst = pstmt.executeQuery(); 
	   	   
	   	     if(rst.next()){
	   	    	return true;
	   	     }
	   	     else
	   	    	 return false;
	   	    
	      }catch(SQLException se){
	   	  	
	   	  }
	   	  return false;
	   }
	
	   
	   public ArrayList<ShoppingCart> findAllUser(){  	
		   	  
		   	  ArrayList<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		   	  String sql = "SELECT * FROM shoppingcart";
		   	  try{ 	
		   			PreparedStatement pstmt=dbconn.prepareStatement(sql);
		        	ResultSet rst = pstmt.executeQuery(); 
		   		  		 
		   	      while(rst.next()){
		   	    	ShoppingCart  cart1 = new ShoppingCart();
		   	    	cart1.setUsername(rst.getString("username"));
		   	    	cart1.setPname(rst.getString("pname"));
		   	    	cart1.setId(rst.getInt("id"));
		   	    	cart1.setPrice(rst.getFloat("price"));
		   	    	cart1.setQuantity(rst.getInt("quantity"));
		   	        cartList.add(cart1);	
		   	     
		   	    }	     
		   	   
		   	  }catch(SQLException e){
		   	      e.printStackTrace();
		   		 //return null;
		   	  }
		   	return cartList;
		   }
}
