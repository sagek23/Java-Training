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
.goods{
	width: 200px;
	height: 200px;
	border:  1px solid black;
	display: inline;
	float: left;
	margin: 10px;
}
#line{
	display: block;
}
#page{
	display: block;
	position: absolute;
	left: 200px;
	top: 350px;
}
</style>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<span id="msg"> <font color="red">${msg }</font></span>
	<a href="insertGoods.do">상품등록</a><br>
	<div>
		<c:forEach var="g" items="${list }">
		<div class="goods">
			<img alt="${g.fname }" src="img/${g.fname }" width=150" height="150"></img><br>
			<a href="dgoods.do?no=${g.no }">${g.name }</a><br>
			가격: ${g.price }<br>
		</div>
		</c:forEach>
	</div>
	<div id="line"></div>
	<div id="page">
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
	<input type="hidden" name="search" value="1">
	<input type="submit" value="검색"/>
	</form>
	
	<c:if test="${startPage!=1 }">
			<a href='lgoods.do?pageNum=${startPage-1 }'>[이전]</a>&nbsp;&nbsp;
	</c:if>
	<c:forEach var="p" begin="${startPage }" end="${endPage }">
		<a href="lgoods.do?pageNum=${p }">${p}</a>&nbsp;&nbsp;
	</c:forEach>
	<c:if test="${endPage<totalPage  }">
			<a href='lgoods.do?pageNum=${endPage+1 }'>[다음]</a>&nbsp;&nbsp;
	</c:if>
	</div>
	<input type="hidden" id="h_oper" value="${oper }">
	<input type="hidden" id="h_keyfield" value="${keyfield }">
	<input type="hidden" id="h_keyword" value="${keyword }">
</body>
</html>