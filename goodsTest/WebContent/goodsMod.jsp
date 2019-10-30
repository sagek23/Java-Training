<%@page import="goods.GoodsDao"%>
<%@page import="goods.GoodsVo"%>
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
	<h2>상품수정</h2>
	<form action="ModGoods.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value=<%=vo.getNo() %>>
	상품명:<input type="text" name="name" value=<%=vo.getName() %>><br>
	가격:<input type="number" name="price" min="1000" value=<%=vo.getPrice() %>><br>
	수량:<input type="number" name="qty" min="1" max="1000" value=<%=vo.getQty() %>><br>
	상품사진:
	<img src="upload/<%= vo.getFname() %>">
	<input type="file" name="fname" value=<%=vo.getFname() %>><br>
	<input type="submit" value="수정">
	</form>
</body>
</html>