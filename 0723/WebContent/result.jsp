
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과화면</h2>
	<%
		request.setCharacterEncoding("UTF-8"); //값을 받기전인 맨 첫줄에 써야함
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String []hobby = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String bday = request.getParameter("bday");
		String intro = request.getParameter("intro");

	%>
	아이디: <%= id %><br>
	비밀번호: <%= pwd %><br>
	이름: <%= name %><br>
	취미: <%
		String hb_str ="없음";
		if(hobby!=null)
		{
			/*
			for(String str:hobby)
			{
				hb_str += str+",";
			}
			*/
			hb_str=Arrays.toString(hobby);//array를 문자열로
		//	hb_str = hb_str.substring(1, hb_str, )
		}
	%>
	<%= hb_str %><br>
	직업: <%= job %><br>
	성별: <%= gender %><br>
	나이: <%= age %><br>
	이메일: <%= email %><br>
	전화번호: <%= tel %><br>
	생일: <%= bday %><br>
	자기소개: <br><%= intro %><br>
</body>
</html>