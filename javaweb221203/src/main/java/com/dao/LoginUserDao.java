package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.LoginUser;

public class LoginUserDao extends BaseDao {
	
//	���ӣ��������ݣ�
	public boolean addUser(LoginUser user2) {
             	  
 	   String sql = "INSERT INTO loginuser(username,password,sex,age) VALUES(?,?,?,?)";
 	   
 	   try {
 		 PreparedStatement pstmt=dbconn.prepareStatement(sql);
 	     pstmt.setString(1,user2.getUsername());
 	     pstmt.setString(2,user2.getPassword());
 	     pstmt.setString(3,user2.getSex());
 	     pstmt.setInt(4,user2.getAge());
 	     pstmt.executeUpdate();
 	     return true;
 	   }catch(SQLException se){
 		System.out.println(se);
 		  return false;
 	   }
	}
//	�޸��û���Ϣ
	public boolean updateuser(String username,String password){
		String sql = "updet loginuser set password=? where username=?";
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			if(ishave(username)) {
				pstmt.setString(1, password);
				pstmt.setString(2, username);
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
//	ɾ����¼
	public boolean deleteUser(String username){
		String sql = "delete from loginuser where username=?";
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			if(ishave(username)) {
				pstmt.setString(1,username);
				pstmt .executeUpdate( );
				return true;
			}
			else
				return false;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
//	���û�������
	public LoginUser findByName(String username) {
		String sql ="SELECT * FROM loginuser WHERE username=?";
		LoginUser user2 = new LoginUser();
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rst = pstmt .executeQuery();
			while(rst.next()) {
			user2.setUsername(rst .getString("username"));
			user2.setPassword(rst.getString("password"));
			user2.setSex(rst.getString("sex"));
			user2.setAge(rst.getInt("age"));
			}
			} catch (SQLException se) {
			se.printStackTrace();
		}
			return user2;
	}
//	���û��������ͻ���¼
	public boolean ishave(String username) {
		String sql = "SELECT * FROM loginuser WHERE username=?";
		try {
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rst = pstmt .executeQuery();
			if(rst.next()){
				return true;
			}
			else
				return false;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
}
//	��ѯ�����û���Ϣ
	public ArrayList<LoginUser> findAllUser(){  	  
		ArrayList<LoginUser> userList = new ArrayList<LoginUser>();
	   	  String sql = "SELECT * FROM customers";
	   	  try( 
	   		 PreparedStatement pstmt = dbconn.prepareStatement(sql);
	   		 ResultSet rst = pstmt.executeQuery()){  		 
	   	      while(rst.next()){
	   	    	LoginUser user2 = new LoginUser(); 
	   	        user2.setUsername(rst.getString("username"));
	   	        user2.setPassword(rst.getString("password"));
	   	        user2.setSex(rst.getString("sex"));
	   	     	user2.setAge(rst.getInt("age"));	
	   	     	userList.add(user2);	
	   	    }	     
	   	     
	   	  }catch(SQLException e){
	   	      e.printStackTrace();
	   		 return null;
	   	  }
	   	  return userList;
	   }
} 


