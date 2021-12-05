<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "model.*" %>
    <% User u = (User)session.getAttribute("user"); 
    if(u==null){
    String message = "you are not connected ! ";
    request.setAttribute("message", message);
    request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    else{
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome </title>
</head>
<body>
<h1>welcom mr <%=u.getUsername() %></h1>
<a href="Deconnection">Decconecter</a>
</body>
</html>
<%}%>