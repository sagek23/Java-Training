<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String path = request.getRealPath("upload");
		request.setCharacterEncoding("UTF-8");
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		
		String name = multi.getParameter("name");
		String fname = multi.getFilesystemName("fname");
	%>
	이름:<%=name %><br>
	사진:<%=fname %><br>
</body>
</html>