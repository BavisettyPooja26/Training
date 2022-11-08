<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,java.util.*,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- scriptlet syntax;doesnt support func declaration -->
<%
	int num=10;
	String time = Calendar.getInstance().getTime().toLocaleString();
	out.println("Welcome to home page"+time);
%>
<!-- declarative syntax support func declaration-->
<%! String name = "Indian Banking Website"; %>
<!-- expression syntax = out.println; call func and variable -->
<%= name %>





</body>
</html>