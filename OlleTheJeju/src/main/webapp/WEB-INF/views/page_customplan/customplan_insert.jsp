<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나만의 일정 insert</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/customplan/customplan_insert.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/customplan/customplan_insert.js" type="text/javascript"></script>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx142479165b1048a5b99ae1b5a05f5d1b"></script>
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
	<body onload="initTmap()">
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2 style="font-family: 'cafe24_djh';">나만의 일정</h2><br>
                    <p style="font-family: 'cafe24_sph'; font-size: 18px;">세계적으로 유명한 유네스코 자연유산과 세계지질공원 등을 직접 찾아가보는 여행코스는 남다른 의미가 있습니다!<br>
                        당일 여행부터 4일 이상의 여행까지,<br>
                        개인의 취향과 시간에 맞게 다양한 여행 일정을 계획해 더욱 즐거운 제주도 여행을 경험하세요!</p><br><br>
                    <h2>사진 첨부 및 게시글 등록</h2>
                </div>
                <br>
                <form action="customplan_insert.do" method="post" enctype="multipart/form-data">
                	<input type="hidden" name="plan_writer" value="${sessionScope.user_id }">
                    <div class="main-place">
                        <div id="carouselExampleFade" class="carousel slide carousel-fade slider" data-bs-ride="carousel">
                            <div class="carousel-inner imgs">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" alt="...">
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
                        <div class="place-info">
                            <fieldset>
                                <section>
                                    <label for="sug_title">제목 : </label>
                                    <input type="text" class="form-control" name="plan_title">
                                </section>
                                <section>
                                    <label for="sug_content">내용 : </label>
                                    <textarea rows="10" cols="40" class="form-control" name="plan_content"></textarea>
                                </section>
                                <section>
                                    <label for="plan_term" style="margin-right: 90px;">시작일 : <input type="date" id="plan_term" class="form-control plan_term_start" name="plan_term_start"></label>
                                    <label for="plan_term">마감일 : <input type="date" class="form-control plan_term_end" name="plan_term_end" onchange="date();"></label>
                                </section>
                                <section>
                                    <label for="tendency">성향 : </label>
                                    <div class="btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tend_content" value="혼자"> 혼자
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tend_content" value="여자끼리"> 여자끼리
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tend_content" value="남자끼리"> 남자끼리
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tend_content" value="연인"> 연인
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tend_content" value="가족"> 가족
                                        </label>  
                                    </div>
                                </section>
                                <section>
                                    <label for="hash_content">해시태그 : </label>
                                    <input type="text" class="form-control" id="hashtag" placeholder="콤마(,)로 구분" onchange="hash();">
                                    <input type="hidden" class="form-control hashtag" name="hash_content">
                                    <div class="hash_inner"></div>
                                </section>
                            </fieldset>
                        </div>
                        <fieldset>
                            <section>
                                <input type="file" class="insert-btn" name="img_1" style="float: left;" accept="image/*">
                                <input type="file" class="insert-btn" name="img_2" style="float: left;" accept="image/*">
                                <input type="file" class="insert-btn" name="img_3" style="float: left;" onchange="fileUpload();" accept="image/*">
                                <button class="btn btn-outline-success chk-btn" type="button" style="float: right;" onclick="imgChk();">미리보기</button>
                            </section>
                        </fieldset>
                    </div>

                	<br><br>
                    <div class="suggest_text">
                        <div class="day-btn">
                            <h3>일정 등록</h3>
                        </div>
                        <hr class="line">
                        <div class="main-second">
                            <div id="map_div"></div>
                            <div class="map_list"></div>
                        </div>
                    </div>
                    <br><br>
                    <div class="bottom-btn-group2">
                        <input id="btn1" type="submit" class="btn btn-primary" value="등록" onclick="location.href='customplan_insert.do'">
                        <input id="btn2" type="button" class="btn btn-secondary" value="취소" onclick="location.href='customplan_main.do'">
                    </div>
                </form>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
		<script type="text/javascript">
			//map list에 list 추가하는 메서드
			function addList(obj){
				var title = $(obj).parent().next().children('p')[0].innerText;
	    		var addr = $(obj).parent().next().children('p')[1].innerText;
	    		var phone =  $(obj).parent().next().children('p')[2].innerText;
	    		var lat = $(obj).parent().next().children('p')[3].innerText;
	    		var lon =  $(obj).parent().next().children('p')[4].innerText;
	    		
				var dataInfo = $(
	                    "<div class='list_inner'>"+
	                        "<p class='list_title' ><b>1. 코스명</b></p>"+
	                        "<p class='lst_title'><input type='text' value='"+title+"' name='lst_title' style='width:200px;' readonly='readonly'></p>"+
	                        "<p class='list_addr'><b>2. 주소</b></p>"+
	                        "<p class='lst_addr'><input type='text' value='"+addr+"' name='lst_addr' style='width:200px;' readonly='readonly'></p>"+
	                        "<p class='list_phone'><b>3. 전화번호</b></p>"+
	                        "<p class='lst_phone'><input type='text' value='"+phone+"' name='lst_phone' style='width:200px;' readonly='readonly'></p>"+
	                        "<input type='hidden' name='lst_lat' value='" + lat + "'>" + 
	                        "<input type='hidden' name='lst_lon' value='" + lon + "'>" + 
	                        "<input type='button' value='삭제' onclick='deleteList(this);'>"+
	                    "</div>"
	                    );
				
				$(".map_list").append(dataInfo);
			}
		</script>
	</body>
</html>