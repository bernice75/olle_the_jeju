<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>제주상황 Main</title>
        <link href="<%=request.getContextPath() %>/resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath() %>/resources/css/footer.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="wrapper">
            <div class="logo item">
                <a href="../index.html"><img class="logo" src="../img/logo.png"></a>
            </div>
            <div class="header item">
                <div class="headerbtn">
                    <button>로그인</button>
                    <button>회원가입</button>
                </div>
            </div>
            <div class="nav item">
                <ul class="navi">
                    <li><a href="#">Home</a></li>
                    <li>
                        <a href="#">관광일정<i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                        <ul>
                            <li><a href="#">관광명소</a></li>
                            <li><a href="#">착한가격업소</a></li>
                            <li><a href="#">맛집15선</a></li>
                            <li><a href="#">방언사전</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">추천일정</a>
                    </li>
                    <li><a href="#">나만의일정</a></li>
                    <li>
                        <a href="./jejusituation.html">제주상황<i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                        <ul>
                            <li><a href="./jejusituation_corona.jsp">코로나상황</a></li>
                            <li><a href="./jejusituation_complexity.jsp">관광지혼잡도</a></li>
                            <li><a href="./jejusituation_rest.jsp">맛집예약/현황</a></li>
                        </ul>
                    </li>
                    <li><a href="#">고객지원</a></li>
                </ul>
            </div>

            <div class="main">
                <!-- 제주 상황 메인 이미지 -->
                <div class="main-img">
                    <div class="main-img-text">
                        <div class="main-img-text1">제주상황</div>
                        <div class="main-img-text2">
                            제주도 여행을 계획중이신가요?<br/>
                            여행 전 혹은 여행 중에 코로나 및 맛집, 관광지 상황을 확인해보고 가시는 것은 어떨까요?
                        </div>
                    </div>
                </div>
                <!-- 썸네일 -->
                <div class="nail">
                    <div class="middle-text">
                        어떤 것을 확인해볼 수 있나요?
                    </div>
                    <div class="nail1 items">  
                        <a href="#"><img class="corona-situation" src="../img/jeju_map.PNG" alt=""/></a>
                        <div class="nail-title">
                            <p>제주 코로나 상황</p>
                        </div>
                    </div>                   
                    <div class="nail2 items" onclick="location.href='';">
                        <img class="corona-situation" src="../img/traffic.jpg" alt="실시간 관광지 혼잡도"/>
                        <div class="nail-title">
                            <p>실시간 관광지 혼잡도</p>
                        </div>
                    </div>
                    <div class="nail3 items">
                        <a href="#"><img class="corona-situation2" src="../img/line_up.png" alt="맛집 예약 및 현황"/></a>
                        <div class="nail-title">
                            <p>맛집 예약 및 현황</p>
                        </div>
                    </div>
                </div>
                <br><br><br>
            </div>
                
            <!-- footer -->
            <footer class="footer item">
                <div class="aboutUs">
                    <div class="olle_inner_wrap">
                        <div class="info">About Us</div>
                        <div class="business_info">
                            <ul class="txtWrap">
                                <li style="color:#86868c">상상속 여행을 현실로, 올레더제주</li>
                                <li style="color:#86868c">contact : ollethejeju@gmail.com</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="navigations">
                    <div class="olle_inner_wrap">
                        <div class="info">Navigations</div>
                        <div class="business_nav">
                            <ul class="txtWrap nav1">
                                <li style="color:#86868c">Home</li>
                                <li style="color:#86868c">관광일정</li>
                                <li style="color:#86868c">추천일정</li>
                            </ul>
                            <ul class="txtWrap nav2">
                                <li style="color:#86868c">나만의 일정</li>
                                <li style="color:#86868c">제주상황</li>
                                <li style="color:#86868c">고객지원</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="jejuMap">
                    <div class="olle_inner_wrap">
                        <div class="info">JeJu Map Down</div>
                        <div class="business_info">
                            <i class="fa fa-map fa-5x" aria-hidden="true"></i>
                        </div>
                    </div>
                </div>
                <div class="copyright">Copyright@ 2021 Alll rights reserved</div>
            </footer>
        </div>
    </body>
</html>