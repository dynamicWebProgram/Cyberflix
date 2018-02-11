<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!--<%@ page import="edu.txstate.cs3320.toman.weaver.data.film.Film, edu.txstate.cs3320.toman.weaver.data.film.FilmCatalog, edu.txstate.cs3320.toman.weaver.CyberFlixServlet" %>-->
<%@ page import="edu.txstate.internet.cyberflix.data.film.Film" %>
<!DOCTYPE html>
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Gochi+Hand" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/slideshow.css" />
		<link rel="stylesheet" type="text/css" href="css/slideshow_layouts.css" />
<meta charset="ISO-8859-1">
<title>CyberFlix</title>
</head>
<body>
<div>
			<header class="codrops-header">
					<a class="dummy-links__link dummy-links__link--current" href="http://localhost:8080/CyberFlix0/WebContent/index.html">Home</a>
					<a class="dummy-links__link"  href="http://localhost:8080/CyberFlix0/NavigateServlet?link=Search">Search</a>
					<a class="dummy-links__link"  href="http://localhost:8080/CyberFlix0/NavigateServlet?link=Browse">Browse</a>
					<a class="dummy-links__link"  href="http://localhost:8080/CyberFlix0/NavigateServlet?link=LoginRegister">Log In</a>
					<a class="dummy-links__link"  href="http://localhost:8080/CyberFlix0/NavigateServlet?link=Cart">View Cart</a>
					<a class="dummy-links__link"  href="http://localhost:8080/CyberFlix0/NavigateServlet?link=CheckOut">Check Out</a>		
			</header>		
			<img style="float: right; width: 150px; height: 150px; box-shadow: none" src="images/logo.png"/><br>
<h1> Welcome to CyberFlix!</h1>
<h2> Let's Find You a Movie! </h2>
</div>
<p>
<p>

<div class="search">
<form action="http://localhost:8080/CyberFlix0/CyberFlixServlet"  method="get">
  Title: <input type="text" name="title">
  <hr>
  Description: <input type="text" name="description">
  <hr>
  Running Time:<br>
      <input type="radio" id="G"
     name="rating" value="0">
    <label for="G">G</label>
          <input type="radio" id="PG"
     name="rating" value="1">
    <label for="PG">PG</label>
          <input type="radio" id="PG13"
     name="rating" value="2">
    <label for="PG13">PG-13</label>
          <input type="radio" id="R"
     name="rating" value="3">
    <label for="R">R</label>
          <input type="radio" id="NC"
     name="rating" value="4">
    <label for="NC">NC-17</label>
              <input type="radio" id="X"
     name="rating" value="5">
    <label for="X">X</label>
              <input type="radio" id="UR"
     name="rating" value="6">
    <label for="UR">UR</label>
    <hr>
    
  Running Time:<br>
      <input type="radio" id="30"
     name="time" value="30">
    <label for="30">30</label>
          <input type="radio" id="60"
     name="time" value="60">
    <label for="60">60</label>
          <input type="radio" id="90"
     name="time" value="90">
    <label for="90">90</label>
          <input type="radio" id="120"
     name="time" value="120">
    <label for="120">120</label>
          <input type="radio" id="1200"
     name="time" value="1200">
    <label for="1200">120+</label>
    <hr>
  <input class="button"  type="submit"  value="Search">
</form>
</div>
</body>
</html>