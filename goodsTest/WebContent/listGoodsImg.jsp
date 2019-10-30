<%@page import="java.util.ArrayList"%>
<%@page import="goods.GoodsDao"%>
<%@page import="goods.GoodsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
display:block;
width:100px;
height:100px;
}
</style>
</head>
<body>
	<%
	GoodsDao dao = new GoodsDao();

	ArrayList<GoodsVo> list = dao.listAll();
	for(GoodsVo v:list)
	{
		%>
		<img alt="<%= v.getFname()%>"src="upload/<%= v.getFname()%>">
		<%
	}
	
	%>
</body>
</html>