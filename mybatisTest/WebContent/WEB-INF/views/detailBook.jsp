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
	<h2>${b.bookname }</h2>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>도서가격</td>
		</tr>

		<tr>
			<td>${b.bookid }</td>
			<td>${b.bookname}</td>
			<td>${b.publisher}</td>
			<td>${b.price}</td>
		</tr>
	</table>
	<a href="ubook.do?bookid=${b.bookid }">도서수정</a>
	<a href="delBook.do?bookid=${b.bookid }">도서삭제</a>
	
</body>
</html>