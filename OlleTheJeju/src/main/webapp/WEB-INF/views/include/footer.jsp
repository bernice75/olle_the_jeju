<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>footer</title>
	</head>
	<body>
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
                             <a href="home.do?user_id=${sessionScope.user_id}""><li style="color:#86868c">Home</li></a>
                             <a href="trip_main.do?user_id=${sessionScope.user_id}"><li style="color:#86868c">관광일정</li></a>
                             <a href="suggest_main.do?user_id=${sessionScope.user_id}"><li style="color:#86868c">추천일정</li></a>
                         </ul>
                         <ul class="txtWrap nav2">
                             <a href="notice_main.do?user_id=${sessionScope.user_id}"><li style="color:#86868c">고객지원</li></a>
                             <a href="jejusituation_main.do?user_id=${sessionScope.user_id}"><li style="color:#86868c">제주상황</li></a>
                             <a href="customplan_main.do?user_id=${sessionScope.user_id}"><li style="color:#86868c">나만의 일정</li></a>
                         </ul>
                     </div>
                 </div>
             </div>
             <div class="jejuMap">
                 <div class="olle_inner_wrap">
                     <div class="info">JeJu Map Down</div>
                     <div class="business_info">
                         <a href="#"><i class="fa fa-map fa-5x" aria-hidden="true"></i></a>
                     </div>
                 </div>
             </div>
             <div class="copyright">Copyright@ 2021 Alll rights reserved</div>
         </footer>
	</body>
</html>