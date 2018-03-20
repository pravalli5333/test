<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deleterow(mail) {
	alert(mail);
	document.forms[0].action="${pageContext.request.contextPath}/delete?mail="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();	
}
function editrow(mail) {
	alert(mail);
	document.forms[0].action="${pageContext.request.contextPath}/openEditMode?emailId="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<table border="1">
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Mail</th>
				<th>Password</th>
				<th>PinCode</th>
				<th>City</th>
			</tr>
		<core:forEach var="cust" items="${selecteddetails}">
			<tr>
				<td>${cust.name}</td>
				<td>${cust.phon}</td>
				<td>${cust.mail}</td>
				<td>${cust.pswd}</td>
				<td>${cust.pin}</td>
				<td>${cust.city}</td>
				<td><input type="button" onclick="deleterow('${cust.mail}')" value="Delete"> </td>
				<td><input type="button" onclick="editrow('${cust.mail}')" value="Edit"> </td>
			</tr>
		</core:forEach>
	</table>


	<%-- <core:forEach items="${selecteddetails}" var="doit">${doit.name} || ${doit.phon}</br></core:forEach> --%>
</form>


	<a href="${pageContext.request.contextPath}/jsps/Register.jsp">go
		back to register</a>
</body>
</html>