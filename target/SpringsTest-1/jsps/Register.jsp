<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function getalldetails() {
	
	document.forms[0].action="${pageContext.request.contextPath}/fulldetails";
	document.forms[0].submit();
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${success}
<h1>WELCOME TO DTDC SITE</h1>
<form action="${pageContext.request.contextPath}/Registrationpage">
<table>
<tr><td>Username:</td><td><input type="text" name="name"></td></tr></br>
<tr><td>Phone:</td><td><input type="text" name="phon"></td></tr></br>
<tr><td>Email:</td><td><input type="text" name="mail"></td></tr></br>
<tr><td>Password:</td><td><input type="password" name="pswd"></td></tr></br>
<tr><td>Re-typePassword:</td><td><input type="password" name="pswd1"></td></tr></br>
<tr><td>PinCode:</td><td><input type="text" name="pin"></td></tr></br>
<tr><td>City:</td><td><input type="text" name="city"></td></tr></br>
<tr><td>Address:</td><td><input type="text" name="address"></td></tr></br>
</table>
<input type="submit"  value="Register"/>
<input type="button" onclick="getalldetails()" value="fetchdetails"/>
<a href="${pageContext.request.contextPath}/jsps/login.jsp">login here</a>
</form>


<%-- <form action="${pageContext.request.contextPath}/fulldetails">
<input type="submit" value="fetchdetails">
</form> --%>


</body>
</html>