<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품등록</h2>
	<hr>
	<form action="igoodsOk.do" method="post" enctype="multipart/form-data"><br>
		상품명:<input type="text" name="name"><br>
		가격:<input type="number" name="price"><br>
		수량:<input type="number" name="qty"><br>
		상품사진:<input type="file" name="fname"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>