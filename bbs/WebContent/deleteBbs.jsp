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
		String pwd= request.getParameter("pwd");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BbsVo v = new BbsVo();
		BbsDao dao = new BbsDao();
		
		v.setNum(num);
		v.setPwd(pwd);
		
		int re = dao.deleteBbs(v);
		if(re==1)
		{
			response.sendRedirect("Bbs.jsp");
		}
		
	%>
	
</body>
</html>