<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <!-- for importing -->
    <%@ page import="java.sql.*,java.util.*,java.io.*" %>
    <!-- for using jar ref -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply</title>
</head>
<body>
<center>
<form action="insertdb.jsp" method="post">
<table border="0" cellspacing="2" cellpadding="2">
	<thead>
	<tr><th colspan="2">Apply for services</th>
	</tr></thead>
	<tbody>
	<tr>
			<td><LABEL>Sid</LABEL></td>
			<td><input type="text" name="txtid"></td>
		</tr>
		<tr>
			<td><LABEL>Service name</LABEL></td>
			<td><input type="text" name="txtname"></td>
		</tr>
		<tr>
			<td><LABEL>Loan amount:</LABEL></td>
			<td><input type="text" name="txtamt"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Apply for loan"></td>
			<td><input type="submit" value="Clear"></td>
		</tr>
	</tbody>
</table>
</form>

<font color="red">
	<c:if test="${not empty param.errorMsg}">
		<c:out value="${param.errorMsg}"></c:out>
		<a href="service.jsp">Go to Service</a>
	</c:if>
</font>

<font color="green">
	<c:if test="${not empty param.successMsg}">
		<c:out value="${param.successMsg}"></c:out>
		<a href="service.jsp">Go to Service</a>
	</c:if>
</font>

</center>
</body>
</html>