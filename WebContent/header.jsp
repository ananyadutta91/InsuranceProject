
<!DOCTYPE html >

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>  
<html>
<head>
    <title>Book My Policy</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
                <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
                <link rel="stylesheet" href="styles/header.css">
             
</head>
<body>


<div id="header">
                    <nav id="header_menu">
                        
                        <ul class="right">
                        <c:if test="${role == 'customer' }">
                    
                                <li> <font color="white">Welcome ${sessionScope.name}</font></li>
                                <li><a href="user?action=aboutUs">About Us</a></li>
                                <li><a href="user?action=viewPolicies">View Policies</a>
                                	<ul>
                                	<li><a href="user?action=viewPolicies&type=life">Life Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=motor">Motor Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=health">Health Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=house">House Insurance</a></li>
                                	</ul>
                                </li>
                                <li><a href="user?action=myPolicies">My Policies</a></li>
                                <li><a href="user?action=discussionForum">Discussion Forum</a></li>
                                <li><a href="user?action=logout">Logout</a></li>
                            </c:if>
                            <c:if test="${role == 'admin'}">
                                <li> <font color="white">Welcome ${sessionScope.name}</font></li>
                                <li><a href="user?action=aboutUs">About Us</a></li>
                                <li><a href="admin?action=viewPolicies">View Policies</a>
                                	<ul>
                                	<li><a href="user?action=viewPolicies&type=life">Life Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=motor">Motor Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=health">Health Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=house">House Insurance</a></li>
                                	</ul>
                                </li>
                                <li><a href="admin?action=viewOfficials">View Officials</a></li>
                                <li><a href="admin?action=addOfficial">Add Official</a></li>
                                <li><a href="admin?action=approvePolicy">Policy Approvals</a></li>
                                <li><a href="admin?action=viewCustomers">View Customers</a></li>
                                <li><a href="admin?action=viewTransactions">View Transactions</a></li>
                                <li><a href="user?action=discussionForum">Discussion Forum</a></li>
                                <li><a href="user?action=logout">Logout</a></li>
                            </c:if>
                            <c:if test="${role == 'official'}">
                            <li> <font color="white">Welcome ${sessionScope.name}</font></li>
                                <li><a href="user?action=aboutUs">About Us</a></li>
                                <li><a href="user?action=viewPolicies">View Policies</a>
                                	<ul>
                                	<li><a href="user?action=viewPolicies&type=life">Life Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=motor">Motor Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=health">Health Insurance</a></li>
                                		<li><a href="user?action=viewPolicies&type=house">House Insurance</a></li>
                                	</ul>
                                </li>
                                <li><a href="admin?action=addPolicy">Add Policy</a></li>
                                <li><a href="admin?action=viewCustomers">View Customers</a></li>
                                <li><a href="user?action=discussionForum">Discussion Forum</a></li>
                                <li><a href="user?action=logout">Logout</a></li>
                            </c:if>
                        </ul>
                    </nav>
</div>

                
                