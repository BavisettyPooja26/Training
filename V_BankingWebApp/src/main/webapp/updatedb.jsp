<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update db Record</title>
</head>
<body>
<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver" 
	url="jdbc:oracle:thin:127.0.0.1:1521:xe" user="nriems" password="nriems" />
	<sql:update dataSource="${dbsource}" var="count">
		UPDATE tblservice SET servicename=?, serviceamt= ? WHERE serviceid='${param.txtid}'
		<sql:param value="${param.txtname}"></sql:param>
		<sql:param value="${param.txtamt}"></sql:param>
	</sql:update>
	<c:if test="${count>=1}">
		<font size="5" color="green">
			Record got updated
		</font>
		
		<a href="service.jsp">Go to Service</a>
	</c:if>
</body>
</html>