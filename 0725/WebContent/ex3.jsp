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
	//이름을 출력해봅니다.
	String name = "홍길동";
	out.print("<font color='red'>이름:</font>"+name+"<br>");
	out.print("나이:20<br>");
	//out.print("주소: 서울시 마포구 신수동<br>");
%>
</body>
</html>