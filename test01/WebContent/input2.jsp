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
			alert("�̸��� ���̸� �Է��ϼ���!");
			return;
		}
		
		if( isNaN(age) == true  )
		{
			alert("���̴� ���ڷ� �Է����ּ���");
			return;
		}
		
		document.F.submit();
	}
</script>

</head>
<body>
	<H2>ȸ�� ���� �Է�</H2>
	<form action="result.jsp" method="post" name="F">
		�̸� : <input type="text" name="name"><br>
		���� : <input type="text" name="age"><br>
		<input type="button" value="Ȯ��" onclick="check()">
	</form>
</body>
</html>













