<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/viewoff.css">
</head>
<body>
<%@include file="header.jsp" %>

<center><h1>Officials List</h1></center>


<table class="container">
	<thead>
		<tr>
			<th><h1>Email ID</h1></th>
            <th><h1>Name</h1></th>
			<th><h1>Gender</h1></th>
            <th><h1>Age</h1></th>
            <th><h1>Address</h1></th>
		</tr>
	</thead>
<tbody>
            
            <%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
         <cc:forEach var="user" items="${officialsList}">
		<tr>
						<td> <cc:out value='${user.emailID}'/></td> 
						<td> <cc:out value='${user.name}'/></td>
						<td> <cc:out value='${user.gender}'/></td>
                        <td> <cc:out value='${user.age}'/></td>
                        <td> <cc:out value='${user.address}'/></td>
                        
		</tr>
         </cc:forEach>
		
	</tbody>
</table>

<%@include file="footer.jsp" %>