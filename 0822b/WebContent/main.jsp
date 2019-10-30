<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
	<tr>
		<td colspan="2">
		<jsp:include page="top.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td>
		<jsp:include page="left.jsp"></jsp:include>
		</td>
		<td>
		<jsp:include page="${viewPage }"></jsp:include>
		</td>
	</tr>
	</table>
</body>
</html>