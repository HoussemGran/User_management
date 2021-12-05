<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<h1> List of users</h1>

<table>
<tr>
<th>username</th><th>email</th><th>Delete User</th>
</tr>

<c:forEach var="i" items="${alluser}">
<tr>
	<td>
	${i.username}
	</td>

	<td>
	${i.email}
	</td>

	<td>
	<a href="DeleteUser?id=${i.username}">delete</a>
	</td>

</tr>
 </c:forEach>

</table>


</body>
</html>