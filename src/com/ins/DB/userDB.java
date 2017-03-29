package com.ins.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ins.controller.Connect;
import com.ins.model.*;

public class userDB {
	
	public static ArrayList<User> getAllUsers(HttpServletRequest request,String role)
	{
		Connection con = Connect.getConnect(request);
		Statement stmt;
		ResultSet rs =null;
		ArrayList<User> userList = null;
		try {
			stmt = con.createStatement();
			if(role.equals("customer"))
			{
			 rs = stmt.executeQuery("{call get_Users}");   //Calling Stored procedure to get customers
			}
			else
			{
				 rs = stmt.executeQuery("{call get_Officials}");   //Calling Stored procedure to get Officials
			}
			 userList=new ArrayList<User>();
			while(rs.next())
			{
				User u=new User(rs.getString("name"),rs.getString("emailID"),rs.getString("gender"),rs.getInt("age"),rs.getString("occupation"),rs.getString("address"));
				userList.add(u);
			}
	        
	           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return userList;
	}

}
