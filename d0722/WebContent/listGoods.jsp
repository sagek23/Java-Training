<%@page import="java.util.Vector"%>
<%@page import="goods.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="goods.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
ul{
	list-style: none;
}
div{
	border: 1px solid;
	width: 200px;
	margin: 20px;
	padding: 10px;
}
</style>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<ul>
		<%
			GoodsDao dao = new GoodsDao();
			ArrayList<GoodsVo> list =  dao.listAll();
			for(GoodsVo g:list)
			{
				%>
		
					<div>	
						<img alt="<%= g.getFname()%>" src="img/<%= g.getFname()%>" width="150" height="70"><br>
						<%= g.getName() %> <br>
					<strike>	(<%= g.getPrice()%>)</strike>
						<font color =red><%= g.getPrice()*0.9%></font><br>	
					</div>
				<%
			}
		%>
		
	
		
		
	</ul>
</body>
</html>