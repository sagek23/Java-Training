<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("btn").onclick = function () {
			var str = "";
			str += "<ul>";
			str += "<li>우동</li>";
			str += "<li>짜장면</li>";
			str += "<li>고추장찌개</li>";
			str += "<li>김치찌개</li>";
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