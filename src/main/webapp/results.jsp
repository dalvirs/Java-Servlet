<%--  
Author(s): Dalvir Singh Chiount (A01258927)
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lab 10</title>
</head>
<body>
	<jsp:useBean id="user" class="ca.bcit.comp3601.lab10.User" />
	<jsp:setProperty name="user" property="name" value="${name}" />
	<h1>
		Hello
		<jsp:getProperty property="name" name="user" /><br>
		${parameter.greeting}
	</h1>
	<br> The current time is:<jsp:include page="dateAndTime.jsp"></jsp:include>
</body>
</html>