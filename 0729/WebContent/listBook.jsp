<%@page import="java.util.ArrayList"%>
<%@page import="Book.BookVo"%>
<%@page import="Book.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.schema{
font-weight: bold;
color:Blue;
}
</style>
</head>
<body>
	<table border="1" width="80%">
		<tr>
			<td class="schema">도서번호</td>
			<td class="schema">도서명</td>
			<td class="schema">출판사</td>
			<td class="schema">가격</td>
		</tr>	
 	<%
 		BookDao dao = new BookDao();
 		BookVo vo = new BookVo();
 		ArrayList<BookVo> list = dao.selectAll();
 		for(BookVo v:list)
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