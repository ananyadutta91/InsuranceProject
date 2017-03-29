package com.ins.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ins.controller.Connect;
import com.ins.model.*;

public class policyDB {
	
	public static int addPolicy(HttpServletRequest request,Policy p)
	{
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		
		String sql="Insert into Policy (type, description, cost, max_coverage) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getType());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getCost());
			ps.setFloat(4, p.getMax_coverage());
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}
	
	
	
	public static ArrayList<Policy> getAllPolicies(HttpServletRequest request,String policyType)
	{
		System.out.println("Inside Function ->"+policyType);
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		ResultSet rs =null;
		ArrayList<Policy> policiesList = null;
		try {
			ps = con.prepareStatement("{call get_AllPolicies(?)}");
			ps.setString(1, policyType);
			
				 rs  = ps.executeQuery();   //Calling Stored procedure to get selected type Policies
			
				 policiesList=new ArrayList<Policy>();
			while(rs.next())
			{
				Policy p=new Policy(rs.getString("type"),rs.getString("description"),rs.getInt("cost"),rs.getInt("max_coverage"),rs.getInt("pid"));
				policiesList.add(p);
			}
	        
	           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return policiesList;
	}
	
	
	public static Policy getPolicyDetails(HttpServletRequest request,int pid)
	{
		Connection con = Connect.getConnect(request);
		Statement stmt;
		ResultSet rs =null;
		Policy p=null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Policy where pid ="+pid);
			while(rs.next())
			{
				p =new Policy(rs.getString("type"),rs.getString("description"),rs.getInt("cost"),rs.getInt("max_coverage"),rs.getInt("pid"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return p;
	}





	public static int bookLifePolicy(HttpServletRequest request, String email,Policy p, int Nid,int amount) //for life insurance
	{
		
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		
		String sql="Insert into Life_Insurance (pid, emailID, registrationDate, NID,amount_paid) values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2,email);
			ps.setString(3, new Date().toLocaleString());
			ps.setInt(4, Nid);
			ps.setInt(5, amount);
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	
	
	public static int bookMotorPolicy(HttpServletRequest request, String email,Policy p, String vehicleNo, String engineNo, int amount) //for life insurance
	{
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		
		String sql="Insert into Motor_Insurance (pid, emailID, registrationDate, vehicleno ,motorno,amount_paid) values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2,email);
			ps.setString(3, new Date().toLocaleString());
			ps.setString(4,vehicleNo );
			ps.setString(5, engineNo);
			ps.setInt(6, amount);
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	

	public static int bookHealthPolicy(HttpServletRequest request, String email, Policy p, int amount) {
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		
		String sql="Insert into Health_Insurance (pid, uid, regDate,amountPaid) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2,email);
			ps.setString(3, new Date().toLocaleString());
			ps.setInt(4, amount);
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	
	
	public static int bookHousePolicy(HttpServletRequest request, String email, Policy p, String address,
			int fsize, int bcost, int amount) {
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		int n=0;
		
		String sql="Insert into House_Insurance (pid, emailID,address,family_size,buildingCost, regDate,amountPaid) values (?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2,email);
			ps.setString(3,address);
			ps.setInt(4, fsize);
			ps.setInt(5,bcost );
			ps.setString(6, new Date().toLocaleString());
			ps.setInt(7, amount);
			 n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	
	

	public static ArrayList<Policy> getCustomerPolicies(HttpServletRequest request, String email) {
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		ResultSet rs =null;
		ArrayList<Policy> userpoliciesList = null;
		try {
			ps = con.prepareStatement("{call get_UserPolicies(?)}");   //Calling Stored procedure to get Policies of user
			ps.setString(1, email);
			rs = ps.executeQuery();
			userpoliciesList=new ArrayList<Policy>();
			while(rs.next())
			{
				Policy p=new Policy(rs.getString("type"),rs.getString("description"),rs.getInt("cost"),rs.getInt("max_coverage"));
				p.setStatus(rs.getString("status"));
				userpoliciesList.add(p);
			}
	        
	           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return userpoliciesList;
	}





	public static ArrayList<Policy> getApprovalPolicies(HttpServletRequest request) {
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps;
		ResultSet rs =null;
		ArrayList<Policy> approvalPoliciesList = null;
		
		try {
			ps = con.prepareStatement("{call get_ApprovalPolicies()}");   //Calling Stored procedure to get Policies of user
			rs = ps.executeQuery();
			approvalPoliciesList=new ArrayList<Policy>();
			while(rs.next())
			{
				Policy p=new Policy(rs.getString("type"),rs.getString("description"),rs.getInt("cost"),rs.getInt("max_coverage"));
				p.setStatus(rs.getString("status"));
				p.setEmail(rs.getString("emailID"));
				p.setPid(rs.getInt("pid"));
				approvalPoliciesList.add(p);
			}
	        
	           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return approvalPoliciesList;
	}



	



	
	

}
