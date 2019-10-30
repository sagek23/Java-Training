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
	*{
		margin: 0px;
		padding: 0px;
	}
	body{
		font-size: 62.5%;
	}
	.item{
		margin: 3px;
		padding: 5px;
	}
	.item > img{
		width: 100px;
		height: 100px;
	}
	
	#btnOrder{
		position: fixed;
		width: 100px;
		bottom: 250px;
		right: 0px;
	}
	
	#orderPrice{
		position: fixed;
		width: 150px;
		bottom: 300px;
		right: 0px;
		font-size: 20px;
	}
	#wrap{
		overflow: hidden;
	}
	#wrap > div{
		float: left;
	}
	#dock{
		position: fixed;
		min-height: 120px;
		width: 100%;
		bottom: 0px;
		z-index: 1;
		background-color: white;
	}
	#dock > div{
		float: right;
	}
	
	.qty{
		width: 50px;
	}
	input{
		font-style: black;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	var oprice= 0;
	var arr;

	var calcTotalPrice = function(){

		oprice = 0;
		var prices = $("#dock").find(".price");
		var qty_list = $("#dock").find(".qty");
		$.each(prices, function(idx, pr){
			oprice += eval(  $(pr).text() )
			*eval($(qty_list[idx]).val());
		});					
		$("#orderPrice").html(oprice);
	}
	
	$("#btnOrder").click(function(){
		//var total = Number($("body").find("#orderPrice").html());
		var no_list = $("#dock").find(".no");
		var qty_list = $("#dock").find(".qty");

		var data = {"custid":"tiger",
					"total":oprice
				};
		
		$.each(no_list, function(i, no)
				{
					var attr_no = "jumunList["+i+"].goods_no";
					var attr_qty = "jumunList["+i+"].qty";
					data[attr_no]= $(no).html();
					data[attr_qty]= $(qty_list[i]).val();
				});
	

		$.post("insertOrder",			
				data,			
				function(r){
				  alert(r);
				});
		

		/*
		$.ajax(
				{url:"insertOrder",
				type:"post",
				data:data,
				success:function(r){
					alert(r)}});
		*/
		});
	
	
	$.getJSON("GetProductList", function(data){
		arr =data;
		$.each(arr, function(idx, item){
			var div = $("<div></div>").addClass("item");
			var name=$("<h3></h3>").html(item.name);
			var fname = $("<img/>").attr({"src": "img/"+item.fname, width:"100", height:"100"});
			var no = $("<p></p>").html(item.no).addClass("no");
			var price = $("<p></p>").html(item.price).addClass("price");
			var qty = $("<span></span>").html("재고수량:"+item.qty).css("width","100px");
			var order_qty = $("<input min='1' type='number'/>").val(1).addClass("qty");

			$(div).append(name,fname,no,price,qty,order_qty);
			$("#wrap").append(div);
			$(order_qty).hide();

			$(order_qty).change(function(){
				calcTotalPrice();
				});
			});
		
	
	$("#wrap > div").draggable({
		helper: "clone",
		zIndex: 100,
		scroll: false
		});

	$("#dock").droppable({
		accept: "#wrap > div",
		drop: function(event, ui){
			$(ui.draggable).fadeOut(function(){
				$(this).appendTo("#dock").fadeIn();

				calcTotalPrice();
				
				$("#dock").find(".qty").show();
				});
			}
		}); 
	$("body").droppable({
		accept: "#dock > div",
		drop: function(event, ui){
			$(ui.draggable).fadeOut(function(){
				$(this).appendTo("#wrap").fadeIn();

				calcTotalPrice();
				});
			}
		});
	});


});
</script>
</head>
<body>
	<div id="wrap"></div>
	<span id="oPrice">총 주문금액:</span><span id="orderPrice">0원</span>
	<button id="btnOrder" class="btn btn-success">주문</button>
	<div id="dock" class="ui-state-error"></div>
</body>
</html>











