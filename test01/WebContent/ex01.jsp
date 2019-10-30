<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro() {
		alert("hello");
		document.getElementById("name").value;
		alert(name);
	}
</script>
</head>
<body onload="pro()">
	<h2>안녕</h2>
	<input type="text" id="name" value="홍길동">
</body>
</html>