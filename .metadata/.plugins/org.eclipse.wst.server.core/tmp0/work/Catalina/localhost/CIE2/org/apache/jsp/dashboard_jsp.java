/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2024-03-18 14:22:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.concurrent.Delayed;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import org.apache.catalina.connector.Response;
import java.io.PrintWriter;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 
Connection con = null;
ResultSet rs = null;
PreparedStatement ps = null;
String qur = null;
PrintWriter out;
public void connectdb(PrintWriter out){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/cie2jsp","root","Generalhacker1915");
		out.println("connected to db");
	}catch(Exception e){
		out.print(e);
	}
}

public void insertUser(PrintWriter out,String email,String pass){
	try{
		qur = "insert into users values(null,?,?)";
		ps = con.prepareStatement(qur);
		ps.setString(1, email);
		ps.setString(2, pass);
		int i = ps.executeUpdate();
		if(i>0){
			out.println("User Created");
		}
	}catch(Exception e){
		out.print(e);
	}
}

public boolean chkuser(PrintWriter out,String email,String pass){
	try{
		qur = "select email,pass from users where email = '"+email+"' and pass = '"+pass+"';";
		ps = con.prepareStatement(qur);
		rs = ps.executeQuery();
		if(rs.next()){
			return true;
		}
		else{
			return false;
		}
	}catch(Exception e){
		out.println(e);
		return false;
	}
}

public boolean insertapi(PrintWriter out,String name,String apikey,String date,String apicalls, String email,String category, String active){
	try{
		qur = "insert into api_keys values(null,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(qur);
		
		ps.setString(1, apikey);
		ps.setString(2, name);
		ps.setString(3, date);
		ps.setString(4, apicalls);
		ps.setString(5, email);
		ps.setString(6, category);
		ps.setString(7, active);
		
		int i = ps.executeUpdate();
		if(i>0){
			out.println("Inserted");
			return true;
		}
		return false;
	}catch(Exception e){
		out.print(e);
		return false;
	}
}
public boolean updateapi(PrintWriter out,String id,String name,String apikey,String date,String apicalls, String email,String category, String active){
    try{
        qur = "update api_keys set apikey = ?, api_keyname = ?, date_created = ?, api_calls = ?, email = ?, category = ?, active = ? where id = ?";
        ps = con.prepareStatement(qur);
        
        ps.setString(1, apikey);
        ps.setString(2, name);
        ps.setString(3, date);
        ps.setString(4, apicalls);
        ps.setString(5, email);
        ps.setString(6, category);
        ps.setString(7, active);
        ps.setString(8, id);
        
        int i = ps.executeUpdate();
        if(i>0){
            out.println("Updated");
            return true;
        }
        return false;
    }catch(Exception e){
        out.print(e);
        return false;
    }
}
public ResultSet getapikeys(){
	try{
		qur = "select * from api_keys;";
		ps = con.prepareStatement(qur);
		rs = ps.executeQuery();
		return rs;
	}catch(Exception e){
		out.println(e);
		return null;
	}
}

public boolean deleteapi(PrintWriter out,String id){
	try{
		qur = "delete from api_keys where id = ?";
		ps = con.prepareStatement(qur);
		
		ps.setString(1, id);
		
		int i = ps.executeUpdate();
		if(i>0){
			out.println("Deleted");
			return true;
		}
		return false;
	}catch(Exception e){
		out.print(e);
		return false;
	}
}


  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/config.jsp", Long.valueOf(1710771339000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("org.apache.catalina.connector.Response");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.util.concurrent.Delayed");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Dashboard</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("th,td,tr {\n");
      out.write("	padding: 20px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>Insert API key</h1>\n");
      out.write("\n");
      out.write("	<form action=\"dashboard.jsp\" method=\"post\"> <br>\n");
      out.write("		<input type=\"number\" placeholder=\"id\" name=\"id\">\n");
      out.write("		<div>give when updating</div><br>\n");
      out.write("		<input type=\"text\" placeholder=\"api key name\" name=\"apiname\"><br>\n");
      out.write("		<input type=\"password\" placeholder=\"apikey\" name=\"apikey\"><br>\n");
      out.write("		<input type=\"date\" name=\"date\"><br>\n");
      out.write("		<input type=\"number\" placeholder=\"apicalls\" name=\"apicalls\"><br>\n");
      out.write("		<input type=\"email\" placeholder=\"email\" name=\"email\"><br>\n");
      out.write("		<select name=\"category\">\n");
      out.write("			<option value=\"books\">books</option>\n");
      out.write("			<option value=\"shoes\">shoes</option>\n");
      out.write("			<option value=\"watch\">watch</option>\n");
      out.write("		</select><br>\n");
      out.write("		<label for=\"isactive\">active</label>\n");
      out.write("		<input id=\"isactive\" value=\"true\" type=\"radio\" name=\"active\"><br>\n");
      out.write("		<label for=\"notactive\">not active</label>\n");
      out.write("		<input id=\"notactive\" value=\"false\" name=\"active\" type=\"radio\" ><br>\n");
      out.write("		<input type=\"submit\" value=\"submit\" name=\"submit\">\n");
      out.write("		<input type=\"submit\" value=\"update\" name=\"update\">\n");
      out.write("	</form>\n");
      out.write("	\n");
      out.write("	<h2>delete</h2>\n");
      out.write("	<form action=\"dashboard.jsp\" method=\"post\">\n");
      out.write("		<input type=\"number\" name=\"delid\" placeholder=\"id\">\n");
      out.write("		<input type=\"submit\" value=\"delete\" name=\"delete\">\n");
      out.write("	</form>\n");
      out.write("	\n");
      out.write("	<br>\n");
      out.write("	<br>\n");
      out.write("	<br>\n");
      out.write("	<br>\n");
      out.write("	<table>\n");
      out.write("		<thead>\n");
      out.write("			<tr>\n");
      out.write("			<th> id</th>\n");
      out.write("			<th> apikey</th>\n");
      out.write("			<th> apikeyname</th>\n");
      out.write("			<th> date created</th>\n");
      out.write("			<th> api calls</th>\n");
      out.write("			<th> email</th>\n");
      out.write("			<th> category</th>\n");
      out.write("			<th> active</th>\n");
      out.write("			</tr>\n");
      out.write("		</thead>\n");
      out.write("		\n");
      out.write("		<tbody>\n");
      out.write("			");

			PrintWriter out1 = response.getWriter();
			connectdb(out1);
			ResultSet rs = getapikeys();
			
			while(rs.next()){
				out.println("<tr> <td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>" + rs.getString(8) + "</td> </tr>");
			}
			
      out.write("\n");
      out.write("		</tbody>\n");
      out.write("	</table>\n");
      out.write("</body>\n");


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}