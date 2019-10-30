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
	request.setAttribute("name","홍길동");
	session.setAttribute("age",20);
	application.setAttribute("addr","신수동");
%>
값을 설정하였습니다<br>
<a href="get.jsp">연결</a>
</body>
</html>