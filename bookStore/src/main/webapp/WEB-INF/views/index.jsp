<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#gbox_grid{
		position: fixed;
		left: 100px;
		
	}
</style>
<link rel="stylesheet" href="jqueryui/themes/flick/jquery-ui.min.css">
<link rel="stylesheet" href="jqgrid/css/ui.jqgrid-bootstrap-ui.css">
<link rel="stylesheet" href="jqgrid/css/ui.jqgrid.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="jqgrid/js/i18n/grid.locale-en.js"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript">
$(function(){

	var itemPerPage = 10;
	
	var delDlg ={
		onclickSubmit:function(params){
			var idx = $("#grid").getGridParam("selrow");
			rowData = $("#grid").getRowData(idx);
			return {bookid:rowData.bookid}
		}	
	}
	
	$("#grid").jqGrid({
		url:"/getBooks",
		editurl:"/editBooks",
		pager:"#pager",
		caption:"Books",
		height:"100%",
		rowNum:10,
		rowList:[10,20,30],
		colNames:['bookid','bookname','publisher','price'],
		colModel:[
			{name:'bookid',index:'bookid',width:50, editable:true},
			{name:'bookname',index:'bookname',width:100, editable:true},
			{name:'publisher',index:'publisher',width:100, editable:true},
			{name:'price',index:'price',width:100, editable:true}
		]
	}).navGrid("#pager", {
			search:true,
			edit:true,
			add:true,
			del:true
		}, {},{},delDlg);
});
</script>
</head>
<body>
	<h2>도서관리</h2>
	<table id="grid"></table>
	<div id="pager"></div>
	<ul class="paging_button"></ul>
</body>
</html>