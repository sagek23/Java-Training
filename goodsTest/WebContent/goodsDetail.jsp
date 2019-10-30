<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${v.name }</h2>
	<table border="1" width="100%">
	<tr>
		<td>상품번호</td>	
		<td>상품명</td>	
		<td>가격</td>	
		<td>수량</td>	
		<td>이미지</td>	
	</tr>
	<tr>
		<td>${v.no }</td>
		<td>${v.name }</td>
		<td>${v.price }</td>
		<td>${v.qty }</td>
		<td><img alt="${v.fname }" src="upload/${v.fname }"> </td>
	</tr>
	</table>
</body>
</html>