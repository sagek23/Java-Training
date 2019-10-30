<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function (){
	$("#write_form").submit(function(event){
		var data = $(this).serialize();
		//$.ajax({url:"",data:data, type="post"});
		//alert(data);
		$.post("AddMessage",data)
		event.preventDefault();
	});
	
	setInterval(function(){
		/*
		var today = new Date().getTime();
		$.ajax({url:"",data:today, success:function(){
			var arr = eval("("+eval+")")	
		}})	
		*/
		$.getJSON("GetList",{today:new Date().getTime()},function(data){ 
			//Date().getTime()은 새로운 페이지임을 알리기위해 사용 ex) GetList?today=11111처럼
			$("#output").empty();
			$.each(data, function(idx, chat){
				var div = $("<div></div>");
				var h2 = $("<h2></h2>").html(chat.name);
				var p = $("<p></p>").html(chat.message);
				$(div).append(h2,p);
				$("#output").append(div);
			});
		});
	},1000);
});
</script>
</head>
<body>
	<h2>채팅</h2>
	<form id="write_form" method="post">
		<table>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>메세지</td>
				<td><textarea rows="10" cols="60" name="message"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="글쓰기">
	</form>
	
	<hr>
	<div id="output"></div>
</body>
</html>