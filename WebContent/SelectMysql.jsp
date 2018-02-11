<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1><center>CyberFlix Customers</center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CyberFlix Customers</title>
</head>
<body>

<%
Connection con;
Class.forName("com.mysql.jdbc.Driver");
con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Puffin08!");
PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * from customer");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
  int id = rs.getInt("customer_id");	
  String firstName = rs.getString("first_name");
  String lastName = rs.getString("last_name");
  String email = rs.getString("email");
  int phoneNumber = rs.getInt("phone_number");

	out.println("<br>" +id+"  <b>"+firstName+" "+lastName+" </b><i>"+email+"</i> "+phoneNumber+"<hr>");
	//id, firstName, lastName,email,phoneNumber
}




%>
</body>
</html>