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
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("name");
	int age = Integer.parseInt( request.getParameter("age") );
	
%>

������� �Է������� ������ �����ϴ�.<br>
�̸� : <%= name %><br>
���� : <%= age %><br>
</body>
</html>











