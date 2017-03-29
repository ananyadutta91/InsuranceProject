<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<%@include file="header.jsp" %>




<center><h1>Approval List</h1></center>


<table border ="2" class="container">
	<thead>
		<tr>
			<th><h1>Email ID</h1></th>
            <th><h1>Type</h1></th>
			<th><h1>Description</h1></th>
            <th><h1>Cost</h1></th>
			<th><h1>Max-Coverage</h1></th>
            <th><h1>Status</h1></th>
		</tr>
	</thead>
<tbody>
            
            <%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
         <cc:forEach var="p" items="${approvalList}">
		<tr>
						<td> <cc:out value='${p.email}'/></td>   
						<td> <cc:out value='${p.type}'/></td>
						<td> <cc:out value='${p.description}'/></td>
                        <td> <cc:out value='${p.cost}'/></td>
                        <td> <cc:out value='${p.max_coverage}'/></td>
                        <td> <cc:out value='${p.status}'/></td>
                        <td>  <form action="" method="post" role="form" style="display: block;">
                           <input type="hidden" name="action">
                           <a href='admin?action=confirmPage&id=${p.pid}&email=${p.email}&status=Approved' class="btn btn-primary setButton">Approve</a>
                           <a href='admin?action=confirmPage&id=${p.pid}&email=${p.email}&status=Rejected' class="btn btn-primary setButton">Reject</a>
                               </form>    
                        </td>
                        
		</tr>
		
         </cc:forEach>
		
	</tbody>
</table>



<%@include file="footer.jsp" %>