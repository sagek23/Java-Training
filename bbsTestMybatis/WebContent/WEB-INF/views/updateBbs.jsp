<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>게시물수정</h2>
	<hr>
	<form action="updateBbs.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${b.num }"><!-- 원글의 글번호. 새글이면 0 -->
	제목:<input type="text" name="title" value="${b.title }"><br>
	작성자:<input type="text" name="writer" value="${b.writer }" readonly="readonly"><br>
	암호:<input type="password" name="pwd"><br>
	내용:
	<textarea rows="10" cols="20" name="content" value="${b.content }"></textarea><br>
	<input type="hidden" name="fname" value="${b.fname }"><br>
	<img alt="${b.fname }" src="files/${b.fname }" width="50" height="50"><br>
	파일: <input type="file" name="upload">
	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
</body>
</html>