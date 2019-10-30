<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h2>게시글 수정</h2>
	<hr>
	<form action="update.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value=${v.num }>
	제목: <input type="text" name="title" value=${v.title }><br>
	내용: <br><textarea rows="10" cols="60" name="content">${v.content}</textarea><br>
	비밀번호: <input type="password" name="pwd"><br>
	<img alt="${v.fname }" src="photo/${v.fname }">
	파일: <input type="file"	name="fname"><br>
	<input type="submit" value="수정">
	</form>

</body>
</html>