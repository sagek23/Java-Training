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
		GoodsVo vo = dao.getGoods(no);
	%>
	<h2>제품상세</h2>
	<hr>
	<table width="80%">
		<tr>
			<td>
				<img src="upload/<%= vo.getFname() %>">
			</td>
			<td>
				번호: <%=vo.getNo() %><br>
				상품명:<%=vo.getName() %><br>
				가격: <%=vo.getPrice() %><br>
				수량: <%= vo.getQty() %><br>
			</td>
	</table>
		<a href="DelGoods.jsp?no=<%= vo.getNo() %>">삭제</a>
		<a href="goodsMod.jsp?no=<%= vo.getNo() %>">수정</a>
</body>
</html>
