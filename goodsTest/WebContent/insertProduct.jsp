<%@page import="goods.GoodsVo"%>
<%@page import="goods.GoodsDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		
		String path = request.getRealPath("upload");
		System.out.println(path);
		request.setCharacterEncoding("UTF-8");
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		int qty = Integer.parseInt(multi.getParameter("qty"));
		String fname = multi.getOriginalFileName("fname");
	%>
	
	<%
	GoodsDao dao = new GoodsDao();
	GoodsVo vo = new GoodsVo();
	vo.setName(name);
	vo.setPrice(price);
	vo.setQty(qty);
	vo.setFname(fname);
	int re = dao.InsertGoods(vo);
	if(re==1)
	{
		response.sendRedirect("ViewList.jsp");
	}

	
	else
	{
		%>
		<font color="red">등록실패</font>
		<%
	} %>
	상품명: <%=name %><br>
	가격: <%=price %><br>
	수량: <%=qty %><br>
	상품사진: <%=fname %><br>
	
	<a href="ViewList.jsp">상품 목록</a>
</body>
</html>