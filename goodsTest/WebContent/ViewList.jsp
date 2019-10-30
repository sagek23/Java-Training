<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="goods.GoodsVo"%>
<%@page import="java.util.Date"%>
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
	
	<h2>상품리스트</h2>
	<table border ="1" width="80%">
		<%
			GoodsDao dao = new GoodsDao();
			GoodsVo vo = new GoodsVo();
			ArrayList<GoodsVo> list = dao.listAll();
			ArrayList<String> plist = new ArrayList<String>();
			plist.add("번호");
			plist.add("상품명");
			plist.add("가격");
			plist.add("수량");
			
		%>
		<tr>
		<% for(int i=0;i<plist.size();i++)
		{%>
			<td><%= plist.get(i)%></td>
		<%	}%>
		</tr>
		<tr>
			<%
			for(GoodsVo v:list)
			{
			%>
				<td><%= v.getNo() %></td>
				<td><a href ="pdetail.jsp?no=<%= v.getNo()%>"><%= v.getName() %></td>
				<td><%= v.getPrice() %></td>
				<td><%= v.getQty() %></td>
		</tr>
			<%
			}
			%>
		
	</table>
	<br>
	<a href="input.html">새로 등록</a>

</body>
</html>