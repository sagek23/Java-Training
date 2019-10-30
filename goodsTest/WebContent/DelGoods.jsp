<%@page import="java.io.File"%>
<%@page import="goods.GoodsVo"%>
<%@page import="goods.GoodsDao"%>
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
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDao dao = new GoodsDao();
		
		String fname = dao.getGoods(no).getFname();
		String path = request.getRealPath("upload");
		
		
		int re = dao.deleteGoods(no);
		if(re==1)
		{
			File file = new File(path+"/"+fname);
			file.delete();
			
			response.sendRedirect("ViewList.jsp");
		}
	%>
</body>
</html>