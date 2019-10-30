<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBook.do" method="post">
		도서명: <input type="text" name="bookname"><br>
		출판사: <input type="text" name="publisher"><br>
		가격: <input type="number" name="price"><br>
		<input type="submit" value="등록">
		<input type="submit" value="취소">
	</form>
</body>
</html>