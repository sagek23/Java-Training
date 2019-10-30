<%@page import="com.bit.vo.Person"%>
<%@page import="java.util.ArrayList"%>
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
	session.setAttribute("title", "안녕");
	session.setAttribute("year",2019);

	ArrayList<String> list = new ArrayList<String>();
	list.add("고양이");
	list.add("사자");
	list.add("호랑이");
	list.add("재규어");
	session.setAttribute("list",list);
%>
세션에 값 설정
<hr>
<a href = "getSession.jsp">세션</a>
</body>
</html>