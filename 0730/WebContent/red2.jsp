<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
	red입니다
	<jsp:forward page="yellow2.jsp">
		<jsp:param value="hello" name="title"/>
		<jsp:param value="2019" name="year"/>
	</jsp:forward>
</body>
</html>