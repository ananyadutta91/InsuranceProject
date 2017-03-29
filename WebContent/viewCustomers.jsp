<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<%@include file="header.jsp" %>

<center><h1>Customers List</h1></center>


<table border ="1"class="container">
	<thead>
		<tr>
			<td>Email ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Age</td>
			<td>Occupation</td>
			<td>Address</td>
		</tr>
	</thead>
<tbody>
            
            <%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
         <cc:forEach var="user" items="${userList}">
		<tr>
						<td> <cc:out value='${user.emailID}'/></td> 
						<td> <cc:out value='${user.name}'/></td>
						<td> <cc:out value='${user.gender}'/></td>
                        <td> <cc:out value='${user.age}'/></td>
                        <td> <cc:out value='${user.occupation}'/></td>
                        <td> <cc:out value='${user.address}'/></td>
                        
		</tr>
         </cc:forEach>
		
	</tbody>
</table>

<%@include file="footer.jsp" %>