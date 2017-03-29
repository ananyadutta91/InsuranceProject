<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@include file="header.jsp" %>


<center>

<h1><b>${selectedPolicy.type} Insurance </b> </h1>
<h2>${selectedPolicy.description }</h2>
<h2>Annual Cost : $${selectedPolicy.cost }</h2>
<h2>Maximum Coverage : $${selectedPolicy.max_coverage }</h2>

<form action="user" method="post">
<input type="hidden" name="action" value="registerLifePolicy">

Amount Paid : $ <input type="number" name="amount" min="10" required><br>

<br><br><h1><b>Nominee Details</b></h1><br>

Nominee Name : <input type="text" name="nname" required><br>
Relation: : <input type="text" name="nrelation" required><br>
Address : <input type="text" name="naddress" required><br>
Email : <input type="text" name="nemail" required><br>


<input type="submit" value="Register">




</form>








</center>



<%@include file="footer.jsp" %>
