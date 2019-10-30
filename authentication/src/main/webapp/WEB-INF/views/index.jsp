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
	$("#joinForm").hide();
	$("#divAuth").hide();
	var authNum;
	$("#sendAuth").click(function(){
		var data ={tel:$("#telNum").val()};
		$.post("sendAuthNum",data,function(r){
			authNum=r;
			$("#divAuth").show();
			});
		});
	$("#btnAuth").click(function(){
		var chkAuth = $("#chkAuth").val();
		$("#divAuth").show();
		if(authNum==chkAuth)
		{
			$("#joinForm").show();
			$("#msg").html("인증성공");
			$("phone").val($("#telNum").val());
		}
		else
		{
			$("#msg").html("인증실패");
		}
	});
	$("#btnJoin").click(function(){
			var data = $("#info").serialize();
			/*
			$.ajax({
				url:"", data:data, type:"POST", success:function(r){
					alert(r);
					}
				});
				아래와 같은 내용
			*/
			$.post("joinMember", data, function(r){
				alert("가입완료");
				});
		});
});
</script>
</head>
<body>
<h2>회원가입</h2>
<hr>
문자인증 : <input type="tel" id="telNum">
<button id="sendAuth">인증번호 전송</button>
<div id="divAuth">
	인증번호:<input type="text" id="chkAuth">
	<button id="btnAuth">확인</button>
</div>
<p id="msg"></p>
<div id="joinForm">
	<form id="info"><br>
		id: <input type="text" name="id"><br>
		email: <input type="text" name="email"><br>
		phone: <input type="text" name="phone" id="phone"><br>
		<button id="btnJoin">가입</button>
	</form>
</div>
</body>
</html>