<%@page import="bankDao.BankDao"%>
<%@page import="org.apache.catalina.startup.SetAllPropertiesRule"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		BankDao dao = new BankDao();
		
		int  from = Integer.parseInt(request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		boolean re = dao.updBalnce(from, to, amount);
				
		if(re==true)
		{
			%>
			<font color="blue">이체성공</font>
			<% 
		}
		else
		{
			%>
			<font color="red">이체실패</font>
			<%
		}
	%>
</body>
</html>