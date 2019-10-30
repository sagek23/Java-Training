<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
	body{
		background-color: #525252;
	}
	.item{
		margin: 5px;
		width: 150px;
		height: 150px;
		background-color: white;
		border-radius: 10px;
		float: left;
	}
	.big{
		width: 300px;
		height: 450px;
	}
	.big img{
		width: 200px;
		height: 200px;
	}
	
	.big p{
		font-size: 30px;
		font-weight: bold;				
	}
	.normal{
		width: 300px;
		height: 300px;
	}
	.normal img{
		width: 110px;
		height: 110px;
	}
	
	.small{
		width: 150px;
		height: 150px;
	}
	.small img{
		width: 70px;
		height: 70px;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="masonry/jquery.masonry.js"></script>
<script type="text/javascript">
$(function(){
	$("#masonry_container").masonry({
		itemSelector:'.item',
		columnWidth: 170,
		isAnimated: true
		});
	$.getJSON("GetProductList",function(data){
		$.each(data, function(idx, item){
			var div = $("<div></div>").addClass("item");
			var name=$("<h3></h3>").html(item.name);
			if(item.fname.startsWith("ball")||item.fname.startsWith("shoe"))
			{
				$(div).addClass("normal");
			}
			else if(item.fname.startsWith("cloth"))
			{
				$(div).addClass("big");
			}
			else
			{
				$(div).addClass("small");
			}
			var fname = $("<img/>").attr({"src": "img/"+item.fname, width:"100", height:"100"});
			var no = $("<p></p>").html(item.no);
			var price = $("<p></p>").html(item.price);
			var qty = $("<p></p>").html(item.qty);
			
			$(div).append(name,fname,no,price,qty);
			$("#wrap").append(div);
		});
	});
});
</script>
</head>
<body>
<div id="masonry_container">
	<h2>상품목록</h2>
	<div id="wrap"></div>
</div>
</body>
</html>