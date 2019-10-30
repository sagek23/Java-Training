<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
	<div data-role='page'>
		<div data-role='header'>
			<h1>상품목록</h1>
		</div>
		<div data-role='content'>
			<ul data-role='listview'>
				<li><a href="#second_page">축구공</a></li>
				<li><a href="#second_page">유니폼</a></li>
				<li><a href="#second_page">축구화</a></li>
				<li><a href="#second_page">스타킹</a></li>
			</ul>
		</div>
		<div data-role='footer'>
			<h1>비트축구몰</h1>
		</div>
	</div>
	<div data-role="page" id="second_page">
		<div data-role="header">
			<h1>상품상세</h1>
		</div>
		<div data-role="content">
			<p>축구공1</p>
			<img src="img/ball1.jpg" width="100px", height="100px">
		</div>
	</div>
</body>
</html>