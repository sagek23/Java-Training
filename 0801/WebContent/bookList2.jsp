<%@page import="book.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
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
	<h2>${title }</h2>
	<hr>
		<table border="1">
			<tr>
				<td>도서번호</td>
				<td>도서명</td>
				<td>출판사</td>
				<td>가격</td>
			</tr>
			<c:forEach var="v" items="${list }"> <!-- v는 BookVo. items에는 Controller가 상태유지 시켜준 배열입력 -->
				<tr>
				<td>${v.bookid }</td>
				<td>${v.bookname }</td>
				<td>${v.publisher }</td>
				<td>${v.price }</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>