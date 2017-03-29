<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>

 
    
 div#green{background-color: green};
 
 div#red{background-color: red};   



</style>

</head>
<body>
<%@include file="header.jsp" %>
<center>

 <div style="height:400px; overflow:auto" id="scrollable">
 
 <%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
         <cc:forEach var="m" items="${messagesList}">
		<tr>
		
<c:choose>
  <c:when test="${m.role == 'customer'}">
    <div style= "background-color: grey"; >
  </c:when>
  <c:otherwise>
    <div style= "background-color: powderblue"; >
  </c:otherwise>
</c:choose>
		
						<td> <cc:out value='${m.message}'/></td><br> 
						<td> <cc:out value='${m.email}'/></td>
						<td> <cc:out value='${m.date}'/></td>
						
						<br><br>
						<hr>
						</div>
		</tr>
         </cc:forEach>
 </div>



<form action="user" method="post">
<input type="hidden" name="action" value="sendMessage" />
<!-- <h1>Message : </h1> <textarea name="message"  required></textarea>   -->

<h1>Message : </h1><input type="text" name="message" style="width:750px;height:50px" required/>

<input type="submit"  value="Send Message"/>
</form>


</center>


<%@include file="footer.jsp" %>