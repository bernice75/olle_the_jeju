<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>
	</head>
	<body>
       <div class="logo item">
           <a href="home.do"><img class="logo" src="./resources/img/logo.png"></a>
       </div>
       <div class="header item">
           <div class="headerbtn">
	           	<button type="button"class="btn btn-warning" onclick="location.href='mypage_main.do'">마이페이지</button>
	           	<button type="button"class="btn btn-warning" onclick="location.href='admin_main.do'">관리자페이지</button>
	            <button type="button"class="btn btn-warning" onclick="location.href='login.do'">로그인</button>
	            <button type="button" class="btn btn-info" onclick="location.href='join.do'">회원가입</button>
           </div>
       </div>
       <div class="nav item">
           <ul class="navi">
               <li><a href="home.do">Home</a></li>
               <li>
                   <a href="trip_main.do">관광일정</a>
               </li>
               <li>
                   <a href="suggest_main.do">추천일정</a>
               </li>
               <li><a href="customplan_main.do">나만의일정</a></li>
               <li>
                   <a href="jejusituation_main.do">제주상황<i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                   <ul class="slide two">
                       <li><a href="#">코로나상황</a></li>
                       <li><a href="#">관광지혼잡도</a></li>
                       <li><a href="jejusituation_rest.do">맛집예약/현황</a></li>
                   </ul>
               </li>
               <li><a href="notice_main.do">고객지원</a></li>
           </ul>
       </div>
	</body>
</html>