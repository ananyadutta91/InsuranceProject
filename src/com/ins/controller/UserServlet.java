package com.ins.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ins.DB.MessageDB;
import com.ins.DB.policyDB;
import com.ins.DB.userDB;
import com.ins.model.Message;
import com.ins.model.Policy;
import com.ins.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = Connect.getConnect(request);
		PreparedStatement ps =null;
		String action = request.getParameter("action");
		ResultSet rs=null;
		String url = null;
		HttpSession session = request.getSession(true);
		
		if(action.equals("validateLogin"))
		{
			String uname = request.getParameter("username");
			String pwd = request.getParameter("password");
			String role = request.getParameter("role");    //admin , customer, company-official
			System.out.println(role);
			String sql = "Select * from Login where emailID=? and pwd=? and role=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ps.setString(3, role);
				 rs = ps.executeQuery();
			
				 if(rs.next())
					{
					 System.out.println("Correct");
					 //Create session here
					 sql = "Select name from User where emailID =?";
					 ps=con.prepareStatement(sql);
					 ps.setString(1, "vwea");
				//	 rs = ps.executeQuery();
					// System.out.println("Size is "+ rs.getFetchSize() + rs.getString("name"));
					// session = request.getSession();
					 session.setAttribute("role", role);
					 //session.setAttribute("name",rs.getString("name"));
					 session.setAttribute("name",uname);
					 
					 System.out.println("Success");
						url ="/home.jsp";
					}
				 else
				 {
					 session.setAttribute("Error", "Please Enter Correct Credentials");
					 System.out.println("Wrong");
					    url ="/loginPage.jsp";
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception Caught");
				e.printStackTrace();
			}	
		}
		else if(action.equals("registerUser"))
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
					sql = "Insert into Login (emailID,pwd,role) values (?,?,'customer')"; 
					ps =   con.prepareStatement(sql);
					ps.setString(1, email);
					ps.setString(2, pwd);
					ps.executeUpdate();
					System.out.println("Success");
				}
				else
				{
					System.out.println("Insert failed");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "/loginPage.jsp";
		}
		else if(action.equals("aboutUs"))
		{
			url = "/aboutUs.jsp";
		}
		else if(action.equals("logout"))
		{
			session.invalidate();				
			//session.removeAttribute("role");
			//session.removeAttribute("name");
			url = "/loginPage.jsp";
		}
		else if(action.equals("discussionForum"))
		{
			
			ArrayList<Message> messagesList = MessageDB.getAllMessages(request);
			request.setAttribute("messagesList", messagesList);
			url="/discussionForum.jsp";
		}
		else if(action.equals("sendMessage"))
		{
			String message = request.getParameter("message");
			System.out.println("Before calling -> "+session.getAttribute("name"));
			Message m =new Message();
			m.setMessage(message);
			m.setEmail(session.getAttribute("name").toString());
			m.setDate(new Date().toLocaleString());
			m.setRole(session.getAttribute("role").toString());
			int n=MessageDB.addMessage(request, m);
			url="/discussionForum.jsp";
			
		}
		else if(action.equals("viewPolicies"))
		{
			String selectedType = request.getParameter("type");
			//request.setAttribute("selectedType", selectedType);
			ArrayList<Policy> policiesList = policyDB.getAllPolicies(request,selectedType);
			request.setAttribute("policiesList", policiesList);
			url="/viewPolicies.jsp";
		}
		else if(action.equals("bookPolicy"))
		{
			int code = Integer.parseInt(request.getParameter("code"));
			Policy p = policyDB.getPolicyDetails(request, code);
			session.setAttribute("selectedPolicy", p);
			url= "/"+p.getType()+".jsp";
		}
		else if(action.equals("registerLifePolicy"))
		{
			 con = Connect.getConnect(request);
			String Nname = request.getParameter("nname");
			String Nrelation= request.getParameter("nrelation");
			String Naddress= request.getParameter("naddress");
			String Nemail= request.getParameter("nemail");
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			String sql = "Insert into Nominee (name,relation,address,email) values (?,?,?,?)";
			try {
				 ps=con.prepareStatement(sql);
				 ps.setString(1, Nname);
				 ps.setString(2, Nrelation);
				 ps.setString(3, Naddress);
				 ps.setString(4, Nemail);
				ps.executeUpdate();
				
				sql = "select NID from Nominee order by NID desc limit 1";
				rs= ps.executeQuery(sql);
				int n=0;
				while(rs.next())
				{
					n = rs.getInt("NID");
				}
				
				if(n > 0)
				{
					
					n = policyDB.bookLifePolicy(request,session.getAttribute("name").toString(),(Policy) session.getAttribute("selectedPolicy"),n,amount);
					
					if(n>0)
					{
						sql = "Insert into cust_policy(emailID,pid,status) values (?,?,'pending')";
						ps=con.prepareStatement(sql);
						ps.setString(1,session.getAttribute("name").toString());
						ps.setInt(2, ((Policy) session.getAttribute("selectedPolicy")).getPid());
						ps.executeUpdate();
						
						
					}
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "/viewPolicies.jsp";
			
		}
		else if(action.equals("registerMotorPolicy"))
		{
			 con = Connect.getConnect(request);
			String vehicle = request.getParameter("vehicleNo");
			String engine= request.getParameter("engineNo");
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			
			try {
			int n = policyDB.bookMotorPolicy(request,session.getAttribute("name").toString(),(Policy) session.getAttribute("selectedPolicy"),vehicle,engine,amount);
				
					if(n>0)
					{
						String sql = "Insert into cust_policy(emailID,pid,status) values (?,?,'pending')";
						ps=con.prepareStatement(sql);
						ps.setString(1,session.getAttribute("name").toString());
						ps.setInt(2, ((Policy) session.getAttribute("selectedPolicy")).getPid());
						ps.executeUpdate();
					}
					
					else{
						//Throw Error Message Here
					}
				}catch (SQLException e) {
				System.out.println("Inside Catch");
				e.printStackTrace();
			}
			url = "/viewPolicies.jsp";
			
		}
		else if(action.equals("registerHealthPolicy"))
		{
			 con = Connect.getConnect(request);
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			
			try {
			int n = policyDB.bookHealthPolicy(request,session.getAttribute("name").toString(),(Policy) session.getAttribute("selectedPolicy"),amount);
				
					if(n>0)
					{
						String sql = "Insert into cust_policy(emailID,pid,status) values (?,?,'pending')";
						ps=con.prepareStatement(sql);
						ps.setString(1,session.getAttribute("name").toString());
						ps.setInt(2, ((Policy) session.getAttribute("selectedPolicy")).getPid());
						ps.executeUpdate();
					}
					
					else{
						//Throw Error Message Here
					}
				}catch (SQLException e) {
				
				e.printStackTrace();
			}
			url = "/viewPolicies.jsp";
			
		}
		else if(action.equals("registerHousePolicy"))
		{
			 con = Connect.getConnect(request);
			int amount = Integer.parseInt(request.getParameter("amount"));
			try {
			int n = policyDB.bookHousePolicy(request,session.getAttribute("name").toString(),(Policy) session.getAttribute("selectedPolicy"),request.getParameter("address").toString(),Integer.parseInt(request.getParameter("fsize")),Integer.parseInt(request.getParameter("bcost")),amount);
				
					if(n>0)
					{
						String sql = "Insert into cust_policy(emailID,pid,status) values (?,?,'pending')";
						ps=con.prepareStatement(sql);
						ps.setString(1,session.getAttribute("name").toString());
						ps.setInt(2, ((Policy) session.getAttribute("selectedPolicy")).getPid());
						ps.executeUpdate();
					}
					
					else{
						//Throw Error Message Here
					}
				}catch (SQLException e) {
				
				e.printStackTrace();
			}
			url = "/viewPolicies.jsp";
			
		}
		
		
		else if(action.equals("myPolicies"))
		{
			ArrayList<Policy> myPoliciesList = policyDB.getCustomerPolicies(request,session.getAttribute("name").toString());
			request.setAttribute("myPoliciesList", myPoliciesList);
			url="/myPolicies.jsp";
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
