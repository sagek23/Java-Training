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
		$("#op").hide();
		
		$(".sort").click(function () {
			var cname = $(this).attr("cname"); //지금 클릭한 컬럼의 cname값 가져오기
			location.href="listBook.do?sort="+cname;
		});
		
		var sf = $("#h_search").val(); //상태유지해서 온 값에 대한 것.
		if(sf=='price')
		{
			$("#op").show();
		}
		else
		{
			$("#op").hide();
		}
		
		//$("#oper").val($("#h_oper").val());
		//$("#search").val($("#h_search").val());
		
		if($("h_keyword").val()=='')
		{
			$("#search").val("bookname");
			$("#oper").val("=");
		}
		
		$("#search").change(function () {
			var v = $(this).val();
			if(v=='price')
			{
				$("#op").show();
			}
			else
			{
				$("#op").hide();
			}
			
		})
	});
</script>
</head>
<body>
	<h2>도서목록</h2>
	<hr>
	<table border="1" width="100%">
	<tr>
		<td class="sort" cname="bookid">도서번호</td> <!-- cname이라는 속성은 프로그래밍을 위해 임의로 만든 것 -->
		<td class="sort" cname="bookname">도서명</td>
		<td class="sort" cname="publisher">출판사</td>
		<td class="sort" cname="price">가격</td>
	</tr>
	<c:forEach var="b" items="${list }">
	<tr>
		<td>${b.bookid }</td>
		<td>${b.bookname }</td>
		<td>${b.publisher }</td>
		<td>${b.price }</td>
	</tr>
	</c:forEach>
	</table>
	<form action="listBook.do">
	<select name="search" id="search">
		<option value="bookname">도서명</option>
		<option value="publisher">출판사</option>
		<option value="price">가격</option>
	</select>
	<span id="op">
		<select id="oper" name="oper">
			<option value="=">=</option>
			<option value=">=">>=</option>
			<option value="<="><=</option>
		</select>
	</span>
	<input type="search" name="keyword" id="keyword" placeholder="검색어를 입력하세요">
	<input type="submit" value="검색">
	</form>
	<input type="hidden" value="${search}" id="h_search">
	<input type="hidden" value="${keyword}" id="h_keyword">
	<input type="hidden" value="${oper}" id="h_oper">
</body>
</html>