<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>OLLE THE JEJU</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/index.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/index.js" rel="script" type="text/javascript"></script>
    </head>
	<body>
		<div class="wrapper">
			<jsp:include page="./include/header.jsp"></jsp:include>
			<div class="main">
				<div class="main-img">
                    <div class="main-img-text"></div>
                </div>

                <br><br><br><br><br><br>
                <div class="main-text">
                    <h3>OLLE THE JEJU는 제주도 여행에서</h3>
                    <h3>나만의 Private 한 장소들을 공유 할수 있는 서비스 플랫폼입니다</h3>
                    <br>
                    <p>선별된 관광명소, 맛집, 추천일정, 회원들의 일정을 함께 공유해 보세요</p>
                </div>
                <br><br>
                <div class="nail">
                    <div class="nail1" onclick="location.href='trip_main.do?user_id=${sessionScope.user_id}'">
                        <div class="nail1-text">관광일정</div>
                    </div>
                    <div class="nail2" onclick="location.href='suggest_main.do?user_id=${sessionScope.user_id}'">
                        <div class="nail2-text">추천일정</div>
                    </div>
                    <div class="nail3" onclick="location.href='customplan_main.do?user_id=${sessionScope.user_id}'">
                        <div class="nail3-text">나만의일정</div>
                    </div>
                    <div class="nail4" onclick="location.href='jejusituation_main.do?user_id=${sessionScope.user_id}'">
                        <div class="nail4-text">제주상황</div>
                    </div>
                </div>
                <br><br><br><br><br><br>
                <div class="main-text">
                    <h3>HOT PLACE</h3>
                    <p>추천이 가장 많은 인기 장소 10곳을 소개합니다.</p>
                </div>
                <br>
                
                    <div class="slide_wrapper">
                        <ul class="slides">
                            <!-- 이미지랑 title은 나중에 작성된 게시글에서 추천수 top10에서 받아와야함-->
                            <li onclick="location.href='#'">  
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li nclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                            <li onclick="location.href='#'">
                                <img src="http://placehold.it/200x200" alt="">
                                <div class="hotpl-title">핫플레이스 제목</div>
                            </li>
                        </ul>
                    </div>
                    <p class="controls">
                        <span class="prev"><i class="fa fa-angle-double-left"></i></span>
                        <span class="next"><i class="fa fa-angle-double-right"></i></span>
                    </p>
  
                <br><br><br><br><br><br><br>
                <div class="main-text">
                    <h3>OLLE THE JEJU의 제작자를 소개합니다</h3>
                </div>
                <br><br>
                <!-- 팀원 순서는 팀장 1순위/ 나머지는 ㄱㄴㄷ-->
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>김미림</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>이승준</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>이재전</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>박인정</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>정지수</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="devel">
                    <div class="devel_img">
                        <div class="devel_img_box"></div>
                    </div>
                    <div class="devel_text">
                        <div class="devel_text_box">
                            <div class="name">
                                <h3>정현구</h3>
                            </div>
                            <div class="duty">총괄 기획 및 설계 / 관리자페이지, 나만의일정 구현</div>
                            <div class="explain">추가설명<br>추가설명<br>추가설명<br>추가설명</div>
                        </div>
                    </div>
                </div>
                <br><br><br><br><br><br>
                <div class="covid" onclick="location.href='https:/www.visitjeju.net/kr/bigdatamap/';">
                    <div class="covid_text covid_text1">제주 실시간 관광지별 안전도, 혼잡도 "한눈에"</div>
                    <div class="covid_text covid_text2">실시간 관광지 혼잡도 분석서비스</div>
                </div>
                <br><br><br><br>
			</div>
			<jsp:include page="./include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
