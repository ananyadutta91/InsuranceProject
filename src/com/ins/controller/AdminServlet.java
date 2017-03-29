package com.ins.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ins.DB.policyDB;
import com.ins.DB.userDB;
import com.ins.model.Policy;
import com.ins.model.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps =null;
		String action = request.getParameter("action");
		ResultSet rs=null;
		String url = null;
		if(action.equals("addOfficial"))
		{
			url = "/officialRegister.jsp";
		}
		else if(action.equals("registerOfficial"))
		{
			String fullName=request.getParameter("name");
			String email=request.getParameter("email");
			String pwd = request.getParameter("password");
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			String occupation = request.getParameter("occupation");
			String address = request.getParameter("address");
			String sql = "Insert into User (emailID, name, gender, age, occupation, address) values (?,?,?,?,?,?)";
			
			try {
				ps =  con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, fullName);
				ps.setString(3, gender);
				ps.setInt(4, age);
				ps.setString(5, occupation);
				ps.setString(6, address);
				int n = ps.executeUpdate();
				if(n>0)
				{
					//insert into login table
					sql = "Insert into Login (emailID,pwd,role) values (?,?,'official')"; 
					ps =   con.prepareStatement(sql);
					ps.setString(1, email);
					ps.setString(2, pwd);
					ps.executeUpdate();
					url ="/home.jsp";
				}
				else
				{
					System.out.println("Insert failed");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("viewCustomers"))
		{
			ArrayList<User> userList = userDB.getAllUsers(request,"customer");
			request.setAttribute("userList", userList);
			url="/viewCustomers.jsp";
		}
		else if(action.equals("viewOfficials"))
		{
			ArrayList<User> officialsList = userDB.getAllUsers(request,"official");
			request.setAttribute("officialsList", officialsList);
			url="/viewOfficials.jsp";
		}
		else if(action.equals("addPolicy"))
		{
			url = "/addPolicy.jsp";
		}
		else if(action.equals("addPolicyToDB"))
		{
			Policy p = new Policy(request.getParameter("type"),request.getParameter("desc"),Integer.parseInt(request.getParameter("cost")),Integer.parseInt(request.getParameter("maxCoverage")));
			int n = policyDB.addPolicy(request,p);
			url = "/addPolicy.jsp";
		}
		else if(action.equals("approvePolicy"))
		{
			ArrayList<Policy> approvalList = policyDB.getApprovalPolicies(request);
			request.setAttribute("approvalList", approvalList);
			url="/approvePolicy.jsp";
		}
		else if(action.equals("confirmPage"))
		{
			String email = request.getParameter("email");
			int policyID=Integer.parseInt(request.getParameter("id").trim());
			String status = request.getParameter("status");
			System.out.println("email -> "+email+"  PID -> "+policyID+"   status -> "+status);
			String sql = "Update cust_policy set status ='"+status+"' where emailID = '"+email+"' and pid="+policyID;
			
			try {
				ps =  con.prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			url="/home.jsp"; 
			
			
		}
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
		
}
	
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("get called "+request.getParameter("action"));
	        processRequest(request, response);
	    }

	   
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	         System.out.println("Post called for "+request.getParameter("action"));
	        processRequest(request, response);
	    }

}
