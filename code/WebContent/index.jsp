<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="model.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>
<body>
 <form action="LoginServlet" method="post">
 	username<input type="text" name="username" placeholder="username">
 	password<input type="password" name="password" placeholder="password">
 	<input type ="submit" value="login">
 </form>
 <a href="signup" ><button>signup</button></a> 
 <% Messages message = (Messages)request.getAttribute("message"); 
if(message !=null){
if(message.getId()==2)
{
%>
<span style="color:green"><%=message.getMessage() %></span>
<%} if(message.getId()==1){ %>
<span style="color:red"><%=message.getMessage() %></span>
<%}} %>
</body>
</html>