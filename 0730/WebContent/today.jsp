<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
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
		Date today = new Date();
	%>
	오늘날짜 <%=today %>
	<%
		ArrayList list = new ArrayList();
		list.add("홍길동");
		list.add("강감찬");
	%>
	<%=list %>
	<hr>
</body>
</html>