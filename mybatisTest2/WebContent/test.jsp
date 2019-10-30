<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro() {
		//alert("삭제합니다.");
		re = confirm("정말로 삭제하시겠습니까?");
		if(re==true)
		{
			location.href="start.jsp";
		}
	}
</script>
</head>
<body>
<button onclick="pro()">삭제</button>
</body>
</html>