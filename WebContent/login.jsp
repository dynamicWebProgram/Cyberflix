<%@page import="edu.txstate.cyberflix.data.db.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<%!String errorMessage = null;%>
	<%
		if (request.getAttribute("errorMessage") != null) {
			errorMessage = (String) request.getAttribute("errorMessage");
			if (!errorMessage.isEmpty()) {
	%>
	<div class="alert">
		<span class="closebtn"
			onclick="this.parentElement.style.display='none';">&times;</span>
		<%
			out.println(errorMessage);
		%>
	</div>
	<%
		}
	}
	%>
	<form action="CyberFlixLogServlet" method="post">
		<div class="loginBox">
			<h1>Login</h1>
			<p>Please enter email and Password.</p>

			<input class="field" type="email" placeholder="Your Email"
				name="email" required /> <input class="field" type="password"
				placeholder="Your Password" name="password" required /> <input
				class="loginBtn" type="submit" value="Login" />
			<p>or</p>
			<a href="registration.jsp"> Register</a>
			
			<p>or</p>
			<a href="StaffLogin.jsp"> staff</a>
			</div>
	</form>
</body>
</html>