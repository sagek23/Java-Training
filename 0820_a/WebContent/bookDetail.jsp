<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<td>${v.bookname }</td>
				<td>${v.publisher }</td>
				<td>${v.price }</td>
			</tr>

	</table>
</body>
</html>