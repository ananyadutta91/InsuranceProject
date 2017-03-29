package com.ins.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ins.controller.Connect;
import com.ins.model.Message;


public class MessageDB {
	
	public static int addMessage(HttpServletRequest request,Message m)
	{
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		System.out.println("From Message -> "+m);
		
		
		String sql="Insert into Messages (fromEmail, date, message,role) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,m.getEmail());
			ps.setString(2, m.getDate());
			ps.setString(3, m.getMessage());
			ps.setString(4, m.getRole());
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}

	public static ArrayList<Message> getAllMessages(HttpServletRequest request) {
		
		Connection con = Connect.getConnect(request);
		Statement stmt;
		ResultSet rs =null;
		ArrayList<Message> messagesList = null;
		try {
			stmt = con.createStatement();
			
				 rs = stmt.executeQuery("{call get_AllMessages}");   //Calling Stored procedure to get Officials
			
			messagesList=new ArrayList<Message>();
			while(rs.next())
			{
				Message m =new Message(rs.getString("message"),rs.getString("fromEmail"),rs.getString("date"),rs.getString("role"));
				messagesList.add(m);
			}
	        
	           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messagesList;
	}

}
