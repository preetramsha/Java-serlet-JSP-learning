<%@page import="java.util.concurrent.Delayed"%>
<%@page import="java.io.PrintWriter"%>
<%@include file="config.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style type="text/css">
th,td,tr {
	padding: 20px;
}
</style>
</head>
<body>
<h1>Insert API key</h1>

	<form action="dashboard.jsp" method="post"> <br>
		<input type="number" placeholder="id" name="id">
		<div>give when updating</div><br>
		<input type="text" placeholder="api key name" name="apiname"><br>
		<input type="password" placeholder="apikey" name="apikey"><br>
		<input type="date" name="date"><br>
		<input type="number" placeholder="apicalls" name="apicalls"><br>
		<input type="email" placeholder="email" name="email"><br>
		<select name="category">
			<option value="books">books</option>
			<option value="shoes">shoes</option>
			<option value="watch">watch</option>
		</select><br>
		<label for="isactive">active</label>
		<input id="isactive" value="true" type="radio" name="active"><br>
		<label for="notactive">not active</label>
		<input id="notactive" value="false" name="active" type="radio" ><br>
		<input type="submit" value="submit" name="submit">
		<input type="submit" value="update" name="update">
	</form>
	
	<h2>delete</h2>
	<form action="dashboard.jsp" method="post">
		<input type="number" name="delid" placeholder="id">
		<input type="submit" value="delete" name="delete">
	</form>
	
	<br>
	<br>
	<br>
	<br>
	<table>
		<thead>
			<tr>
			<th> id</th>
			<th> apikey</th>
			<th> apikeyname</th>
			<th> date created</th>
			<th> api calls</th>
			<th> email</th>
			<th> category</th>
			<th> active</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			PrintWriter out1 = response.getWriter();
			connectdb(out1);
			ResultSet rs = getapikeys();
			
			while(rs.next()){
				out.println("<tr> <td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>" + rs.getString(8) + "</td> </tr>");
			}
			%>
		</tbody>
	</table>
</body>
<%

String id = request.getParameter("id");
String delid = request.getParameter("delid");
String name = request.getParameter("apiname");
String apikey = request.getParameter("apikey");
String date = request.getParameter("date");
String apicalls = request.getParameter("apicalls");
String email = request.getParameter("email");
String category = request.getParameter("category");
String active = request.getParameter("active");
String submit = request.getParameter("submit");
String update = request.getParameter("update");
String delete = request.getParameter("delete");


if(submit!=null){
	insertapi(out1, name, apikey, date, apicalls, email, category, active);
	submit = null;
	response.sendRedirect("dashboard.jsp");
}

if(update!=null){
	updateapi(out1, id, name, apikey, date, apicalls, email, category, active);
	update = null;
	response.sendRedirect("dashboard.jsp");

}

if(delete!=null){
	deleteapi(out1,delid);
	delete = null;
	response.sendRedirect("dashboard.jsp");
}
%>














