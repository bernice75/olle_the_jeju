<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 detail</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/suggest/suggest_detail.css?var=2" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=발급받은 app key"></script>
        <script src="./resources/js/suggest/suggest_detail.js?var=2" type="text/javascript"></script>
        <script type="text/javascript">
        var Jdata; //json 객체
        var startX,startY;
        var endX,endY;
        var lon,lat; 
        var map; //Tmapv2 객체
        var latArr=[];
        var lonArr=[];
        var marker_s, marekr_e, waypoint;
		var resultMarkerArr = [];
		//경로그림정보
		var drawInfoArr = [];
		var resultInfoArr = [];
        
        $(function(){
        	var sug_num = $("#sug_num").val();
        	
        	$.ajax({
        		url:"suggest_detail_ajax.do?sug_num="+sug_num,
        		dataType:"JSON",
        		method:"GET",
        		success: function(data){
        			console.log(data[0].day[0].name);
        			Jdata = data;
        			console.log(Jdata);
        			
        		    for(var i = 0; i < data.length; i++) {
        		        var button = document.createElement('button');
        		        button.setAttribute('class', 'btn btn-outline-dark ' +(i+1));
        		        button.setAttribute('type', 'button');
        		        button.setAttribute('onclick', 'changeList(this);');
        		        button.setAttribute('style','margin-right:5px;')
        		        var btnText = document.createTextNode((i+1) + "일차");
        		        button.appendChild(btnText);
        		        $('.day-btn').append(button);
        		    }
        		}
        	})
        	
        });
        
		function initTmap() {
			// 1. 지도 띄우기
			map = new Tmapv2.Map("map_div", {
				center : new Tmapv2.LatLng(33.506336, 126.49514),
				width : "70%",
				height : "500px",
				zoom : 15,
				zoomControl : true,
				scrollwheel : true
			});
		}
		
		// 2. 시작, 도착 심볼찍기
		function startM(lon,lat){// 시작
			if(resultMarkerArr.length>0){
				for(var i in resultMarkerArr){
					resultMarkerArr[i].setMap(null);
				}
				resultMarkerArr=[];
			}
			marker_s = new Tmapv2.Marker({
				position : new Tmapv2.LatLng(lat, lon),
				icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png",
				iconSize : new Tmapv2.Size(24, 38),
				map:map
			});
			resultMarkerArr.push(marker_s);
		}
		
		function endM(lon, lat){// 도착
			marker_e = new Tmapv2.Marker({
				position : new Tmapv2.LatLng(lat, lon),
				icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png",
				iconSize : new Tmapv2.Size(24, 38),
				map:map
			});
			resultMarkerArr.push(marker_e);
		}
		
		function passM(lon,lat){// 3. 경유지 심볼 찍기
			marker = new Tmapv2.Marker({
				position : new Tmapv2.LatLng(lat, lon),
				icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_p.png",
				iconSize : new Tmapv2.Size(24, 38),
				map:map
			});
			resultMarkerArr.push(marker);
		}
        function mapMaker(class_name){
        	$("div[name=map_show]").children("p").remove();
        	
        	var cnt = class_name-1;
        	var length = Jdata[cnt].day.length;
        	var x=3;
        	for(var i=0; i<length; i++){
        		lat = Jdata[cnt].day[i].lat;
        		lon = Jdata[cnt].day[i].lon;
        		var text ="<p>"+(i+1)+". &nbsp;"+Jdata[cnt].day[i].name+"<p>"; 
        		lonArr[i] = lon;
        		latArr[i] = lat;
        		if(i==0){ //시작시
        			startX=lon;
        			startY=lat;
        			
        			startM(lon,lat); //시작마커
        			
        		}else if(i==(length-1)){ //끌날때
        			endX=lon;
        			endY=lat;
        			
					endM(lon,lat); //엔드 마커		
					
        		}else{
        			passM(lon,lat)
        		}
        		$("div[name=map_show]").append(text);
        	}
        	drawLine(cnt,length);
        }
        
     // 4. 경로탐색 API 사용요청
		var routeLayer; 
		function drawLine(cnt,length){
			
			var headers = {}; 
			headers["appKey"]="l7xx142479165b1048a5b99ae1b5a05f5d1b";
			headers["Content-Type"]="application/json";
			
			var via = new Object();
			via.startName="출발";
			via.startX = ''+startX+'';
			via.startY = ''+startY+'';
			via.startTime="201708081103"
			via.endName="도착지";
			via.endX = ''+endX+'';
			via.endY = ''+endY+'';
			via.viaPoints = new Array();
			
			for(var i=0; i<length; i++){
				via.viaPoints.push({
					 "viaPointId" : "test0"+i,
					 "viaPointName" : "name0"+i,
					 "viaX" : ''+Jdata[cnt].day[i].lon+'',
					 "viaY" : ''+Jdata[cnt].day[i].lat+''
				 });
				
			}
			via.reqCoordType="WGS84GEO";
			via.resCoordType="EPSG3857";
			via.searchOption="0";
			console.log(JSON.stringify(via));
			
			var param = JSON.stringify(via);
			
			console.log(param);
			
	 		$.ajax({
					method:"POST",
					url:"https://apis.openapi.sk.com/tmap/routes/routeSequential30?version=1&format=json",//
					headers : headers,
					async:false,
					data:param,
					success:function(response){
						console.log(response);
						var resultData = response.properties;
						var resultFeatures = response.features;
						
						// 결과 출력
						var tDistance = "총 거리 : " + resultData.totalDistance + "km,  ";
						var tTime = "총 시간 : " + resultData.totalTime + "분,  ";
						var tFare = "총 요금 : " + resultData.totalFare + "원";
						
						$("#result").text(tDistance+tTime+tFare);
						
						//기존  라인 초기화
						
						if(resultInfoArr.length>0){
							for(var i in resultInfoArr){
								resultInfoArr[i].setMap(null);
							}
							resultInfoArr=[];
						}

						
						for(var i in resultFeatures) {
							var geometry = resultFeatures[i].geometry;
							var properties = resultFeatures[i].properties;
							var polyline_;
							
							drawInfoArr = [];
							
							if(geometry.type == "LineString") {
								for(var j in geometry.coordinates){
									// 경로들의 결과값(구간)들을 포인트 객체로 변환 
									var latlng = new Tmapv2.Point(geometry.coordinates[j][0], geometry.coordinates[j][1]);
									// 포인트 객체를 받아 좌표값으로 변환
									var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(latlng);
									// 포인트객체의 정보로 좌표값 변환 객체로 저장
									var convertChange = new Tmapv2.LatLng(convertPoint._lat, convertPoint._lng);
									
									drawInfoArr.push(convertChange);
								}
	
								polyline_ = new Tmapv2.Polyline({
									path : drawInfoArr,
									strokeColor : "#FF0000",
									strokeWeight: 6,
									map : map
								});
								resultInfoArr.push(polyline_);
								
							}else{
								var markerImg = "";
								var size = "";			//아이콘 크기 설정합니다.
								
								if(properties.pointType == "S"){	//출발지 마커
									markerImg = "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png";	
									size = new Tmapv2.Size(24, 38);
								}else if(properties.pointType == "E"){	//도착지 마커
									markerImg = "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png";
									size = new Tmapv2.Size(24, 38);
								}else{	//각 포인트 마커
									markerImg = "http://topopen.tmap.co.kr/imgs/point.png";
									size = new Tmapv2.Size(8, 8);
								}
								
								// 경로들의 결과값들을 포인트 객체로 변환 
								var latlon = new Tmapv2.Point(geometry.coordinates[0], geometry.coordinates[1]);
								// 포인트 객체를 받아 좌표값으로 다시 변환
								var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(latlon);
							  	
							  	marker_p = new Tmapv2.Marker({
							  		position: new Tmapv2.LatLng(convertPoint._lat, convertPoint._lng),
							  		icon : markerImg,
							  		iconSize : size,
							  		map:map
							  	});
							  	
							  	resultMarkerArr.push(marker_p);
							}
						}
						
						var PTbounds = new Tmapv2.LatLngBounds();//영역 설정 객체 생성
						
							for(var i=0; i<length; i++){
								var linePt = new Tmapv2.LatLng(latArr[i], lonArr[i]); //좌표객체 생성
								PTbounds.extend(linePt); //영역 객체 extend함수(영역 확장)으로 좌표 보내기
							}
						map.fitBounds(PTbounds, 200);//영역 객체를 포함하는 위치로 지도 이동
						
					},
					error:function(request,status,error){
						console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				}); 
		}
	
	function addComma(num) {
		  var regexp = /\B(?=(\d{3})+(?!\d))/g;
		   return num.toString().replace(regexp, ',');
	}

        
        
       
        </script>
	</head>
	<body onload="initTmap();">
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>추천일정</h2>
                    <br>
                    <p>
                        세계적으로 유명한 유네스코 자연유산과 세계지질공원 등을 직접 찾아가보는 여행코스는 남다른 의미가 있습니다!<br>
                        당일 여행부터 4일 이상의 여행까지,<br>
                        개인의 취향과 시간에 맞게 다양한 여행 일정을 계획해 더욱 즐거운 제주도 여행을 경험하세요!
                    </p>
                </div>
                <br><br>
                <div class="nail">
				<div id="carouselExampleFade" class="carousel slide carousel-fade slider" data-bs-ride="carousel">
                        <div class="carousel-inner imgs">
                            <div class="carousel-item active">
                                <img src="./resources/img/1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="./resources/img/dolpin.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="./resources/img/test.jpg" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="content_info">
                        <br>
                        <h4>${dto.sug_title }</h4>
                        <div class="name">
                            <h6><strong>작성자</strong> | ${dto.sug_writer }</h6>
                            <h6 class="like" id="pText" onclick="like();" ><i id="push"class="fa fa-heart-o" aria-hidden="true" style="font-weight:normal;"> | <span id="text">${dto.sug_push }</span></i> </h6>
                            <input type="hidden" id="sug_num" value="${dto.sug_num }">
                            <h6>조회수 | ${dto.sug_views }</h6>
					</div>
                        <div class="content">
							${dto.sug_content }
                        </div>
                        <div class="tag">
                            <h6 class="day"><strong>기간</strong> | ${dto.sug_term }</h6>
                            <h6 class="regdate"><strong>작성일</strong> | ${regdate }</h6>
                            <h6 class="den"><strong>성향</strong> | ${dto.sug_tendency }</h6>
                            <h6 class="hash"><strong>태그</strong> | ${dto.sug_kategorie }</h6>
                        </div>
                    </div>
                </div>
			<br><br>
                <div class="suggest_text">
				<div class="day-btn">
					<h3>일정</h3>
				</div>
				<hr class="line">
                    <div class="main-second">
                        <div class="main-map">
       						<div class="map" style="width: 30%; float: left;">
							</div>                 
                           <div id="map_div" style="float: left; margin-bottom: 10px;"></div>
                        </div>
                    </div>
                </div>
                <div class="bottom-btn-group2">
                    <input id="btn1" class="btn btn-secondary" type="button" value="목록" onclick="location.href='suggest_main.do?kategorie=전체&page=1'">
                    <c:if test="${sessionScope.user_id eq 'admin' }">
                    	<input id="btn2" class="btn btn-primary" type="button" value="수정" onclick="location.href='suggest_update.do?sug_num=${dto.sug_num}'">
                    	<input id="btn3" class="btn btn-danger" type="button" value="삭제" onclick="location.href='suggest_delete.do?sug_num=${dto.sug_num}'">
                    </c:if>
                </div>
			<br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
