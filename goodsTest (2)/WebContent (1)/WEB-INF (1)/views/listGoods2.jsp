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
	$(function () {
		setTimeout(function() {
			$("msg").hide();
		},3000);
	$("#op").hide();
	
	var keyword = $("#h_keyword").val();
	if(keyword != '')
	{
		$("#keyfield").val( $("#h_keyfield").val() );
		$("#keyword").val( $("#h_keyword").val() );
		$("#oper").val( $("#h_oper").val() );
		var v = $("#h_keyfield").val();
		if(v == 'price')
		{
			$("#op").show();
		}
		else
		{
			$("#op").hide();
		}
		
	}
		
	$("#keyfield").change(function(){
		var v = $(this).val();
		if(v == 'price')
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
<style type="text/css">
div{
	width: 200px;
	height: 200px;
	border:  1px solid red;
	display: inline;
	float: left;
	margin: 10px;
}
</style>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<span id="msg"> <font color="red">${msg }</font></span>
	<a href="insertGoods.do">상품등록</a>
	<table border="1">
		<tr>
			<td><a href="lgoods.do?sortName=no">상품번호</a></td>
			<td><a href="lgoods.do?sortName=name">상품명</a></td>
			<td><a href="lgoods.do?sortName=price">가격</a></td>
		</tr>
		<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="dgoods.do?no=${g.no }">${g.name }</a></td>
			<td>${g.price }</td>
		</tr>
		</c:forEach>
	</table>
	<form action="lgoods.do">
	<select name="keyfield" id="keyfield">
		<option value="name">상품명</option>
		<option value="price">가격</option>
	</select>
	<span id="op">
		<select id="oper" name="oper">
			<option value="=">=</option>
			<option value=">=">>=</option>
			<option value="<="><=</option>
		</select>
	</span>
	<input type="text" name="keyword" placeholder="검색어를 입력하세요" id="keyword"/>
	<input type="submit" value="검색"/>
	</form>
	<input type="hidden" id="h_oper" value="${oper }">
	<input type="hidden" id="h_keyfield" value="${keyfield }">
	<input type="hidden" id="h_keyword" value="${keyword }">
</body>
</html>