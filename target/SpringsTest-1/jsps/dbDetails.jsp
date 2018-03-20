<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
All THE DETAILS OF THE CUSTOMERS ENTERED</br>

<c:forEach items="${collected}" var="var">${var.itemname} || ${var.weight} || ${var.currentcity} || ${var.tocity} || ${var.price}</br></c:forEach></br>
<form action="Details">

</form>
</body>
</html>