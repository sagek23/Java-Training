<%@page import="javax.swing.JOptionPane"%>
<%@page import="bbs.BbsVo"%>
<%@page import="bbs.BbsDao"%>
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
		String title = request.getParameter("title");
		String writer = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String contents = request.getParameter("contents");
	%>
	제목: <%= title %><br>
	작성자: <%= writer %><br>
	암호: <%= pwd %><br>
	내용: <br><%= contents %><br>
	
	<%
		BbsDao dao = new BbsDao();
		BbsVo vo = new BbsVo();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setPwd(pwd);
		vo.setContent(contents);
		int re = dao.insertNew(vo);
		if(re==1)
		{
			response.sendRedirect("Bbs.jsp"); //등록후 Bbs.jsp페이지로 보내짐
		}
	%>
	 <a href="Bbs.jsp">게시물 목록</a>
</body>
</html>