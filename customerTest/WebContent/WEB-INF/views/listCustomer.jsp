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
	<h2>회원목록</h2>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>회원번호</td>
			<td>회원이름</td>
			<td>회원주소</td>
			<td>전화번호</td>
		</tr>
		<c:forEach var="c" items="${list }">
		<tr>
			<td>${c.custid }</td>
			<td>${c.name }</td>
			<td>${c.address }</td>
			<td>${c.phone }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>