<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="jqueryui/themes/ui-lightness/jquery-ui.css">
<style type="text/css">
	body{
		font-size: 62.5%
	}
	
	h1{
		text-align: center;
	}
	
	input[type=text],label{
		margin-bottom: 12px;
		padding: .4em;
		width: 95%;	
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	
	setInterval(function(){		
		$.getJSON("listSchedule", function(arr){
			$("#list").empty();
			$.each(arr, function(idx, s){
				var li = $("<li></li>").html(s.event_name+","+s.event_date).addClass("list-group-item");
				$("#list").append(li);
			});
		});		
	},3000);
	
	
	
	$("#div").dialog({
		buttons:{
			submit:function(){
				var data = $("#div").serialize();
				/*var data = {event_name:$("#event_name").val(),
							event_date:$("#event_date").val()};
				*/
				$.ajax(
						{url:"insertSchedule",
						 type:"POST",
						 data:data,
						 success:function(r){	
							 						
						 }});
			},
			reset:function(){
				alert("모두지워요");
			},
			cancel:function(){
				alert("취소");
			}
		},
		modal:false
	});	
	$("#event_date").datepicker();
})
</script>
</head>
<body>
	<input type="text">
	<br>
	<form id="div" title="일정등록">
		<h1>일정등록</h1>
		<label for="event_name">일정이름</label>
		<input type="text" name="event_name" id="event_name">
		<label for="event_name">날짜</label>
		<input type="text" name="event_date" id="event_date">
	</form>
	
	<ul id="list" class="list-group"></ul>
</body>
</html>











