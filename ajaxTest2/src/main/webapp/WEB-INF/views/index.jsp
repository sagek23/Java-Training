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

	$("#btnGoods").click(function(){
		$.ajax({url:"listGoods.do", success:function(data){
			var arr = eval("("+data+")");
			
			$.each(arr, function(idx,item){
				var tr = $("<tr></tr>");
				
				var td1 = $("<td></td>").html(item.no);
				var td2 = $("<td></td>").html(item.name);
				var td3 = $("<td></td>").html(item.price);
				var td4 = $("<td></td>").html(item.qty);
				var img = $("<img/>").attr({src:"img/"+item.fname, width:"50", height:"50" });
				var td5 = $("<td></td>").append(img);
				$(tr).append(td1, td2, td3, td4, td5);
				$("#tb").append(tr);
			});
			
			}});
		});
	
	$("#btnJson").click(function(){
		$.ajax({url:"member.do", success:function(data){ //member.do는 ajax통신에 의해 응답
			var m = eval( "("+data+")" );

			var name = $("<h1></h1>").html(m.name);
			var age = $("<p></p>").html(m.age);
			$("#member").append(name, age);
			}});
		});
	
	$("#btn").click(function(){
		$.ajax({url:"bit.do", success:function(data){
			$("#result").html(data);
			}});
		});
});
</script>
</head>
<body>
	<table id="tb">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>상품사진</td>
		</tr>
	</table>
	<button id="btnGoods">상품목록 읽어오기</button>
	
	<div id="member">
		<h2></h2>
		<p></p>
	</div>
	<button id="btnJson">JSON type의 Ajax 요청</button>
	<hr>
	<h2>${title }</h2>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<input type="text">
	결과:<span id="result"></span>
	<button id="btn">Ajax통신</button>
</body>
</html>