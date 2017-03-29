<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="../styles/login.css">
</head>
<body>
<center>
<div class="login">
	
<h2>Register Form</h2>
<form  action="user" method="post">
<input type="hidden" name="action" value="registerUser">
<input type="hidden" >
<div class="login-container">
  

  <div class="container">

  	<label><b>Fullname</b></label>
    <input type="text" placeholder="Enter Fullname" name="name" required/>

   <br><br> <label><b>Gender</b></label>
    <input type="text" placeholder="Enter Gender" name="gender" required/>

    <br><br><label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required/>

    <br><br><label><b>Email Address</b></label>
    <input type="text" placeholder="Enter Password" name="email" required/>
   
   	<br><br><label><b>Age</b></label>
    <input type="text" placeholder="Enter Age" name="age" required/>

    <br><br><label><b>Occupation</b></label>
    <input type="text" placeholder="Enter Occupation" name="occupation" required/>

    <br><br><label><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="address" required/>

    <br><br><br><button type="submit">Login</button>
    <button type="button" class="cancelbtn">Cancel</button>
    
   
  </div>
</div>
</form>
</div>
</center>
<%@include file="footer.jsp" %>