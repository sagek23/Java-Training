<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="helloServelet" method="get">
	<input type="submit" value="get방식의 요청">
	</form>
	<form action="helloServelet" method="post">
	<input type="submit" value="post방식의 요청">
	</form>
	<hr>
	<a href="manager.do">aa</a>
</body>
</html>