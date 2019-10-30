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
	if(colName == "price" || colName == "saleprice")	
	{
		$("#op").show();	
	}
	
	$("#search").change(function(){
		var colName = $(this).val();
		if(colName == "price" || colName == "saleprice")	
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
	<h2>주문내역</h2>
		<hr>
		<form action="olist.do" method="post">
		<select name="search" id="search">
			<option value="name">고객명</option>
			<option value="bookname">도서명</option>
			<option value="publisher">출판사명</option>
			<option value="price">도서금액</option>
			<option value="saleprice">주문금액</option>
		</select> 

		<span id="op">
			<select name="oper">
				<option value=">=">>=</option>
				<option value="<="><=</option>
				<option value="=">=</option>
			</select>			
		</span>
		<input type="text" placeholder="검색어를 입력하시오" name="keyword" value="${keyword }" >
		<input type="submit" value="검색">
		</form>
		<table border = "1" width = "100%">
			<tr>
				<td>고객번호</td>
			<td>고객명</td>
			<td>도서명</td>
			<td>도서금액</td>
			<td>주문금액</td>
			<td>출판사명</td>
			<td>주문일</td>
			</tr>
			<c:forEach items="${list }" var="o">
			<tr>
				<td>${o.custid}</td>
				<td>${o.name }</td>
				<td>${o.bookname }</td>
				<td>${o.price }</td>
				<td>${o.saleprice }</td>
				<td>${o.publisher }</td>
				<td>${o.orderdate }</td>
			</tr>
			</c:forEach>
			
		</table>
		<input id="colName" type="hidden" id="" value="${search }">
		<input id="operator" type="hidden" id="" value="${oper }">
</body>
</html>