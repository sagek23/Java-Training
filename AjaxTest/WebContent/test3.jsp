<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function hello() {
		var name = document.getElementById("name").value;
		var r = document.getElementById("result");
		r.innerHTML = "<h2>"+name+"님 갑습니다.</h2>";
</script>
</head>
<body>
이름: <input type="text" id="name">
<input type="button" value="입장" onclick="hello()">
<div id="result"></div>

</body>
</html>