<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(id) {
		re = confirm("정말로 삭제하시겠습니까?");
		if(re==true)
		{
			location.href="delBook.do?bookid="+id
		}
	}
</script>
</head>
<body>
	<h2>${b.bookname }</h2>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>도서가격</td>
		</tr>

		<tr>
			<td>${b.bookid }</td>
			<td>${b.bookname}</td>
			<td>${b.publisher}</td>
			<td>${b.price}</td>
		</tr>
	</table>
	<a href="ubook.do?bookid=${b.bookid }">도서수정</a>
	<a href="#" onclick="pro(${b.bookid})">도서삭제</a>  <!-- #은 이동하는 것이 없다는 것 -->
	
</body>
</html>