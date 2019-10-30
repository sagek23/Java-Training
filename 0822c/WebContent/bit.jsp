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
	int visitCount = 0;
	
	Cookie[] cookies =  request.getCookies();
	if(cookies!=null)
	{
		for(Cookie c:cookies)
		{
			if(c.getName().equals("visitCount"))
			{
				visitCount = Integer.parseInt(c.getValue());
			}
		}
	}	
	visitCount++;
	Cookie c = new Cookie("visitCount",""+visitCount);
	response.addCookie(c);
%>
	<%= visitCount %>번째 방문입니다.
</body>
</html>