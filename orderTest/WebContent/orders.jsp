<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서주문</h2>
	<hr>
	<form action="orders.do" method="post">
			고객번호 : 
		<select name="custid">
			<c:forEach items="${clist }" var="c">
				<option value="${c.custid }"> ${c.name }(${c.custid }) </option>
			</c:forEach>
		</select>
		
		<br>
		도서번호 : 
		<select name="bookid">
			<c:forEach var="b" items="${blist }">
				<option value="${b.bookid }">${b.bookname }(${b.publisher })</option>
			</c:forEach>
		</select>
		<br>
		주문금액: <input type="text" name="saleprice"><br>
		<input type="submit" value="주문">
		<input type="reset" value="취소">
	</form>
</body>
</html>