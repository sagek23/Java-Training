<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnEnter").click(function() {
		var name = $("#name").val();
		var h = $("<h2></h2>").html(name+"님 반갑습니다");
		$("#result").html(h); //result에 있는 내용을 h의 값으로 바꿈
	});
	
})
</script>
</head>
<body>
이름: <input type="text" id="name">
<input type="button" value="입장" id="btnEnter">

<div id="result">안녕</div>
</body>
</html>