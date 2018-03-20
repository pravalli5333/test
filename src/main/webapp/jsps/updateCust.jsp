<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateCustomer" method="post">
<table>
<tr><td>Username:</td><td><input type="text" name="name" value="${customer.name}" ></td></tr></br>
<tr><td>Phone:</td><td><input type="text" name="phon" value="${customer.phon}"></td></tr></br>
<tr><td>Email:</td><td><input type="text" name="mail" value="${customer.mail}" readonly="readonly" ></td></tr></br>
<tr><td>Password:</td><td><input type="password" name="pswd" value="${customer.pswd}"></td></tr></br>
<tr><td>PinCode:</td><td><input type="text" name="pin" value="${customer.pin}"></td></tr></br>
<tr><td>City:</td><td><input type="text" name="city" value="${customer.city}"></td></tr></br>
<tr><td>Address:</td><td><input type="text" name="address" value="${customer.address}"></td></tr></br>
</table>
<input type="submit" value="Update"/>
</form>
</body>
</html>