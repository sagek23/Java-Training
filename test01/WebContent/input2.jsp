<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function check()
	{
		var name = document.F.name.value;
		var age = document.F.age.value;
		
		name = name.trim();
		
		if(  name == "" || age == "" )
		{
			alert("이름과 나이를 입력하세요!");
			return;
		}
		
		if( isNaN(age) == true  )
		{
			alert("나이는 숫자로 입력해주세요");
			return;
		}
		
		document.F.submit();
	}
</script>

</head>
<body>
	<H2>회원 정보 입력</H2>
	<form action="result.jsp" method="post" name="F">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="button" value="확인" onclick="check()">
	</form>
</body>
</html>













