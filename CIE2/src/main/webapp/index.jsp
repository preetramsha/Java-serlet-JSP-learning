<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="config.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Here</title>
</head>
<body>
<h1>Register</h1>
	<form action="index.jsp" method="post">
		<input type="text" name="email" placeholder="email">
		<input type="password" name="pass" placeholder="password">
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>
<%
PrintWriter out1 = response.getWriter();
connectdb(out1);
String submit = null;
String email = null;
String pass = null;
submit = request.getParameter("submit");
email = request.getParameter("email");
pass = request.getParameter("pass");
	if(submit != null){
		insertUser(out1,email,pass);
		//response.sendRedirect("login.jsp");
	}
%>











