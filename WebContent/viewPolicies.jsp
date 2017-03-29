<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>

.fit{
    padding-left: 10%;
}

footer{
   padding-top: 40%;
}


.setButton {
    width: 200px;
}

</style>
</head>
<body>
<%@include file="header.jsp" %>


 <%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
            <% int i=0;%> <br>
            <cc:forEach var="p" items="${policiesList}">
    
  
            
            
            <%if(i%2==0)
             {%>
                                        </div>
                                        <div class="row">
                                        
                                        <% if(i!=0)
                   {%>
                                                <br><br><br>
                                                <% }%>
                                                    <%}%>
                                                    
                             <div class="col-sm-6">
                             <div class="card card-block  text-center">
                              
                             <h2 class="card-title">${p.type} Insurance</h2>
                             <h4 class="card-text">${p.description}<br>Annual Cost : $${p.cost}<br> Maximum Coverage : $${p.max_coverage} </h4>       
                             <form action="" method="post" role="form" style="display: block;">
                                       <input type="hidden" name="action">
                                     <a href="user?action=bookPolicy&code=${p.pid}&type=${p.type}" class="btn btn-primary setButton">Register</a>
                               </form>   
                                </div>
                                                            </div>
                                                            <% i=i+1;%>
                                                      
                                
                                                            
                                </cc:forEach>       
                                                    
                                                    



<%@include file="footer.jsp" %>