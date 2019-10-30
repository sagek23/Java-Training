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
	<a href="ibook.do">도서등록</a>
	<table border="1" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
		</tr>
		<c:forEach items="${list}" var="b">
			<tr>
			<td>${b.bookid }</td>
			<td><a href="dbook.do?bookid=${b.bookid }">${b.bookname}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>