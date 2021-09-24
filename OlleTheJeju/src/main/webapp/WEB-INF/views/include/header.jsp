<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>
	</head>
	<body>
       <div class="logo item">
           <a href="home.do?user_id=${sessionScope.user_id}"><img class="logo" src="./resources/img/logo.png"></a>
       </div>
       <div class="header item">
           <div class="headerbtn">
           <c:choose>
	           	<c:when test="${sessionScope.idChk == false }">
	           		<button type="button"class="btn btn-warning" onclick="location.href='loginForm.do'">로그인</button>
	            	<button type="button" class="btn btn-info" onclick="location.href='joinForm.do'">회원가입</button>
	           	</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${sessionScope.user_id eq 'admin' }">
							<button type="button"class="btn btn-warning" onclick="location.href='admin_main.do'">관리자페이지</button>
							<button type="button"class="btn btn-warning" onclick="logout();">로그아웃</button>
						</c:when>
						<c:otherwise>
							<button type="button"class="btn btn-warning" onclick="location.href='mypage_main.do?user_id=${sessionScope.user_id}'">${sessionScope.user_id}님의 마이페이지</button>
							<button type="button"class="btn btn-warning" onclick="logout();">로그아웃</button>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
           </c:choose>
           </div>
       </div>
       <div class="nav item">
           <ul class="navi">
               <li><a href="home.do?user_id=${sessionScope.user_id}">Home</a></li>
               <li>
                   <a href="trip_main.do?user_id=${sessionScope.user_id}">관광일정</a>
               </li>
               <li>
                   <a href="suggest_main.do?user_id=${sessionScope.user_id}">추천일정</a>
               </li>
               <li><a href="customplan_main.do?user_id=${sessionScope.user_id}">나만의일정</a></li>
               <li>
                   <a href="jejusituation_main.do?user_id=${sessionScope.user_id}">제주상황<i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                   <ul class="slide two">
                     <li><a href="corona.do" title="코로나 상황">코로나상황</a></li>
                     <li><a href="https://www.visitjeju.net/kr/bigdatamap/" title="관광지 혼잡도" target="_blank">관광지혼잡도</a></li>
                     <li><a href="jejusituation_rest.do?page=1" title="맛집예약/현황">맛집예약/현황</a></li>
                   </ul>
               </li>
               <li><a href="notice_main.do?user_id=${sessionScope.user_id}">고객지원</a></li>
           </ul>
       </div>
	</body>
	<script type="text/javascript">
		function logout() {
			if(confirm("정말 로그아웃 하시겠습니까?")) {
				//예 눌렀을 경우
				alert("정상적으로 로그아웃 되었습니다.");
				location.href="logout.do";
			}
		}
	</script>
</html>
