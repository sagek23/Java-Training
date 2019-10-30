<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td>이미지</td>
	</tr>
	<tr>
		<td>${g.no }</td>
		<td>${g.name }</td>
		<td>${g.price}</td>
		<td>${g.qty}</td>
		<td><img src="img/${g.fname }"></td>
	</tr>
</table>
</body>
</html>