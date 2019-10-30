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
	<h2>회원가입성공</h2>
	<c:if test="${re==1 }">
		<%
			response.sendRedirect("lbbs.do");
		%>
	</c:if>
	
	<c:if test="${re!=1 }">
		회원가입에 실패하였습니다.
	</c:if>
</body>
</html>