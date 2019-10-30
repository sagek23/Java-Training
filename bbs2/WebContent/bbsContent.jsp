<%@page import="bbs.BbsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bbs.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		String ag = request.getParameter("num");
		int num = Integer.parseInt(ag);
		BbsDao dao = new  BbsDao();
		BbsVo b = dao.getBbs(num);
	%>
	<h2>게시물 상세</h2>
	<hr>
	글번호: <%= b.getNum() %><br>
	글제목: <%= b.getTitle() %><br>
	작성자: <%= b.getWriter() %><br>
	내용: <br>
	<textarea rows="10" cols="80" readonly ="readonly"><%= b.getContent() %></textarea><br>
	조회수: <%= b.getViews() %><br>
	작성일: <%= b.getCreDate() %><br>
	<a href="updateBbs.jsp?num=<%= b.getNum() %>">수정</a>
	<a href="bbsDelete.jsp?num=<%= b.getNum() %>">삭제</a>
	<!--  ?num=<%= b.getNum() %> query string 공백이 들어가면 안된다.-->
</body>
</html>