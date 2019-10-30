<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부하직원 검색</h2>
	<hr>
	<form action="listEmp.do" method="post">
		관리자명 : <input type="text" name="name">
		<input type="submit" value="검색">
	</form>
	<hr>
	
	<table border="1">
		
		<c:forEach var="e" items="${list }">
			<tr>
				<td>${e.eno }</td>
				<td>${e.ename }</td>
				<td>${e.dname }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>