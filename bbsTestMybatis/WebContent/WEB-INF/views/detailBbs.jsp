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
	$("#delBbs").click(function () {
		var re = confirm("정말로 삭제할까요?");
		if(re == true)
		{	var num = $("#num").val();
			location.href="deleteBbs.do?num="+num;
		}
	});
})
</script>
</head>
<body>
	<h2>${b.title }</h2>
	<hr>
	<input type="hidden" id="num" name="num" value="${b.num }">
	<input type="hidden" name="pwd" value="${b.pwd }">
	<table border="1" width="100%">
		<tr>
			<td colspan="3">제목: ${b.title } <br></td>
		</tr>
		<tr>
			<td>작성자: ${b.writer }</td><br>
			<td>작성일: ${b.credate }</td><br>
			<td>조회수: ${b.views }</td><br>
		</tr>
		<tr>
			<td colspan="3">내용: <br>
			<textarea rows="20" cols="80" readonly="readonly"> ${b.content }</textarea><br>
			<img alt="${b.fname }" src="files/${b.fname }">
			</td>
		</tr>
	</table>
	<a href="insertBbs.do?num=${b.num }">답글작성</a><br>
	<a href="updateBbs.do?num=${b.num }">수정</a>
	<a href="#" id="delBbs">삭제</a>
</body>
</html>