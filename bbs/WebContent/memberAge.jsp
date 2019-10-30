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
		String ag = request.getParameter("age");//memberList의 변수와 같아야함
		int age = Integer.parseInt(ag);
	%>
	선택한 팀원의 나이는 <%= age %>살입니다.
	<hr>
</body>
</html>