package com.ins.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Connect {

	public static Connection getConnect(HttpServletRequest request)  {
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://insurancedb.chinevyrsx1s.us-west-2.rds.amazonaws.com:3306/InsuranceDB","root","password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn !=null)
			System.out.println("DB Connected");
		else
			System.out.println("DB Connection failed");
	
		return conn;
		
	}
	
	
	

}
