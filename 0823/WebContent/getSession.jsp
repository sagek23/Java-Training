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
<h2>세션</h2>
title : ${title }<br>
year : ${year }<br>

<c:forEach var="str" items="${list }">
	${str }<br>
</c:forEach>
</body>
</html>