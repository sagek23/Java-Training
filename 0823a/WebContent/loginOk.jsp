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
<c:if test="${empty id }">
	<c:redirect url="login.do"></c:redirect>	
</c:if>

<c:if test="${not empty id }">
	<c:redirect url="listBoard.do"></c:redirect>	
</c:if>
</body>
</html>