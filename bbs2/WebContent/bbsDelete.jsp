<%@page import="bbs.BbsVo"%>
<%@page import="bbs.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�Խù� ����</h2>
	<hr>
	<% 
		int num = Integer.parseInt(request.getParameter("num"));
		BbsDao dao = new BbsDao();
		BbsVo v = dao.getBbs(num);
	%>
	<form action="deleteBbs.jsp" method="post">
	<input type="hidden" name= "num" value="<%= v.getNum()%>">
	����:<input type="text" name="title" size="15" maxlength="30" value="<%=v.getTitle()%>"><br>
	�ۼ���: <input type="text" name="id" value="<%=v.getWriter()%>"><br>
	��ȣ: <input type="password" name="pwd" ><br>
	����: <br>
	<textarea rows="10" cols="80" name="contents" ><%=v.getContent()%></textarea><br>
	<input type="submit" value="����">
	</form>
</body>
</html>