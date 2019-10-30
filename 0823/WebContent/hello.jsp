<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>

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
//쿠키를 이용하여 마지막 방문한 날짜와 시간을 읽어오기
	
	String lastVisit="";

	Cookie []cookies = request.getCookies();
	if(cookies!=null)
	{
		for(Cookie c:cookies)
		{
			if(c.getName().equals("lastVisit"))
			{
				lastVisit = URLDecoder.decode(c.getValue(), "UTF-8");
			}
		}
	}
	
	if(lastVisit.equals(""))
	{
		%>
			처음방문입니다
		<% 
	}
	else
	{
		%>
		마지막 방문일은  <%=lastVisit %>입니다.
		<% 
	}
	Date today = new Date();
	int year = today.getYear()+1900;
	int month = today.getMonth()+1;
	int day = today.getDate();
	int hour = today.getHours();
	int minute = today.getMinutes();
	int seconds = today.getSeconds();
	//lastVisit = year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+seconds+":";
	lastVisit = year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+seconds+"초";
	lastVisit = URLEncoder.encode(lastVisit, "UTF-8");
	Cookie cookie = new Cookie("lastVisit", lastVisit);
	response.addCookie(cookie);
%>

</body>
</html>