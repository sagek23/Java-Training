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
	<h2>게시물 목록</h2>
	<hr>
	<table border="1" width="100%">
	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>등록일</td>
	</tr>
	<c:forEach var="b" items="${list }">
	<tr>
		<td>${b.num }</td>
		<td><a href="dbbs.do?num=${b.num }">${b.title }</a></td>
		<td>${b.writer }</td>
		<td>${b.credate }</td>
	</tr>
	</c:forEach>
	</table>
	<a href="ibbs.do">새글쓰기</a>
</body>
</html>