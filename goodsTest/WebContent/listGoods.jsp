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
	<h2>상품 목록</h2>
	<hr>
	<table border="1" width="100%">
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td>이미지</td>
	</tr>
	<c:forEach var="g" items="${list }">
	<tr>
		<td>${g.no }</td>
		<td><a href="gdetail.do?no=${g.no}">${g.name }</a></td>
		<td>${g.price }</td>
		<td>${g.qty }</td>
		<td>${g.fname }</td>
	</tr>
	</c:forEach>
	<a href="igoods.do">상품 등록</a>
</body>
</html>