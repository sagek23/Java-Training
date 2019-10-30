<%@page import="java.util.ArrayList"%>
<%@page import="bbs.BbsDao"%>
<%@page import="bbs.BbsVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<h2>BBS</h2>
	<table border="1">
	<% 
		BbsDao dao = new BbsDao();
		ArrayList<BbsVo> list = dao.listAll();
		ArrayList<String> tlist = new ArrayList<String>();


		
		%>
		<tr>
		<% for(int i=0;i<tlist.size();i++)
		{%>
			<td><%= tlist.get(i)%></td>
		<%	}%>
		</tr>
		<tr>
		<% 
	
		for(BbsVo g:list)
		{
		%>		
				<td><%=g.getNum() %></td>
				<td><a href ="bbsContent.jsp?num=<%= g.getNum()%>"><%=g.getTitle() %></a></td>
				<td><%=g.getWriter() %></td>
				<td><%=g.getCreDate() %></td>
		</tr>
	<%
		}%>
		
	</table>
	<br>
	<a href="bbsNew.html">새글쓰기</a>
</body>
</html>