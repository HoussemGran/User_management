<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup</title>
</head>
<body>
<form method="post" action="signup">
	email:<br><input type="text" name="email" placeholder="email"><br>
	name<br><input type="text" name="name" placeholder="name"><br>
	lastname<br><input type="text" name="surname" placeholder="lastname"><br>
	username<br><input type="text" name="username" placeholder="username"><br>
	password<br><input type="password" name="pass1" placeholder="password"><br>
	confirm password<br><input type="password" name="pass2" placeholder="confirm password"><br>
	<input type="submit" value="signup">
</form>

<% Messages message = (Messages)request.getAttribute("message"); 
	if(message !=null){
	if(message.getId()==1)
	{
%>
	<span style="color:red"><%=message.getMessage()%></span>

<%} if(message.getId()==2){ %>

	<span style="color:green"><%=message.getMessage() %></span>

<%}} %>

</body>
</html>