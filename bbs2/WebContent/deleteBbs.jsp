<%@page import="bbs.BbsDao"%>
<%@page import="bbs.BbsVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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