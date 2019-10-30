<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello<br>
	<%
		String ip = request.getRemoteAddr();
		String s1 = request.getRequestURI();
		StringBuffer s2 = request.getRequestURL();
		String cmd = s1.substring(s1.lastIndexOf("/")+1);
		int q = s1.lastIndexOf("/");
	%>
	ip주소: <%=ip %><br>
	<%=s1 %><br> <%=s2 %><br>
	<%=cmd %><br>
	<%=q %>
</body>
</html>