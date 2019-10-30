<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var arr = ['우동', '짜장면', '떡볶이', '마라탕'];
		document.getElementById("btn").onclick = function () {
			var str ="";
			str += "<ul>";
		
			for(var i=0;i<arr.length;i++)
			{
				str += "<li>"+arr[i]+"</li>";	
			}		
			str += "</ul>";
			
			
			document.getElementById("result").innerHTML = str;
		}
	}
</script>
</head>
<body>
	<h2>우리반이 추천하는 점심메뉴</h2>
	<div id="result"></div>
	<button id="btn">출력</button>
</body>
</html>