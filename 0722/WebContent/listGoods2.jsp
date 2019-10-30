<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	ul{
		list-style: none;
	}
	div{
		border: 1px red solid;
		width: 200px;
		margin: 20px;
}
</style>
</head>
<body>
	<h2>상품목록</h2>
	<ul>
		<%
			String sql = "select name, price from goods";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##madang", "madang");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				%>
					<li>
						<div>
						<%= rs.getString(1) %><br>
						<%= rs.getString(2) %>	
						</div>			
					</li>
				<%
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		%>
	</ul>
	
</body>
</html>