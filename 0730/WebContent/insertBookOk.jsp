<%@page import="book.BookDao"%>
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
		request.setCharacterEncoding("UTF-8");
		BookDao dao = new BookDao();	
	%>
	<jsp:useBean id="b" class="book.BookVo"/>
	<jsp:setProperty property="*" name="b"/>
	<%
		int re = dao.insertBook(b);
	if(re > 0)
	{
		out.print("성공");
	}
	else
	{
		out.print("실패");
	}
	%>
</body>
</html>