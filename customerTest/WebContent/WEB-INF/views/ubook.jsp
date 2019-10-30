<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서정보수정</h2>
	<hr>
	<form action="ubook.do" method="post" value="${v.bookid }">
	<input type="hidden" name="bookid">
	도서명:<input type="text" name="bookname"><br>
	출판사:<input type="text" name="publisher"><br>
	도서가격:<input type="text" name="price"><br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
</body>
</html>