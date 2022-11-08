<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record Form</title>
</head>
<body>
<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver" 
	url="jdbc:oracle:thin:127.0.0.1:1521:xe" user="nriems" password="nriems" />
	<sql:query dataSource="${dbsource}" var="result">
		Select from tblservice where serviceid=?
		<sql:param value="${param.sid}"></sql:param>
	</sql:query>
	
	<center>
	<form action="updatedb.jsp" method="post">
		<table border="0" width="40%">
			<caption>Update filtered record</caption>
			<tr>
			<th>Sid</th>
			<th>Name</th>
			<th>Amount</th>
			</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td>
				<input type="hidden" value="${param.sid}"/>
				<input type="text" value="${row.servicename}"/>
				</td>	
				<td>
				<input type="text" value="${row.amount}"/>
				</td>
			</tr>
			<tr><td><input type="submit" value="Submit"/></td></tr>
		</c:forEach>
		</table>
	</form>
	</center>
</body>
</html>