<%@page import="bbs.BbsDao"%>
<%@page import="bbs.BbsVo"%>
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
		String pwd = request.getParameter("pwd");
		String contents = request.getParameter("contents");
		int num = Integer.parseInt(request.getParameter("num"));
	%>
	<%
		BbsVo v = new BbsVo();
		BbsDao dao = new BbsDao();
		v.setNum(num);
		v.setTitle(title);
		v.setContent(contents);
		v.setPwd(pwd);
		
		int re = dao.updateCon(v);
		if(re==1)
		{
			response.sendRedirect("Bbs.jsp"); //등록후 Bbs.jsp페이지로 보내짐
			System.out.println("수정성공");
		}
	%>
</body>
</html>