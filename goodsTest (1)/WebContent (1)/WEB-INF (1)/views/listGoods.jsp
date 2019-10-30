<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		setTimeout(function() {
			$("msg").hide();
		},3000)
	})
</script>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<span id="msg"> <font color="red">${msg }</font></span>
	<a href="insertGoods.do">상품등록</a>
	<table border="1">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
		</tr>
		<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="dgoods.do?no=${g.no }">${g.name }</a></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>