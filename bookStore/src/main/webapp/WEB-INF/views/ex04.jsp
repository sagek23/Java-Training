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
	var arr ;
	$.getJSON("GetProductList",function(data){
		arr = data;
		$.each(arr, function(i, item){
			var li = $("<li></li>");
			var a = $("<a href='#second_page'></a>").html(item.name).attr("idx",i);
			$(li).append(a);
			$("#list").append(li);

			$(a).click(function(){
				var idx = $(this).attr("idx");
				var g = arr[idx];
				$("#fname").attr("src","img/"+g.fname);
				$("#name").html(g.name);
				$("#qty").html(g.qty);
				$("#price").html(g.price);
			});
		});
		$("#list").listview("refresh");
	});
});
</script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>상품목록</h1>
		</div>
		
		<div data-role="content">
			<ul data-role="listview" id="list">
			</ul>
		</div>
		
		<div data-role="footer">
			<h1>비트 축구몰</h1>
		</div>
	</div>
	
	
	<div data-role="page" id="second_page">
		<div data-role="header">
			<h1>상품상세</h1>
		</div>
		<div data-role="content">
			<p id="name"></p>
			<img id="fname"  src="img/ball1.jpg" width="100px" height="100px">
			<p id="qty"></p>
			<p id="price"></p>
		</div>
	</div>
</body>
</html>
