

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
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
<head>
<link rel="stylesheet" href="header.css">
<style>
.apic{
	float: left;
	width: 150px;
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
	box-shadow: 15px 15px 10px #000;
	margin: 10px;
}

.box{
    border-style: outset;
    border-color: white;
    border-width: 10px;
    text-align: center;
    padding: 20px;
   
}

.butt {
    background-color: #333/*#4CAF50; /* Green */
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
}
</style>
<meta http-equiv="Content-Type" content="text/html" charset="ISO8859-1">
</head>
<body style="background-color: rgb(45, 45, 45); color: white; ">
<ul>
  <li><a class="active" href="http://localhost:8080/CyberFlix0/index.jsp">Home</a></li>
  <li><a href="http://localhost:8080/CyberFlix0/login.jsp">Log In</a></li>
  <form action="CyberFlixCheckOutServlet" method="POST"> <li><input class="butt" style="float:right; align: right; font-family: "Times New Roman";" type="submit" value="Check Out"></li></form>
</ul>

<div style="padding:20px;margin-top:30px;background-color:rgb(45, 45, 45); color: white;">
	<h1 class="box" style="text-align: center">Movies Matching Your Search</h1>
	<form action="CyberFlixDetailServlet" method="POST"> 
	<div class="container" style="text-shadow: 5px 5px rgb(0, 0, 0)">
	<c:forEach items="${films}" var="film">
		<div class="container2">
		<input class="apic" type = "image" src="${film.poster}" name="film_title" value="${film.title}" width=150 />
		<h4>${film.title}</h4>
		<b>Running Time: </b>${film.length}<br><br>
		<b>Year: </b> ${film.releaseYear}<br><br><br><br><br>
		<p style="align: bottom"> ${film.description}</p><br><br>
		<form action="http://localhost:8080/CyberFlix0/CyberFlixCartServlet" method="get" style="color: red; text-shadow: 5px 5px rgb(0, 0, 0)">									
 		<%-- <input class="btn bttn" type="submit" name="film_title" value="${film.title}"> --%>
 		<button class="btn" style="color: white" type="submit" name="film_title" value="${film.title}">Add to Cart</button> 
		</form></div>
	</c:forEach>
	
	</div>
	</form>


</div>
</body>
</html>