<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.id{
color:red;
}
.name{
color:blue;
}
</style>
</head>
<body>
	<%
		String a="";
		String b="";
		String sql = "select id, name from member";
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##madang", "madang");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			a= rs.getString(1);
			b = rs.getString(2);
		%>
		<p class="id"><%=a %></p>
		<p class="name"><%=b %></p>
		<% 
		}
		rs.close();
		stmt.close();
		conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	%>
	
	
</body>
</html>