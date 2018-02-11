<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registration</title>
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
        <form method="post" action="register">
            
            First Name:<input type="text" name="firstname" /><br />
            Last Name:<input type="text" name="lastname" /><br />
            Email:<input type="text" name="email" /><br />
            Password:<input type="text" name="password" /><br /><br />        
            <input type="submit" value="register" />
        </form>
    </body>
</html>