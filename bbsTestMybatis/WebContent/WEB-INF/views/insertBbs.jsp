<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물등록</h2>
	<hr>
	<form action="insertBbs.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${num }"><!-- 원글의 글번호. 새글이면 0 -->
	제목:<input type="text" name="title"><br>
	작성자:<input type="text" name="writer"><br>
	암호:<input type="password" name="pwd"><br>
	내용:
	<textarea rows="10" cols="20" name="content"></textarea><br>
	파일: <input type="file" name="upload">
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</form>
</body>
</html>