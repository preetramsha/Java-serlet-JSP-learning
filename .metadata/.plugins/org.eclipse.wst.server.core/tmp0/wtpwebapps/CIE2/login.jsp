<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="config.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="login.jsp" method="post">
			<input type="text" name="email" placeholder="email">
			<input type="password" name="pass" placeholder="pass">
			<input type="submit" name="submit" value="submit">
		</form>
	</body>
</html>
<%
PrintWriter out1 = response.getWriter();
connectdb(out1);
String email = null;
email = request.getParameter("email");
String pass = null;
pass = request.getParameter("pass");
String submit = null;
submit = request.getParameter("submit");

if(submit!= null){
	if(chkuser(out1, email, pass)){
		out.print("logged in");
		response.sendRedirect("dashboard.jsp");
	}else{
		out.print("incorrect username or pass");
	}
}
%>









