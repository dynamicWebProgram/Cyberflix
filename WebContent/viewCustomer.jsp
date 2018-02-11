<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
<head>
<%@ page import="edu.txstate.cyberflix.data.db.RentalRecord" %>
<%@ page import="edu.txstate.cyberflix.data.db.RentalDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<link rel="stylesheet" href="header.css" style="float: left;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rental Record</title>
</head>
<body>
<style>
        body{background-color: rgb(45, 45, 45);  
        		
        		padding-right: 100px;
        		
        		}
        
        h1	{border-style: outset;
        		padding: 5px;
        		box-shadow: 15px 15px 10px #000;
        		display: inline-block; 
        		color: White; 
        		width: 700px;
        		text-align: center;
        		border-radius: 8px;}
        		
        	.box{
        		border-style: outset;
        		padding: 5px;
        		box-shadow: 15px 15px 10px #000;
        		margin-left: 10px;
        		width: 365px;
        		border-radius: 8px;
        		margin-right: 30px;
        		height: 435px;
        		float: right;
        		
        	}
        
        h2  {color: White;}
        
        p   {text-align:left;
        		display: inline;
        		color: White;
        		text-autospace: none;}
        	
        	img {float: left;
        		margin-right: 10px;
        		border-style: outset;
			box-shadow: 15px 15px 10px #111;
			border-radius: 8px;
			}
		.butt {
		    background-color: #4CAF50; /* Green */
		    <!-- margin: 0px 0px 0px 850px;-->
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rental Record</title>
</head>

<body>
<ul>
  <li><a class="active" href="http://localhost:8080/CyberFlix0/index.jsp">Home</a></li>
  <li><a href="http://localhost:8080/CyberFlix0/login.jsp">Log In</a></li>
  <form action="CyberFlixCheckOutServlet" method="POST"> <li><input class="butt" style="float:right; align: right; font-family: "Times New Roman";" type="submit" value="Check Out"></li></form>
</ul>

<div style="padding:20px;margin-top:30px;background-color:rgb(45, 45, 45); color: white; ">
<font face="helvetica" color="White">
	
	<p>
	<br><br><br>
	<div style="width: 100%; margin: 0px 100px 0px 100px; text-shadow: 5px 5px rgb(0, 0, 0);" >
	<div style="margin: auto; width: 750px">
	<h1>${customer.firstName} ${customer.lastName}'s Rental Record</h1><br> 
	
	<div class="box">
	<b>Customer ID: </b>${customer.id}<br><br>
	<b>Email Address: </b>${customer.emailAddress}<br><br>
	<b>Current Films Rented: </b>
	<c:forEach items="${rentals}" var="rental" varStatus="loop">
			Rental ID:${rental.retailId} 
			${rental.rentalDate}
			${rental.filmId}
			${rental.customerId}
			${rental.returnDate}
			${!loop.last ? ',' : ''}
			<br><br>
		</c:forEach>
		<br><br><br><br><br>
		
	</div>
	</div>
	</div>
	</font></div>
</body>
</html>