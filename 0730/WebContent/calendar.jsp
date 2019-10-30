<%@page import="java.util.Calendar"%>
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
	int i;
	Date today= new Date();
	//int blank = 4;
	int blank = 1;
	int year = today.getYear();
	int month = today.getMonth();
	int date = 1;
	if(request.getParameter("year")!=null)
	{
		year	= Integer.parseInt(request.getParameter("year"));

	}
	if(request.getParameter("month")!=null)
	{
		month	= Integer.parseInt(request.getParameter("month"));

	}
	if(month==12)
	{
		month=0;
		year+=1;
	
	}
	
	int []lastday = {31,28,31,30,31,30,31,31,30,31,30,31};
	Date day = new Date(year, month, date);
	int days = day.getDay();//시작일까지 공백을 주는 것
	int last = lastday[month];
	%>
	<h2><%= year+1900%>년  <%= month+1%>월</h2>
	<table border="1">
		<tr>
			<td>일</td>
			<td>월</td>
			<td>화</td>
			<td>수</td>
			<td>목</td>
			<td>금</td>
			<td>토</td>
		</tr>
		<tr>
		<% 
		for(int j=1;j<=days;j++)
		{%>
			<td></td>
		<%}
		for(i=1;i<=last;i++)
		{%>
			<td><%=i %></td>
		<%
			if((i+days)%7==0)
			{%>
				</tr><tr>
			<% 
			}
		}
	%>
	</tr>
	</table>
<a href = "calendar.jsp?year=<%=year %>&month=<%=month+1%>">다음달</a>
</body>
</html>