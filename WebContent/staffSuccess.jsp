<%@page import="edu.txstate.cyberflix.data.db.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash Board</title>
</head>
<body>

	<%! 
		Staff staff = null;
		
		String firstName = null;
	
	%>

	<%
	
		if(session.getAttribute("staff") != null) 
		{
			
			staff = (Staff)session.getAttribute("staff");
			//firstName = staff.getFirstName();
			//firstName = staff.toString();
			firstName = (staff.getFirstName().toString());
			
		}
	
	%>

	<h1>Hello <%=firstName %>, Welcome to Cyberflix!</h1>
			<form action="http://localhost:8080/CyberFlix0/CyberFlixCustomerDetailServlet" method="POST">
			<input type="submit" value="View Customers"/>
			</form>
			<!-- <a href="http://localhost:8080/CyberFlix0/CyberFlixCustomerDetailServlet"> View Customers</a>  -->

	<br/>
	
	
</body>
</html>