<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제주상황 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/jejusituation/jejusituation.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/suggest/suggest_main.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
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
                        <a href="#"><img class="corona-situation" src="./resources/img/jeju_map.PNG" alt=""/></a>
                        <div class="nail-title">
                            <p>제주 코로나 상황</p>
                        </div>
                    </div>                   
                    <div class="nail2 items" onclick="location.href='';">
                        <img class="corona-situation" src="./resources/img/traffic.jpg" alt="실시간 관광지 혼잡도"/>
                        <div class="nail-title">
                            <p>실시간 관광지 혼잡도</p>
                        </div>
                    </div>
                    <div class="nail3 items">
                        <a href="#"><img class="corona-situation2" src="./resources/img/line_up.png" alt="맛집 예약 및 현황"/></a>
                        <div class="nail-title">
                            <p>맛집 예약 및 현황</p>
                        </div>
                    </div>
                </div>
                <br><br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>