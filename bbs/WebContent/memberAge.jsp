<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		String ag = request.getParameter("age");//memberList�� ������ ���ƾ���
		int age = Integer.parseInt(ag);
	%>
	������ ������ ���̴� <%= age %>���Դϴ�.
	<hr>
</body>
</html>