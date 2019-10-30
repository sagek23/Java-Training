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
	<h2>게시글등록 성공</h2>
	<c:if test="${re==1 }">
		<c:redirect url="lbbs.do"></c:redirect>
	</c:if>
	
	<c:if test="${re!=1 }">
		게시글등록 실패
	</c:if>
</body>
</html>