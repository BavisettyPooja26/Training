<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.sql.*,java.util.*,java.io.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Record</title>
</head>
<body>

<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver" 
	url="jdbc:oracle:thin:127.0.0.1:1521:xe" user="nriems" password="nriems" />
	
<sql:query dataSource="${dbsoucre}" var="result">
	select * from tblservice
</sql:query>

<table border="1" width="40%">
	<caption>Loan Service Details</caption>
	<tr>
	<th>Sid</th>
	<th>Name</th>
	<th>Amount</th>
	<th colspan="2">Action</th>
	</tr>
	<!-- rows: current ref --> 
	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td>
				<c:out value="${row.serviceid}"></c:out>
			</td>
			<td>
				<c:out value="${row.servicename }"></c:out>
			</td>
			<td>
				<c:out value="${row.serviceamt}"></c:out>
			</td>
			<!-- url dynamically; sending values from page to another using query string  -->
			<td>
			<a href="update.jsp?sid=<c:out value="${row.serviceid }"/>">Update</a>
			</td>
			<td>
			<a href="delete.jsp?sid=<c:out value="${row.serviceid }"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>


<!-- Jsp has three types of directives(pre processing instruction)
These are:
1.page
2.taglib
3.include
 -->