package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Products;

public class ProductDao extends BaseDao {
//		增加数据（插入数据）
	public boolean addProducts(Products prod) {
		  String sql="INSERT INTO products"+"(id,pname,brand,price,stock)VALUES(?,?,?,?,?)";
		  
		  
		 try {
		  PreparedStatement pstmt=dbconn.prepareStatement(sql);
		   pstmt.setInt(1, prod.getId());
		   pstmt.setString(2, prod.getPname());
		   pstmt.setString(3, prod.getBrand());
		   pstmt.setFloat(4, prod.getPrice());
		   pstmt.setInt(5, prod.getStock());
		   pstmt.executeUpdate();
		   return true;
		 } catch (SQLException se) {
		   se.printStackTrace();
		   return false;
		  }
		 }
	public boolean updateUser(int id,int stock) {
		String sql = "update products set stock=? where id=?";
		 
		try {
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			if(ishave(id)) {
				pstmt.setInt(1, stock);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				return true;
			}
			else 
			
				return false;
			
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
//	删除记录
	public Boolean deleteUser(int id) {
		String sql = "delete from products where id=?";
		String sql1 = "delete from shoppingcart where id=?";
		
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
//			PreparedStatement pstmt1=dbconn.prepareStatement(sql1);
			if(ishave(id)) {
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
//				pstmt1.setInt(1,id);
//				pstmt1.executeUpdate();
				return true;
			}else
			{
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
//按商品编号查询
	public Products findById(int id){
		String sql = "SELECT * FROM products WHERE id=?";
		Products prod = new Products();
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				prod.setId(rst.getInt("id"));
				prod.setPname(rst.getString("pname"));
				prod.setBrand(rst.getString("brand"));
				prod.setPrice(rst.getFloat("price"));
				prod.setStock(rst.getInt("stock"));
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return prod;
	}
	public boolean ishave(int id) {
		String sql = "SELECT *" +" FROM products WHERE id=?";
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rst = pstmt .executeQuery();
			if(rst.next()) {
				return true;
			}
			else
				return false;
		} catch (SQLException se) {
			
		}
		return false;
	}
	//查询所有商品信息
	 public ArrayList<Products> findAllUser(){
	  ArrayList<Products> prodList=new ArrayList<Products>();
	  String sql="SELECT * FROM products";
	  try {
	   PreparedStatement pstmt=dbconn.prepareStatement(sql);
	   ResultSet rst=pstmt.executeQuery();
	  while(rst.next()) { 
	      Products prod=new Products();
	   prod.setId(rst.getInt("id"));
	   prod.setPname(rst.getString("pname"));
	   prod.setBrand(rst.getString("brand"));
	   prod.setPrice(rst.getFloat("price"));
	   prod.setStock(rst.getInt("stock"));
	   prodList.add(prod);
	   
	  }
	    
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return prodList;
	 }
	
}
	
