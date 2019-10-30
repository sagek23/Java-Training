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
	<c:if test="${num==0}">
	<h2>새글작성</h2>
	</c:if>

	<c:if test="${num!=0}">
	<h2>답글작성</h2>
	</c:if>
	<hr>
	
	<form action="ibbsOk.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${num }">
	제목: <input type="text" name="title"><br>
	작성자: <input type="text" name="writer"><br>
	비밀번호: <input type="password" name="pwd"><br>
	내용: <textarea rows="10" cols="60" name="content"></textarea><br>
	파일: <input type="file"	name="fname"><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">

	</form>
</body>
</html>