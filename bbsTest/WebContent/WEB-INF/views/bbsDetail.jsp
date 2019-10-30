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
글제목:${v.title }<br>
작성자:${v.writer }<br>
작성일:${v.credate }<br>
조회수:${v.views }<br>
내용:<br>
<textarea rows="10" cols="20" readonly="readonly">${v.content }</textarea><br>

</body>
</html>