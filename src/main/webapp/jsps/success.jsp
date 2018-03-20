<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${correct}
${wrong}
${tellme}
<form action="${pageContext.request.contextPath}/order">
ItemName:<input type="text" name="itemname"/></br>
Weight:<input type="text" name="weight"/></br>
From City: <select name="currentcity">
<option></option>
<option>hyderabad</option>
<option>chennai</option>
</select></br>
To City<input type="text" name="tocity"/></br>
Price:<input type="text" name="price"/></br>
<input type="submit" value="place order"/>
</form>




<form action="${pageContext.request.contextPath}/mainorder">
<input type="submit" value="OrdersList"/>
</form>



<form action="${pageContext.request.contextPath}/updateaction">
<input type="submit" value="fetchorderlist">
</form>
</body>
</html>