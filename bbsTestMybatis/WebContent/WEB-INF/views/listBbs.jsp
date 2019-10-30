<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function () {
	setTimeout(function () {
		$("#msg").hide();
	},3000)
})
</script>
</head>
<body>
	<h2>게시물 목록</h2>
	<hr>
	<div id="msg">${msg }</div>
	<a href="insertBbs.do">게시물 등록</a>
	<table border="1">
		<tr>
			<td>게시물번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.num }</td>
			<td>
				<c:if test="${b.blevel> 0 }">
					<c:forEach begin="1" end="${b.blevel }">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<img alt="arrow.png" src="arrow.png">
				</c:if>
			<a href="detailBbs.do?num=${b.num }">${b.title }</a>
			</td>
			<td>${b.writer }</td>
		</tr>
		</c:forEach>
	</table>
	<form action="listBbs.do">
	<select name="keyfield">
		<option value="writer">작성자</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어를 입력하세요"/>
	<input type="submit" value="검색"/>
	</form>
</body>
</html>