<%@page import="edu.txstate.cyberflix.data.db.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>

<head>
<style>
.container {
    position: relative;
    text-align: center;
    color: white;
}

.centered {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.box {
    border-style: solid;
    border-color: red;
    border-width: 5px;
    text-align: center;
    background-color: black;
  
  }

.bttn {
	width: 100px;
	height: 25px;
	margin: 2.5px;
	font-size: 12px;
	padding: 1px;
}
  
input[type="radio"]{
  margin: 0 5px 0 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>CyberFlix</title>
<!-- <link rel="stylesheet" href="css/style.css" /> -->
</head>
<body style="background-color: rgb(35, 35, 35); color: red">
<!-- <div class="container">
<img src=https://www.proximus.be/dam/jcr:2dd76d0b-21ed-4804-9c65-3f5844fb779c/cdn/sites/iportal/images/social_network/res/netflix-social-en~2016-11-25-14-15-48~cache.jpg
alt="Cyberflix image" style="width: 100%">
<div class="centered" style="font-size: 100px">CyberFlix</div>
</div>-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.txstate.internet.cyberflix.data.film.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.txstate.cyberflix.data.db.FilmDAO" %>
<%	FilmDAO fd =new FilmDAO(); %>
<%	List<Film> newFilms = fd.findNewestFilms(); %>
<%request.getSession().setAttribute("films", newFilms); %>
<div class="container">
<img src="https://reeldealbsu.files.wordpress.com/2015/12/movies_digital_art_collage_movie_posters_fan_art_1920x1080.jpg?w=1920&h=768&crop=1" alt="Cyberflix image"  style="width: 100%; box-shadow: 25px 25px 15px #000;">
<div class="centered" style="font-size: 100px; border-style: solid; borderc-color: red; text-outline: 20px 20px #ff000">CyberFlix</div>
<!-- https://cdn-images-1.medium.com/max/1600/1*WwVsa9UvKpoffnWDL-FzsQ.jpeg-->
<!-- "https://reeldealbsu.files.wordpress.com/2015/12/movies_digital_art_collage_movie_posters_fan_art_1920x1080.jpg?w=1920&h=768&crop=1" -->
<div class="centered box" style="font-size: 100px; color: red; text-shadow: 5px 5px rgb(10, 10, 10)">CYBERFLIX!</div>
</div >

  <h1 class="box" style="text-align: center; box-shadow: 25px 25px 15px #000;">New Arrivals</h1>
	<form action="CyberFlixDetailServlet" method="POST"> 
	<div class="container" style="align: center; width: 1000px;">
	<%-- <%int counter = 0; %> --%>
	<c:forEach items="${films}" var="film"><%-- <%counter++; %> --%>
		<div style="float: left; " class="container2">
		<input class="apic" type = "image" src="${film.poster}" name="film_title" value="${film.title}" width=150 />
		<h6>${film.title}</h6>
		<%-- <%if(counter>4){break;} %> --%>
		</div>
	</c:forEach>
	
	</div>
	</form>


<center><h2 class="box" style="box-shadow: 25px 25px 15px #000; text-shadow: 5px 5px rgb(0, 0, 0);">Let's find you a movie!</h2></center>
<div class="row">
<div class="column" style="float: left; padding: 30px 10px 10px 120px; width: 33%; height: 25%; text-align: Left">
<form action="http://localhost:8080/CyberFlix0/CyberFlixServlet" method="get" style="color: red; text-shadow: 5px 5px rgb(0, 0, 0)">

	<h4>Search by Attribute: </h4>
  <div><b>Film Title: </b><input type="text" name="film_title"><br></div>
  <div><b>Film Description: </b><input type="text" name="film_description"><br></div>
  <div><b>Film Rating: </b><select name="film_rating">
  						<option disabled selected value></option>
  						<option value="G">G</option>
  						<option value="PG">PG</option>
  						<option value="PG-13">PG-13</option>
  						<option value="R">R</option>
  						<option value="NC-17">NC-17</option>
  						<option value="X">X</option>
  						<option value="UR">UR</option>
  					</select><br></div>				<!-- </b> <input type="text" name="film_rating"><br>-->
  <b>Running Time: </b><br>
  <input type="radio" name="film_length" value="-1" checked>Any
  <input type="radio" name="film_length" value="30">30   
  <input type="radio" name="film_length" value="60">60
  <input type="radio" name="film_length" value="90">90
  <input type="radio" name="film_length" value="120">120
  <input type="radio" name="film_length" value="150">150
  <br>
  
    <input class="btn" type="submit" value="Submit" style="margin: 20px 0px 0px 0px">

 </form>
  </div>
   <div class="column" style="text-align: center; float:left; padding: 30px 0 0 80px">
 <form action="http://localhost:8080/CyberFlix0/CyberFlixCategoryServlet" method="get" style="color: red; text-shadow: 5px 5px rgb(0, 0, 0)">

 <h4>Browse alphabetically by: </h4><br><select name="film_alphabet">
 								<option disabled selected value></option>
 								<option value="A">A</option>
 								<option value="B">B</option>
 								<option value="C">C</option>
 								<option value="D">D</option>
 								<option value="E">E</option>
 								<option value="F">F</option>
 								<option value="G">G</option>
 								<option value="H">H</option>
 								<option value="I">I</option>
 								<option value="J">J</option>
 								<option value="K">K</option>
 								<option value="L">L</option>
 								<option value="M">M</option>
 								<option value="N">N</option>
 								<option value="O">O</option>
 								<option value="P">P</option>
 								<option value="Q">Q</option>
 								<option value="R">R</option>
 								<option value="S">S</option>
 								<option value="T">T</option>
 								<option value="U">U</option>
 								<option value="V">V</option>
 								<option value="W">W</option>
 								<option value="X">X</option>
 								<option value="Y">Y</option>
 								<option value="Z">Z</option>
 								</select><br>
 	<input class="btn" type="submit" value="Submit" style="margin: 20px 0px 0px 0px">
 	</form>
 	<a href="login.jsp"><button class="btn" style="color: red; margin: 10px 0 0 0;">Login</button></a>
 	 	</div>
  <div class="column" style="float: right; padding: 30px 120px 0 0; width: 43%; height: 25%; text-align: center">
 <form action="http://localhost:8080/CyberFlix0/CyberFlixCategoryServlet" method="get" style="color: red; text-shadow: 5px 5px rgb(0, 0, 0)">									

 	<h4>Browse by Genre: </h4>
 	<div>
 		<input class="btn bttn" type="submit" name="film_category" value="ACTION">
 		<input class="btn bttn" type="submit" name="film_category" value="ANIMATION">
 		<input class="btn bttn" type="submit" name="film_category" value="CHILDREN">
 		<input class="btn bttn" type="submit" name="film_category" value="CLASSIC">
 	</div>
 	<div>
 		<input class="btn bttn" type="submit" name="film_category" value="COMEDY">
 		<input class="btn bttn" type="submit" name="film_category" value="DOCUMENTARY">
 		<input class="btn bttn" type="submit" name="film_category" value="DRAMA">
 		<input class="btn bttn" type="submit" name="film_category" value="FAMILY">
 	</div>
 	<div>
 		<input class="btn bttn" type="submit" name="film_category" value="FOREIGN">
 		<input class="btn bttn" type="submit" name="film_category" value="GAMES">
 		<input class="btn bttn" type="submit" name="film_category" value="HORROR">
 		<input class="btn bttn" type="submit" name="film_category" value="MUSIC">
 	</div>
 	<div>
 		<input class="btn bttn" type="submit" name="film_category" value="NEW">
 		<input class="btn bttn" type="submit" name="film_category" value="SCI_FI">
 		<input class="btn bttn" type="submit" name="film_category" value="SPORTS">
 		<input class="btn bttn" type="submit" name="film_category" value="TRAVEL">
 	</div>
 </form>
 </div>

</div>


<%-- <%!String errorMessage = null;%>
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
	<form action="authenticate" method="post">
		<div class="loginBox">
			<h1>Login</h1>
			<p>Please enter email and Password.</p>

			<input class="field" type="email" placeholder="Your Email"
				name="email" required /> <input class="field" type="password"
				placeholder="Your Password" name="password" required /> <input
				class="loginBtn" type="submit" value="Login" />
			<p>or</p>
			<a href="registration.jsp"> Register</a>
			</div>
	</form>
 --%>
</body>
</html>
