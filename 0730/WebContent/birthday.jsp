<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int year = 1991-1900;
		int month = 11-1;
		int date = 23;
		Date birth = new Date(year, month, date); 
		int yoil = birth.getDay();
	%>
	<%=yoil %>
</body>
</html>