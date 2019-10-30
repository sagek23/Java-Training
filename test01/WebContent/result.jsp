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

사용자의 입력정보는 다음과 같습니다.<br>
이름 : <%= name %><br>
나이 : <%= age %><br>
</body>
</html>











