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
	<h2>도서목록</h2>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
		<!--  	<td>출판사</td>-->
		<!-- 	<td>도서가격</td> -->
		</tr>
		<c:forEach var = "b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td><a href="bdetail.do?bookid=${b.bookid }">${b.bookname }</a></td>
			<!-- 	<td>${b.publisher }</td>-->
			<!-- 	<td>${b.price }</td>-->
			</tr>
		</c:forEach>
	</table>
</body>
</html>