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
		String name =  "홍길동";
	%>
	이름: <%= name %> <br>
	
	<%@ include file = "age.jsp" %>
	<hr>
	<%
		String addr =  "서울시 마포구 신수동";
	%>
	주소 : <%= addr %>
</body>
</html>