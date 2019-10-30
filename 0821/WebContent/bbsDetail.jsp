<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${v.title }</h2>
	<hr>
	글번호 : ${v.num }<br>
	글제목 : ${v.title }<br>
	작성자 : ${v.writer }<br>
	글내용 : <br>
	<textarea rows="10" cols="80" readonly="readonly">${v.content }</textarea><br>
	조회수 : ${v.views }<br>
	등록일 : ${v.credate }<br>
	이미지:<img alt="${v.fname }" src="upload/${v.fname }">
	
</body>
</html>