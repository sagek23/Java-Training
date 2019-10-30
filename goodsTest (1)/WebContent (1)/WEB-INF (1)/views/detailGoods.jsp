<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function () {
			$("#deleteGoods").click(function () {
				re = confirm("정말 삭제하시겠습니까?")
				if(re==true)
				{
					var no = $("#no").val();
					location.href="deleteGoods.do?no="+no
				}
			})
	})
</script>
</head>
<body>
	<h2>${g.name }</h2>
	<hr>
	<input type="hidden" id="no" value="${g.no }">
	<table border="1" width="100%">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>이미지</td>
		</tr>

		<tr>
			<td>${g.no }</td>
			<td>${g.name }</td>
			<td>${g.price }</td>
			<td>${g.qty }</td>
			<td><img alt="${g.fname }" src="img/${g.fname }"></img></td>
		</tr>
	</table>
	<a href="insertGoods.do">상품등록</a>
	<a href="updateGoods.do?no=${g.no }">상품수정</a><br>
	<a href="#" id="deleteGoods">상품삭제</a>
</body>
</html>