<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<%@include file="header.jsp" %>
<center>

<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
<th>
<tr>
<td>Type</td>
<td>Description</td>
<td>Cost</td>
<td>Max Coverage</td>
<td>Status</td>
</tr>
</th>
<cc:forEach var="p" items="${myPoliciesList}">
<tr>
<td>${p.type}</td>
<td>${p.description}</td>
<td>${p.cost}</td>
<td>${p.max_coverage}</td>
<td>${p.status}</td>
 
</tr>
</cc:forEach>   
</table>
</center>
<%@include file="footer.jsp" %>