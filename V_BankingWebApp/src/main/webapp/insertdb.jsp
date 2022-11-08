<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Record</title>
</head>
<body>
	<c:if test="${empty param.txtid or empty param.txtname or empty param.txtamt }">
		<!-- equivalent to requst.getParameter("txtsid")!= null param is predefined object of expression language -->
		<c:redirect url="service.jsp">
		<!-- sending messages with rediection -->
		<c:param name="errorMsg" value="Sid and sname and samt are required"></c:param>
	</c:redirect>
	</c:if>
	
	<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver" 
	url="jdbc:oracle:thin:127.0.0.1:1521:xe" user="nriems" password="nriems" />
	<sql:update dataSource="${dbsource}" var="result">
		INSERT INTO tblservice(serviceid, serviename, amount) VALUES (?,?,?)
		<sql:param value="${param.txtid}"></sql:param>
		<sql:param value="${param.txtname}"></sql:param>
		<sql:param value="${param.txtamt }"></sql:param>
	</sql:update>
	
	<c:if test="${result>=1}">
		<c:redirect url="apply.jsp">
		<!-- sending messages with rediection -->
		<c:param name="successMsg" value="Record got inserted"></c:param>
	</c:redirect>
	</c:if>
	
</body>
</html>

<%-- Jsp codes are of two types:
1.Scriptless- JSTL and Expression Language(EL)
2.Scriptlet- with java
EL - ${variable} ===out.println(variable) --%>

