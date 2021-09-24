<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 UPDATE</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/suggest/suggest_insert.css?var=2" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx142479165b1048a5b99ae1b5a05f5d1b"></script>
        <script type="text/javascript">
		var marker;
		var markerArr = [], labelArr = [];
		var Polyline = new Tmapv2.Polyline();
		
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
        	console.log("${dto.sug_kategorie}");
        	var kategorie = $("input:radio[value=${dto.sug_kategorie}]");
        	kategorie.attr("checked",true);
        	
        	var tendency = $("input:radio[value=${dto.sug_tendency}]");
        	tendency.attr("checked",true);
        	
        	$.ajax({
        		url:"suggest_detail_ajax.do?sug_num="+sug_num,
        		dataType:"JSON",
        		method:"GET",
        		success: function(data){
        			console.log(data[0].day[0].name);
        			Jdata = data;
        			console.log(Jdata);
        		
        		    
        		}
        	})
        	
        });
        
        function changeList(obj){
            var class_name = $(obj).attr('class'); //클래스명 저장
            class_name = class_name.split(' ')[2];
            
            var date = $(obj).text(); //내용 저장
            
            $(obj).siblings().attr('disabled', false); //나를 제외한 형제들 활성화

            //map_list 클래스를 가진 div가 있는가
            if($('div').hasClass("map_list") == true) {
                //이미 존재하는 map_list 중 버튼과 동일한 클래스를 가진 것이 있는가
                if($('.map_list').hasClass(class_name) == true) {
                	$('.map_list.'+class_name).siblings("div[name=map_show]").attr('name','map_list');
                    $('.map_list.'+class_name).siblings("div[name=map_list]").hide();
                    $('.map_list.'+class_name).show();
                    $('.map_list.'+class_name).attr('name','map_show');
                    mapMaker(class_name);
                } else {
                    $('.map_list').hide();
                    var map_list = document.createElement('div'); //일정목록을 감싸는 div
                    map_list.setAttribute('class', 'map_list ' + class_name);
                    map_list.setAttribute('name','map_show');
                    $('.main-second').append(map_list);
                    $('.map_list.'+class_name).siblings("div[name=map_show]").attr('name','map_list');
                    //div 클래스 중 버튼과 동일한 클래스인 경우에만 글 삽입
                    if($('.map_list.'+class_name).children().length == 0) {
                        var br = document.createElement('br');
                        var h5 = document.createElement('h5'); //n일차 지도리스트
                        var ta = document.createElement('input');
                        ta.setAttribute('name','sug_addr_arr');
                        ta.setAttribute('value','일수');
                        ta.setAttribute('type','hidden');
                        h5.setAttribute('name',class_name);
                        h5.innerHTML = date + " 지도리스트";
                        $('.map_list.'+class_name).append(h5);
                        $('.map_list.'+class_name).append(ta);
                        mapMaker(class_name);
                        
                    }
                }
            } else {
                var map_list = document.createElement('div'); //일정목록을 감싸는 div
                map_list.setAttribute('class', 'map_list ' + class_name);
                map_list.setAttribute('name','map_show');
                var br = document.createElement('br');
                var h5 = document.createElement('h5'); //n일차 지도리스트
                h5.setAttribute('name',class_name);
                h5.innerHTML = date + " 지도리스트";
                $('.main-second').append(map_list);
                $('.map_list').append(h5);
                $('.map_list').append(ta);
               	mapMaker(class_name);
         }
        } 
        
        function mapMaker(class_name){
        	var cnt = class_name-1;
        	var length = Jdata[cnt].day.length;
        	var x=3;
        	var hasSapn = $("div[name=map_show]").children("span").length;
        	
        	for(var i=0; i<length; i++){
        		lat = Jdata[cnt].day[i].lat;
        		lon = Jdata[cnt].day[i].lon;
        		name = Jdata[cnt].day[i].name;
        		var json = {
						name : name,
						lat : lat,
						lon : lon
				}
				var jjson = JSON.stringify(json)+'자르기';
        		
        		var text = "<span name='"+name+"' style='margin: 20px;' >"+name+"<input type='button' name='"+name+"' value='삭제' onclick='delete_list(this.name);'><input type='hidden' name='sug_addr_arr' value='"+jjson+"'></span>"; 
        		lonArr[i] = lon;
        		latArr[i] = lat;
        		
				if(hasSapn<length){
					$("div[name=map_show]").append(text);	
				}        		
        	}
        }
		
        function delete_list(name){
			$("span[name='"+name+"']").remove();
		}
		
		
		function initTmap() {
			// 1. 지도 띄우기
			map = new Tmapv2.Map("map_div", {
				center : new Tmapv2.LatLng(33.506336, 126.49514),
				width : "70%",
				height : "400px",
				zoom : 15,
				zoomControl : true,
				scrollwheel : true
			});
	
			// 2. POI 통합 검색 API 요청
			$("#btn_search").click(
				function() {
					//resettingMap();
					var searchKeyword = $('#searchKeyword').val(); // 검색 키워드
					$.ajax({
						method : "GET", // 요청 방식
						url : "https://apis.openapi.sk.com/tmap/pois?version=1&format=json&callback=result", // url 주소
						async : false, // 동기설정
						data : { // 요청 데이터 정보
							"appKey" : "l7xx142479165b1048a5b99ae1b5a05f5d1b", // 발급받은 Appkey
							"searchKeyword" : searchKeyword, // 검색 키워드
							"resCoordType" : "EPSG3857", // 요청 좌표계
							"reqCoordType" : "WGS84GEO", // 응답 좌표계
							"centerLon" : 126.49514, //POI검색시 중앙좌표의 경도입니다.
				            "centerLat" : 33.506336,	//POI검색시 중앙좌표의 위도입니다. 
							"count" : 10 // 가져올 갯수
						},
						success : function(response) {
							var resultpoisData = response.searchPoiInfo.pois.poi;
	
							// 2. 기존 마커, 팝업 제거
							if (markerArr.length > 0) {
								for(var i in markerArr) {
									markerArr[i].setMap(null);
								}
								markerArr = [];
							}
							
							if (labelArr.length > 0) {
								for (var i in labelArr) {
									labelArr[i].setMap(null);
								}
								labelArr = [];
							}
	
							var innerHtml = ""; // Search Reulsts 결과값 노출 위한 변수
							//맵에 결과물 확인 하기 위한 LatLngBounds객체 생성
							var positionBounds = new Tmapv2.LatLngBounds(); 
	
							// 3. POI 마커 표시
							for (var k in resultpoisData) {
								// POI 마커 정보 저장
								var noorLat = Number(resultpoisData[k].noorLat);
								var noorLon = Number(resultpoisData[k].noorLon);
								var name = resultpoisData[k].name;
								
								// POI 정보의 ID
								var id = resultpoisData[k].id;
	
								// 좌표 객체 생성
								var pointCng = new Tmapv2.Point(
										noorLon, noorLat);
								
								// EPSG3857좌표계를 WGS84GEO좌표계로 변환
								var projectionCng = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(
										pointCng);
	
								var lat = projectionCng._lat;
								var lon = projectionCng._lng;
	
								// 좌표 설정
								var markerPosition = new Tmapv2.LatLng(
										lat, lon);
	
								// Marker 설정
								marker = new Tmapv2.Marker(
									{
										position : markerPosition, // 마커가 표시될 좌표
										//icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_a.png",
										icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_"
												+ k
												+ ".png", // 아이콘 등록
										iconSize : new Tmapv2.Size(
												24, 38), // 아이콘 크기 설정
										title : name, // 마커 타이틀
										map : map // 마커가 등록될 지도 객체
									});
	
								// 결과창에 나타날 검색 결과 html
								innerHtml += "<li><div><img src='http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_" + k + ".png' style='vertical-align:middle;'/><span>"
										+ name
										+ "</span>  <input type='button' name='sendBtn' onClick='start("
										+ id
										+ ");' value='일정 추가'></div></li>"
								
								// 마커들을 담을 배열에 마커 저장
								markerArr.push(marker);
								positionBounds.extend(markerPosition); // LatLngBounds의 객체 확장
							}
	
							$("#searchResult").html(innerHtml); //searchResult 결과값 노출
							map.panToBounds(positionBounds); // 확장된 bounds의 중심으로 이동시키기
							map.zoomOut();
						},
						error : function(request, status, error) {
							console.log("code:"
									+ request.status + "\n"
									+ "message:"
									+ request.responseText
									+ "\n" + "error:" + error);
						}
					});
				});
		}
		//목록에 추가하기
		var st=0;
		function start(poiId) {
			console.log(poiId);
	
			$.ajax({
				method : "GET", // 요청 방식
				url : "https://apis.openapi.sk.com/tmap/pois/"
						+ poiId // 상세보기를 누른 아이템의 POI ID
						+ "?version=1&resCoordType=EPSG3857&format=json&callback=result&appKey="
						+ "l7xx142479165b1048a5b99ae1b5a05f5d1b", // 발급받은 Appkey
				async : false, // 동기 설정
				success : function(response) {
					console.log(response);
		
					// 응답받은 POI 정보
					var detailInfo = response.poiDetailInfo;
					var name = detailInfo.name;
					var address = detailInfo.address;
		
					var noorLat = Number(detailInfo.frontLat);
					var noorLon = Number(detailInfo.frontLon);
		
					var pointCng = new Tmapv2.Point(noorLon, noorLat);
					var projectionCng = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(
							pointCng);
		
					var lat = projectionCng._lat;
					var lon = projectionCng._lng;
		
					var labelPosition = new Tmapv2.LatLng(lat, lon);
					name, lat, lon
					var json = {
							name : name,
							lat : lat,
							lon : lon
					}
					var jjson = JSON.stringify(json)+'자르기';
					var text = "<span name='"+name+"' style='margin: 20px;' >"+name+"<input type='button' name='"+name+"' value='삭제' onclick='delete_list(this.name);'><input type='hidden' name='sug_addr_arr' value='"+jjson+"'></span>";
					
					$("div[name=map_show]").append(text);
					
					var labelInfo = new Tmapv2.Label({
						position : labelPosition,
						map : map
						
					});
					
					
					resultMarkerArr.push(marker);
					
					labelArr.push(labelInfo);
					
				},
				error : function(request, status, error) {
					console.log("code:" + request.status + "\n"
							+ "message:" + request.responseText + "\n"
							+ "error:" + error);
				}
			});
		}
		
		function delete_list(name){
			$("div[name=map_show]").children("span[name='"+name+"']").remove();
		}

	function date() {
		var length = $('.day-btn').children('button').length;
		$('#sug_term').remove();
	    var start = $('.sug_term_start').val() instanceof Date ? $('.sug_term_start').val() : new Date($('.sug_term_start').val());
	    var end = $('.sug_term_end').val() instanceof Date ? $('.sug_term_end').val() : new Date($('.sug_term_end').val());

	    start = new Date(start.getFullYear(), start.getMonth() + 1, start.getDate());
	    end = new Date(end.getFullYear(), end.getMonth() + 1, end.getDate());

	    var diff = Math.abs(end.getTime() - start.getTime());
	    diff = Math.ceil(diff / (1000 * 3600 * 24));
		var value = diff+"박"+(diff+1)+"일";
		
		
		var sug_term = "<input type='hidden' name='sug_term' value='"+value+"'>";
		
		$('.day-btn').append(sug_term);
	    console.log(value);
		
	    if(length>diff){
			$('.day-btn').empty();
			$('div[name=map_list]').remove();
			$('div[name=map_show]').remove();
	    	for(var i = 0; i < (diff+1); i++) {
	        	var button = document.createElement('button');
	        	button.setAttribute('class', 'btn btn-outline-dark ' +(i+1));
	        	button.setAttribute('type', 'button');
	        	button.setAttribute('onclick', 'changeList(this);');
	        	var btnText = document.createTextNode((i+1) + "일차");
	        	button.appendChild(btnText);
	        	$('.day-btn').append(button);
	    	}
	    }else{
	    	for(var i = length; i < (diff+1); i++) {
	        	var button = document.createElement('button');
	        	button.setAttribute('class', 'btn btn-outline-dark ' +(i+1));
	        	button.setAttribute('type', 'button');
	        	button.setAttribute('onclick', 'changeList(this);');
	        	var btnText = document.createTextNode((i+1) + "일차");
	        	button.appendChild(btnText);
	        	$('.day-btn').append(button);
	    	}
	    }
	}
		
		</script>
	</head>
	<body onload="initTmap()">
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>추천일정 등록</h2>
                </div>
                <br><br>
                <form action="suggest_update_db.do" method="get">
                <input type="hidden" id="sug_num" name="sug_num" value="${dto.sug_num }">
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
                                    <input type="text" class="form-control" name="sug_title" maxlength='21' value="${dto.sug_title }">
                                </section>
                                <section>
                                    <label for="sug_content">내용 : </label>
                                    <textarea rows="10" cols="40" class="form-control" name="sug_content" >${dto.sug_content }</textarea>
                                </section>
                                <section>
                               		<input type="hidden" name="writer" value="${sessionScope.user_id}">
                                    <label for="sug_term" style="margin-right: 90px;">시작일 : <input type="date" id="term" class="form-control sug_term_start" name="sug_term_start"></label>
                                    <label for="sug_term">마감일 : <input type="date" class="form-control sug_term_end" name="sug_term_end" onchange="date();"></label>
                                </section>
                                <section>
                                    <label for="tendency">성향 : </label>
                                    <div class="btn-group-toggle" data-toggle="buttons">
                                        <label class="btn">
                                            <input type="radio" name="sug_tendency" value="혼자" required> 혼자
                                        </label>
                                        <label class="btn">
                                            <input type="radio" name="sug_tendency" value="여자끼리"> 여자끼리
                                        </label>
                                        <label class="btn">
                                            <input type="radio" name="sug_tendency" value="남자끼리"> 남자끼리
                                        </label>
                                        <label class="btn">
                                            <input type="radio" name="sug_tendency" value="연인"> 연인
                                        </label>
                                        <label class="btn">
                                            <input type="radio" name="sug_tendency" value="가족"> 가족
                                        </label>  
                                    </div>
                                </section>
                                <section>
                                	<label for="kategorie">카테고리 : </label>
                                	<div class="btn-group-toggle">
                                	<label class="btn">
                                		<input type="radio" name="sug_kategorie" value="편안" required> 편안
                                	</label>
    								<label class="btn">
                                		<input type="radio" name="sug_kategorie" value="힐링"> 힐링
                                	</label>
                                	<label class="btn">
                                		<input type="radio" name="sug_kategorie" value="트레킹"> 트레킹
                                	</label>
                                	<label class="btn">
                                		<input type="radio" name="sug_kategorie" value="맛집"> 맛집
                                	</label>
                                	<label class="btn">
                                		<input type="radio" name="sug_kategorie" value="올레길"> 올레길
                                	</label>
                                	</div>
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
						<div class="map">
							<input type="text" class="text_custom" id="searchKeyword"
								name="searchKeyword" placeholder="검색">
							<span id="btn_search">적용하기</span>
						</div>
						<div class="map" style="width: 30%; float: left;">
							<div class="title">
								<strong>Search</strong> Results
							</div>
							<div class="rst_wrap">
								<div class="rst mCustomScrollbar">
									<ul id="searchResult" name="searchResult">
										<li>검색결과</li>
									</ul>
								</div>
							</div>
						</div>
						<div id="map_div" style="float: left; margin-bottom: 10px;"></div>
                        </div>
                    </div>
                    <div class="bottom-btn-group2">
                        <input id="btn1" type="submit" class="btn btn-primary" value="등록">
                        <input id="btn2" type="button" class="btn btn-secondary" value="취소" onclick="location.href='suggest_main.do?kategorie=전체&page=1'">
                    </div>
                </form>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>