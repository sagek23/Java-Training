<%@page import="java.util.GregorianCalendar"%>
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
	Calendar today = Calendar.getInstance();
	int year = today.get(Calendar.YEAR);
	int month = today.get(Calendar.MONTH);

	int last = today.getActualMaximum(Calendar.DAY_OF_MONTH);
	 
	if(request.getParameter("year")!=null)
	{
		year = Integer.parseInt(request.getParameter("year"));
	
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
	Calendar startDay = new GregorianCalendar();
	startDay.set(Calendar.YEAR, year);
	startDay.set(Calendar.MONTH, month);
	startDay.set(Calendar.DATE, 1);
	int blank = startDay.get(Calendar.DAY_OF_WEEK);

%>

<h2><%= year %>년 <%=month+1 %>월</h2>
<hr>

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
	for(int j=1;j<blank;j++)
	{
		%>
		<td></td>
		<%
		
	}

	for(int i=1;i<=last;i++)
	{
		%>
		<td> <%= i %>   </td>
		<%
		if( (i+blank-1) % 7 == 0)
		{
			%>
			</tr><tr>
			<%
		}
	}
%>
</tr>
</table>
<a href = "calendar2.jsp?year<%=year %>&month=<%=month+1%>">다음달</a>
</body>
</html>
l>