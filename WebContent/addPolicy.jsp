<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<%@include file="header.jsp" %>

<center><h1>Add Policy Form</h1>

<form action="admin" method="post">
<input type="hidden" name="action" value="addPolicyToDB" />
Description : <textarea type="text" name="desc"  rows="10" cols="150" required></textarea><br><br>
Cost : <input type="number" min="1"  name="cost" required/><br><br>
Maximum Coverage : <input type="number" min="1"  name="maxCoverage" required/><br><br>

<input type="radio" name="type" value="motor" checked> Motor Insurance
  <input type="radio" name="type" value="house"> House Insurance
  <input type="radio" name="type" value="life"> Life Insurance
  <input type="radio" name="type" value="health"> Health Insurance<br><br>
<input type="submit" value="Add">
</form>

 
 </center>
 <%@include file="footer.jsp" %>