<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
	<h1>welcome 
	<%String name=(String)session.getAttribute("uname");%>
	<%=name %>
	<h1>
</body>
</html>