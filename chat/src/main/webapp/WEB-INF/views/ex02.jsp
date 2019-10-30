<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="jqueryui/themes/ui-lightness/jquery-ui.css">
<style type="text/css">
#box{
	padding: 5px;
}

#box h1{
	margin: 0px;
	padding: 5px;
	text-align: center;
}
#list2 > div{
	padding: 5px;
	float: left;
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	var arr = $("#list").find("h1");
	$(arr).hover(function(){
		$(this).addClass("ui-state-hover");
		}, function(){
		$(this).removeClass("ui-state-hover");
		});
})
</script>
</head>
<body>
	<div id="list2">
		<div class="ui-state-default ui-corner-all">
			<span class="ui-icon ui-icon-search"></span>
		</div>
		<div class="ui-state-default ui-corner-all">
			<span class="ui-icon ui-icon-heart"></span>
		</div>
		<div class="ui-state-default ui-corner-all">
			<span class="ui-icon ui-icon-star"></span>
		</div>
		<div class="ui-state-default ui-corner-all">
			<span class="ui-icon ui-icon-key"></span>
		</div>
	</div>
	<hr>
	<div id="list" class="ui-widget-content">
		<h1>이순신</h1>
		<h1>유관순</h1>
		<h1>김유신</h1>
		<h1>강감찬</h1>
	</div>
	<hr>
	<div id="box" class="ui-state-default ui-corner all">
		<h1 class="ui-widget-header ui-corner-top">한국P&G, '다우니'로 韓 세탁 세제 시장 첫 도전장</h1>
		<p>3천300억 규모 시장서 경쟁…전 세계 최초 '폼'형 세제도 출시
[아이뉴스24 장유미 기자] 세계 1위 세제 제조사 P&G가 한국 시장에 처음으로 다우니 세탁 세제를 출시하며 3천300억 원대 규모로 성장한 가정 세탁세제 시장을 두고 경쟁에 나선다.

한국P&G는 한국 소비자들의 빨래 습관에 대한 심도 있는 분석을 바탕으로 프리미엄 세제 '다우니 세탁 세제'를 개발해 출시한다고 25일 밝혔다. 초고농축 액체세제와 더불어 전 세계 최초로 한국에 선보이는 혁신적인 '폼(foam)'형 세제의 2가지 타입으로 출시돼 선택의 폭을 넓혔다.</p>
	</div>
</body>
</html>











