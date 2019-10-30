<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="css/jquery.lightbox-0.5.css"/>
<style type="text/css"></style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script>
<script type="text/javascript">
$(function(){
	$("a").lightBox();
});
</script>
</head>
<body>
	<a href="img/picachu.png">피카츄</a>
	<a href="img/eve.png">이브이</a>
	<a href="img/type-null.png">타입-널</a>
	<a href="img/Wobbuffet.png">마자용</a>
</body>
</html>