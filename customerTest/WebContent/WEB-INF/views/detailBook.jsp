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
<c:set value="${v }" var="v" scope="session"/> 
	<h2>${v.bookname }</h2>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>도서가격</td>
		</tr>
		<tr>
			<td>${v.bookid }</td>
			<td>${v.bookname}</td>
			<td>${v.publisher}</td>
			<td>${v.price}</td>
		</tr>

	</table>
	<a href="ubook.do">도서정보수정</a>
	<a href="lbook.do">도서목록</a>
</body>
</html>