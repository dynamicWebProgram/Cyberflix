<%@page import="edu.txstate.cyberflix.data.db.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash Board</title>
<link rel="stylesheet" href="css/style.css" /> 
<style >
.butt {
    background-color: #333 /*#4CAF50; /* Green */
     margin: 0px 0px 0px 100%;
    font-family: "Times New Roman";
    float: right;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}</style>
</head>
<body>
<ul>
  <li><a class="active" href="http://localhost:8080/CyberFlix0/index.jsp">Home</a></li>
  <li><a href="http://localhost:8080/CyberFlix0/login.jsp">Log In</a></li>
  <form action="CyberFlixCheckOutServlet" method="POST"> <li><input class="butt" style="float:right; align: right; font-family: "Times New Roman";" type="submit" value="Check Out"></li></form>
</ul>

<div style="padding:20px;margin-top:30px;background-color:rgb(45, 45, 45); color: white;">

	<%! 
		Customer customer = null;
		
		String firstName = null;
	
	%>

	<%
	
		if(session.getAttribute("customer") != null) {
			
			customer = (Customer)session.getAttribute("customer");
			
			firstName = customer.getFirstName();
		}
	
	%>

	<h1 style="color: #4CAF50">Hello <%=firstName %>, Welcome to Cyberflix!</h1>

	<br/>
	</div>
	
</body>
</html>