<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delete.do" method="post">
	<input type="hidden" name="num" value=${v.num }>
	암호: <input type="password"	name="pwd">
	<input type="submit" value="삭제">
	</form>
</body>
</html>