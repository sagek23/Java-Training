<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		/*선언문에는 메소드를 정의하거나 변수를 선언하는 문장만이 올 수 있다. 
		반복문 등의 문장은 표현할 수 없다.*/
		
		public int add(int n)
		{
			return n+1;
		}
		
		String title = "비트캠프";
		int n = 5;
	%>
	<h2>jsp 문장구성요소 연습</h2>
	<hr>
	
	<%
		if(n%2==0)
			out.print("짝수");
		else
			out.print("홀수");
	
		int sum = 0;
		for(int i=1;i<=10;i++)
		{
			sum +=i;
		}
	%>
	<font color = "blue">1에서 10까지의 합은?</font>
	 <font color ="red"><%=sum %> </font>
	
</body>
</html>