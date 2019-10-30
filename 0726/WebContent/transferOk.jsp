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
		request.setCharacterEncoding("UTF-8");
		int  from = Integer.parseInt(request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##madang", "madang");
		conn.setAutoCommit(false);
		
		int re=-1;
		String sql="update bank set balance = balance - ? where no=?";
		String sql2="update bank set balance = balance + ? where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt.setInt(1, amount);
		pstmt.setInt(2, from);		
		pstmt2.setInt(1, amount);
		pstmt2.setInt(2, to);		
		
		re = pstmt.executeUpdate();
		int re2 = pstmt2.executeUpdate();
		
		if(re==1&&re2==1)
		{
			conn.commit();
		}
		else
		{
			conn.rollback();
		}
		pstmt.close();
		pstmt2.close();
		conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	%>
</body>
</html>