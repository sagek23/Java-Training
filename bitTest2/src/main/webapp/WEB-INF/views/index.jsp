<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnDown").click(function(){
		$.ajax({url:"http://203.236.209.91:5000/down_webtoon.do",success:function(r){
			alert(r);
		}});
	});
		
});
</script>
</head>
<body>
	<h2>비트캠프</h2>
	<button id="btnDown">웹툰다운닫기</button>
</body>
</html>