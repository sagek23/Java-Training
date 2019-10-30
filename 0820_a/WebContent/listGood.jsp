<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#op").hide();

	$("#search").val($("#colName").val());
	var colName = $("#search").val();
	if(colName == "price" || colName =="qty")	
	{
		$("#op").show();	
	}
	
	$("#search").change(function(){
		var colName = $(this).val();
		if(colName == "price" || colName =="qty")	
		{
			$("#op").show();	
		}
		else
		{
			$("#op").hide();
		}
	});
});
</script>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<form action="lgoods.do" method="post">
	<select name="search" id="search">
	<option value="no">상품번호</option>
	<option value="name">상품명</option>
	<option value="price">상품가격</option>
	<option value="qty">상품수량</option>
	<option value="fname">상품파일</option>
	</select>
	<span id="op">
		<select name="oper" id="oper">
			<option value=">=">>=</option>
			<option value="<="><=</option>
			<option value="=">=</option>
		</select>
	</span>
	<input type="text" placeholder="검색어를 입력하시오" name="keyword" value="${keyword }" >
		<input type="submit" value="검색">
	</form>
	<table border="1" width="100%">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품가격</td>
			<td>상품수량</td>
			<td>상품파일</td>
		</tr>
		<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td>${g.name }</td>
			<td>${g.price }</td>
			<td>${g.qty }</td>
			<td><img alt="${g.fname }" src = "upload/${g.fname }"></td>
			
		</tr>
		</c:forEach>
	</table>
		<input id="colName" type="hidden" id="search" value="${search }">
		<input id="operator" type="hidden" id="operator" value="${operator }">
</body>
</html>