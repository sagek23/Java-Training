<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>${title }</h2>
	<hr>
	<table border="1" width="80%" class="table table-striped">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
			<!--  <td>파일</td>-->
		</tr>
		<c:forEach var="v" items="${list }">
		<tr>
			<td>${v.num }</td>
			<td><a href="detail.do?num=${v.num }" >${v.title}</a></td>
			<td>${v.writer }</td>
			<td>${v.views}</td>
			<td>${v.creDate }</td>
			<!--  <td><img alt="${v.fname }" src="photo/${v.fname }"></td> -->
		</tr>
		</c:forEach>
	</table>
	<a href="insertBbs.do">새글쓰기</a>
</body>
</html>