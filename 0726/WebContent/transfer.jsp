<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="transferOk2.jsp" method="post">
		보내는 사람: <input type="number" name="from"><br>
		받는 사람: <input type="number" name="to"><br>
		금액: <input type="number" name="amount"><br>
		<input type="submit" value="이체">
	</form>
</body>
</html>