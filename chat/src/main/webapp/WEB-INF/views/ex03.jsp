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
.box{
	width: 100px;
	height: 100px;
	float: left;
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$('.box').draggable({
		grid:[102,102],
		stop: function(event,ui){
		//alert(ui.offset.top+':'+ui.offset.left);
			}
		});
});
</script>
</head>
<body>
	<div class="box ui-widget-content">만두</div>
	<div class="box ui-widget-content">벨로</div>
	<div class="box ui-widget-content">까미</div>
	<div class="box ui-widget-content">치즈</div>
</body>
</html>











