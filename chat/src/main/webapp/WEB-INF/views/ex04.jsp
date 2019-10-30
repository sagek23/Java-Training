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
	}
	#dock > div{
		float: right;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	var arr = ["ball1.jpg","ball2.jpg","ball3.jpg","ball4.jpg", "ball5.jpg","cloth1.jpg","cloth2.jpg","cloth3.jpg",
		"cloth4.jpg","cloth5.jpg", "shoe1.jpg", "shoe2.jpg", "shoe3.jpg", "shoe4.jpg", "shoe5.jpg","stock1.jpg",
		"stock2.jpg","stock3.jpg","stock4.jpg","stock5.jpg" ];
	for(var i=0;i<arr.length;i++)
	{
		var icon = "";
		icon += "<div class='item ui-widget-content ui-corner-all'>";
		icon += "<img src=img/"+arr[i]+"/>";
		icon += "</div>";

		$("#wrap").append(icon);
	}
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
				});
			}
		}); 
	$("body").droppable({
		accept: "#dock > div",
		drop: function(event, ui){
			$(ui.draggable).fadeOut(function(){
				$(this).appendTo("#wrap").fadeIn();
				});
			}
		}); 
});
</script>
</head>
<body>
	<div id="wrap"></div>
	<div id="dock" class="ui-state-error"></div>
</body>
</html>











