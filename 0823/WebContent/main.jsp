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
<%
/*
	if(session.getAttribute("member")==null)
	{
		response.sendRedirect("login.jsp");
	}
*/
%>	
	<c:if test="${empty member }">
	<c:redirect> url="login.jsp"</c:redirect>
	</c:if>
	<h2>Welcome</h2>
	<hr>
<a href="service1.jsp">서비스1</a><br>
<a href="service2.jsp">서비스2</a><br>
<a href="service3.jsp">서비스3</a><br>
</body>
</html>