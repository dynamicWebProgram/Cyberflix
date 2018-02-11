<%@ page import="edu.txstate.internet.cyberflix.data.film.Film" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/v3css/4/v3.css">
<%@ page import="edu.txstate.internet.cyberflix.data.film.Film" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://www.w3schools.com/v3css/4/v3.css">

<head>
<link rel="stylesheet" href="header.css">
<style>
.apic{
	float: left;
	width: 80px;
	margin: 20px;
	border-style: outset;
	box-shadow: 10px 10px 5px #111;
}

.container{
	border-color: white;
	border-style: groove;
	border-width: 10px;
}

.container2{
	border-color: white;
	border-style: solid;
	border-width: 2px;
	margin: 10px;
}

.box{
    border-style: outset;
    border-color: white;
    border-width: 10px;
    text-align: center;
    padding: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html" charset="ISO8859-1">
</head>

<body style="background-color: rgb(45, 45, 45); color: white;">
<ul>
  <li><a class="active" href="http://localhost:8080/CyberFlix0/index.jsp">Home</a></li>
  <li><a href="http://localhost:8080/CyberFlix0/login.jsp">Log In</a></li>
  <li style="float:right"><a href="#">Proceed to Check Out</a></li>
</ul>

<div style="padding:20px;margin-top:30px;background-color:rgb(45, 45, 45); color: white;">
	<h1 class="box" style="text-align: center">Films in Cart</h1>
<!--  	<form action="CyberFlixDetailServlet" method="POST">  --> 
	<div class="container">
	<%int count = 0; %>
	<c:forEach items="${films}" var="film">
	<%count++; %>
		<div class="container2">
		<input class="apic" type = "image" src="${film.poster}" name="film_title" value="${film.title}"  width=25 />
		<h4>${film.title}</h4>
		<b>Fixed Daily Rate: </b>$1<br><br><br><br><br><br>
		</div>
	</c:forEach>
	<div class="container2">
		Total: $<%=count %>.00
	</div>
	</div>
<!--	</form>  -->


</div>
</body>
</html>