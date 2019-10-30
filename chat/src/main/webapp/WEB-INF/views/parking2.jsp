<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4f4365ebc590e4d1b0cea122266f1f73"></script>
<script type="text/javascript">
$(function(){
	var arr;
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};

	
	var map = new kakao.maps.Map(container, options);

	var map = new kakao.maps.Map(container, options);

	var mapTypeControl = new kakao.maps.MapTypeControl();

	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	
	$.ajax({
		url:"http://openapi.seoul.go.kr:8088/784d574a696b736a38357250494a50/json/GetParkInfo/1/5/", success:function(data){
		arr = data.GetParkInfo.row;
		$.each(arr, function(idx, item){
		var p= $("<p></p>").html(item.PARKING_NAME+"("+item.ADDR+")").attr("idx",idx);
		$("#list").append(p);

		$(p).click(function(){
			var i = $(this).attr("idx");
			var position = arr[i];
			var lat = position.LAT;
			var lng = position.LNG;
			$("#detail").html("위도:"+lat+", 경도"+ lng);
			var moveLatLon = new kakao.maps.LatLng(lat, lng);
		    map.panTo(moveLatLon);   

		    var markerPosition  = new kakao.maps.LatLng(lat,lng); 

			 // 마커를 생성합니다
				 var marker = new kakao.maps.Marker({
				     position: markerPosition
				 });

			 // 마커가 지도 위에 표시되도록 설정합니다
				 marker.setMap(map);
				
			});
		});
	}});
});

</script>
</head>
<body>
	<div id="list"></div>
	<div id="detail"></div>
	<div id="map" style="width:500px;height:400px;"></div>
	<p>
</body>
</html>