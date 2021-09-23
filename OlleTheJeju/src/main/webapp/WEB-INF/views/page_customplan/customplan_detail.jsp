<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나만의 일정 detail</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/customplan/customplan_detail.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx142479165b1048a5b99ae1b5a05f5d1b"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/customplan/customplan_detail.js" type="text/javascript"></script>
        <script type="text/javascript">
	        var map;
	        var markers = []; //마커병합 저장
			var tripList = ${trip};
			var trip_markers = [];
			var trip_label = [];
			var trip_title = [];
			var trip_address = [];
			var trip_phoneno = [];
			var content = [];
			
			for(idx in tripList) {
	        	trip_markers[idx] = new Tmapv2.LatLng(tripList[idx].latitude, tripList[idx].longitude);
	        	trip_label[idx] = tripList[idx].label;
	        	trip_title[idx] = tripList[idx].title;
	        	trip_address[idx] = tripList[idx].address;
	        	trip_phoneno[idx] = tripList[idx].phoneno;
	        }
			
      		// 페이지가 로딩이 된 후 호출하는 함수입니다.
			function initTmap(){
				// map 생성
				// Tmapv2.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다
				map = new Tmapv2.Map("map_div", {
				 	center: new Tmapv2.LatLng(33.506336, 126.49514),// 지도 초기 좌표
				 	width: "770px", // map의 width 설정
				 	height: "600px" // map의 height 설정
			 	});
		
			 	// 지도 객체 생성 후 마커를 등록하는 함수를 수행합니다.
			 	addMarkersTooMuch();
		 	}
      		
			function addMarkersTooMuch() {
				removeMarkers(); // 지도에 새로 등록하기 위해 모든 마커를 지우는 함수입니다.
				
				for (idx in tripList) {
					//마커 객체 생성
					var marker_trip = new Tmapv2.Marker({
						position: trip_markers[idx], //Marker의 중심좌표 설정.
						icon: "./resources/img/marker_trip.png",
 						label: trip_label[idx], //Marker의 라벨.
 						title: trip_title[idx], //Marker 타이틀. 
						/* content: content, //Popup 표시될 text */
						border:'0px solid #FF0000',//Popup의 테두리 border 설정.
						type: 2, //Popup의 type 설정.
						map: map //Marker가 표시될 Map 설정.
					});
					marker_trip.setMap(map); //Marker가 표시될 Map 설정.
		            markers.push(marker_trip);
					
		            var content= "<div class='popup' style='position: static; top: 320px; left : 320px; height: fit-content !important; display: flex; font-size: 14px; box-shadow: 5px 5px 5px #00000040; border-radius: 10px; width : 400px; height:100px; background-color: rgba(0, 0, 0, 0.6); align-items: center; padding: 5px; color: #fff;'>"+
					   "<div class='img-box' style='width: 110px; height: 90px; border-radius: 10px; background: #f5f5f5 url(resources/images/sample/p-sk-logo.png) no-repeat center;'>"+
					   "<input type='button' style='margin-top: 31px;' class='btn-primary addList' value='추가' onclick='addList(this);'></div>" +
					   "<div class='info-box' style='margin-left: 10px;'>"+
					   "<p style='margin-bottom: 7px;'>"+
					   "<span class='tit' style=' font-size: 16px; font-weight: bold;'>"+trip_title[idx]+"</span>"+
					   "<p>"+
					   "<span class='new-addr'>"+trip_address[idx]+"</span>"+
					   "</p>"+
					   "<p>"+
					   "<span class='old-addr'>"+trip_phoneno[idx]+"</span>"+
					   "</p>"+
					   "<p style='display:none'>"+
					   "<span class='old-addr'>"+tripList[idx].latitude+"</span>"+
					   "</p>"+
					   "<p style='display:none'>"+
					   "<span class='old-addr'>"+tripList[idx].longitude+"</span>"+
					   "</p>"+
					   "</div>"+
					   "<button type='button' class='btn-close' aria-label='close' style='position: absolute; top: 10px; right: 10px; display: block; width: 15px; height: 15px;' onclick='infoWindow.setVisible(false);'></button>" +
					   "</div>";
					//클릭 시 팝업창 오픈
		            openPopup(tripList[idx].latitude, tripList[idx].longitude, content);
				};
				
				function openPopup(lat, lon, content) {
	        		marker_trip.addListener("click", function(evt) {
	        			//Popup 객체 생성.
	        			infoWindow = new Tmapv2.InfoWindow({
	        			position: new Tmapv2.LatLng(lat, lon), //Popup 이 표출될 맵 좌표
	        			content: content, //Popup 표시될 text
	        			type: 2, //Popup의 type 설정.
	        			map: map //Popup이 표시될 맵 객체
	        			});
	    			});
	        	}
				
				function onClose(popup){
	        		infoWindow.setVisible(false);
	        	}
			}
			
			//addList를 삭제하는 버튼 함수
			function deleteList(obj){
				$(obj).parent().remove();
			}
			
			// 모든 마커를 제거하는 함수입니다.
			function removeMarkers() {
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(null);
				}
				markers = [];
			}
        </script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>나만의 일정</h2>
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
                            
                        <c:choose>
                            <c:when test="${empty ImgDto} ">
                            
                            </c:when>
                            	<c:otherwise>
                            	<c:forEach var="img" items="${ImgDto}">
	                            	<div class="carousel-item active">
	                                	<img src="./resources/plan/${img.img_title}" class="d-block w-100" alt="...">
	                            	</div>
                            	</c:forEach>
                            </c:otherwise>
                        </c:choose>
                            
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
                        <!--타이틀 -->
                        <h4>${CustomDto.plan_title }</h4>
                        <div class="name">
                        	<!-- 작성자 -->
                            <h6><strong>작성자</strong> | ${CustomDto.plan_writer }</h6>
                            <h6 class="like"><i class="fa fa-heart-o" aria-hidden="true"></i> | 100</h6>
                            <h6><i class="fa fa-thumb-tack" aria-hidden="true"></i> | 100</h6>
                            <h6><i class="fa fa-bullhorn" aria-hidden="true"></i> | 신고</h6>
                        </div>
                        <div class="content">
                            ${CustomDto.plan_content }
                        </div>
                        <div class="tag">
                            <h6 class="day"><strong>기간</strong> | 1박2일</h6>
                            <h6 class="regdate"><strong>작성일</strong> | 
                            	<fmt:formatDate var="Regdate" value="${CustomDto.plan_regdate }" pattern="yyyy/MM/dd"/>
                            	${Regdate }</h6>
                            <h6 class="den"><strong>성향</strong> | ${CustomDto.plan_tendency }</h6>
                            <h6 class="hash"><strong>태그</strong> | ${HashDto.hash_content }</h6>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="suggest_text">
                    <h3>일정등록</h3>
                    <hr class="line">
                    <div class="main-second">
             			<div id="map_div"></div>
                        <div class="map_list">
                        	<c:choose>
                        	<c:when test="${empty DateDto }">
                        		
                        	</c:when>
                        	<c:otherwise>
                        		<c:forEach var="date" items="${DateDto }">
                        			<div class=list_inner>
				                        <p class=list_title ><b>1. 코스명</b></p>
				                        <p class=list_title><input type=text value= "${date.date_name }" style=width:200px readonly=readonly></p>
				                        <p class=list_addr><b>2. 주소</b></p>
				                        <p class=list_addr><input type=text value= "${date.date_addr }" style=width:200px readonly=readonly></p>
				                        <p class=list_phone><b>3. 전화번호</b></p>
				                        <p class=list_phone><input type=text value= "${date.date_phone }" style=width:200px readonly=readonly></p>
	                    			</div>
                        			<input type="hidden" id="date_lat" value="${date.date_lat }">
                        			<input type="hidden" id="date_lon" value="${date.date_lon }">
                        			<input type="hidden" id="date_name" value="${date.date_name }">
                        			<input type="hidden" id="date_addr" value="${date.date_addr }">
                        			<input type="hidden" id="date_phone" value="${date.date_phone }">
                        		</c:forEach>
                        	</c:otherwise>
                        </c:choose>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="bottom-btn-group2">
                    <input id="btn1" class="btn btn-secondary" type="button" value="목록" onclick="location.href='customplan_main.do'">
                    <input id="btn2" class="btn btn-primary" type="button" value="수정" onclick="location.href='customplan_updateform.do?plan_num=${CustomDto.plan_num }'">
                    <input id="btn3" class="btn btn-danger" type="button" value="삭제" onclick="location.href='customplan_delete.do?plan_num=${CustomDto.plan_num }'">
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>