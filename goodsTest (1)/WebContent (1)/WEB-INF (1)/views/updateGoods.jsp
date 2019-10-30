<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품수정</h2>
	<hr>
	<form action="updateGoods.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${g.no }"><br>
	상품명:<input type="text" name="name" value="${g.name }"><br>
	가격:<input type="text" name="price" value="${g.price}"><br>
	수량:<input type="text" name="qty" value="${g.qty }"><br>
	<img src="img/${g.fname }" width="50" height="50"><br>
	<input type="text" name="fname" value="${g.fname }">
	상품사진 : <input type="file" name="upload"><br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
</body>
</html>