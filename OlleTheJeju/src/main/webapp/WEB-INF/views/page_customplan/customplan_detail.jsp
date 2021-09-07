<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/customplan/customplan_detail.js" type="text/javascript"></script>
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
                        <h4>제주 우도 비밀의 여행지 숲속 힐링코스</h4>
                        <div class="name">
                            <h6><strong>작성자</strong> | 김미림</h6>
                            <h6 class="like"><i class="fa fa-heart-o" aria-hidden="true"></i> | 100</h6>
                            <h6><i class="fa fa-thumb-tack" aria-hidden="true"></i> | 100</h6>
                            <h6><i class="fa fa-bullhorn" aria-hidden="true"></i> | 신고</h6>
                        </div>
                        <div class="content">
                            제목은 21자 제한 필수일듯<br>
                            여기에는 내용이 들어간다.<br>
                            그냥 내용만 담을 것인가....
                            호로로롤ㄹ로롤롤오오오오오오옹<br>
                            미림 대장 화이팅
                        </div>
                        <div class="tag">
                            <h6 class="day"><strong>기간</strong> | 1박2일</h6>
                            <h6 class="regdate"><strong>작성일</strong> | 2021년 08월 31일</h6>
                            <h6 class="den"><strong>성향</strong> | 여자끼리</h6>
                            <h6 class="hash"><strong>태그</strong> | 힐링, 숲속</h6>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="suggest_text">
                    <h3>일정등록</h3>
                    <hr class="line">
                    <div class="main-second">
                        <div class="main-map">
                            <!-- css에 백그라운드로 이미지 삽입해놨습니다. 구현하실 때 지우시면 됩니다. -->
                            지도 삽입
                            <div class="map-lsit">
                                지도 리스트
                                <div class="list one">
                                    <div class="list_nail"></div>
                                    <div class="list_inner">
                                        <p class="course_name">1. 코스명</p>
                                        <br>
                                        <p class="distance"> - 거리</p>
                                        <p class="elapsed_time"> - 소요시간</p>
                                        <p class="taxi"> - 택시비</p>
                                    </div>
                                </div>
                                <div class="list two">
                                    <div class="list_nail"></div>
                                    <div class="list_inner">
                                        <p class="course_name">1. 코스명</p>
                                        <br>
                                        <p class="distance"> - 거리</p>
                                        <p class="elapsed_time"> - 소요시간</p>
                                        <p class="taxi"> - 택시비</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="bottom-btn-group2">
                    <input id="btn1" class="btn btn-secondary" type="button" value="목록" onclick="location.href='customplan_main.do'">
                    <input id="btn2" class="btn btn-primary" type="button" value="수정" onclick="">
                    <input id="btn3" class="btn btn-danger" type="button" value="삭제" onclick="">
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>