<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
<div class="login">
<center>
<h2>Login Form</h2>

<form  action="user" method="post">
<input type="hidden" name="action" value="validateLogin">
<div class="login-container">
  <div class="container">
   <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" /> <br/>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" /> <br/>
    <div class="radio">

            <input type="radio" name="role" value="admin"/>Admin
            <input type="radio" name="role" value="official"/>Company Offical
            <input type="radio" name="role" value="customer"/>Customer
        
    </div>
    <button type="submit">Login</button> <br/>
    <button><a class="signup" href="/registerPage.jsp">Register</a></button><br/>
    <button type="submit" class="cancelbtn">Cancel</button>
    
   
  </div>
</div>
</form>
</center>
</div>
<%@include file="footer.jsp" %>
