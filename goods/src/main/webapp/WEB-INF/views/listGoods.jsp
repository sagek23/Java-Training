<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<table border="1" width="80%">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
		</tr>
		<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="detail.do?no=${g.no }">${g.name }</a></td>
			<td>${g.price }</td>
		</tr>
	</c:forEach>
	</table>
	<a href="insert.do">상품등록</a>
</body>
</html>