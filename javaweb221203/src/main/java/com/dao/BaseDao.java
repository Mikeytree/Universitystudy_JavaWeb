package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	Connection dbconn;
	public BaseDao() {
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	
		try {
			String username = "root";
			String password = "root";
	    	String dburl = "jdbc:mysql://127.0.0.1:3306/webstore?useSSL=false&serverTimezone=UTC";
			
			dbconn = DriverManager.getConnection(dburl, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
