<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	<form action="result.jsp" method="post">
	이름: <input type="text" name="name"><br>
	나이: <input type="number" name="age"><br>
	<input type="submit" value="등록"><br>
	* PS: 나이는 숫자로 입력하시오.
	</form>
</body>
</html>