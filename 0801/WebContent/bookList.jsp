<%@page import="book.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<hr>
	<%
		ArrayList<BookVo> list = (ArrayList<BookVo>)request.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>가격</td>
		</tr>
		<%
			for(BookVo v: list)
			{
				%>
				<tr>
				<td><%=v.getBookid() %></td>
				<td><%=v.getBookname() %></td>
				<td><%=v.getPublisher() %></td>
				<td><%=v.getPrice() %></td>
				</tr>
				<%	
			}
		%>
	</table>
</body>
</html>