<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 main</title>
		
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/mypage/mypagewarn.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
        
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<br><br>
	        <!-- mypage nav -->
	        <div class="myp_nav">
	            <div class="myp_nav_align">
	                <p style="font-size: 22px;padding-left: 30px;">마이페이지</p>
	                <br>
	                <ul style="list-style: none;">
	                	<li><a href="mypage_main.do?user_id=${sessionScope.user_id}">회원 정보 수정</a></li>
	                    <li><a href="mypage_plan.do?plan_writer=${sessionScope.user_id}">나의 일정</a></li>
	                    <li><a href="mypage_inquire.do?user_id=${sessionScope.user_id}">문의 내역</a></li>
	                    <li><a href="mypage_warn.do?user_id=${sessionScope.user_id}">신고 확인</a></li>
	              </ul>
	            </div>
	        </div>
	
	        <!-- 경고 횟수 -->
	        <main class="main item">
	            <div class="user_warn">
	                <div class="warn_title">
	                    <p><b>신고 된 게시글</b></p>
	                </div>
	
	                <div class="warn_text">
	                    <p>- 게시글 누적 신고 3회일 경우 2주간 로그인 불가합니다.</p>
	                    <p>- 게시글 누적 신고 5회 이상일 경우 강제탈퇴 후 재가입이 불가해지니 유의해주세요</p>
	                </div>
	
	                <div class="warn_box">
	                    <div class="user_warn_text">
	                        <p>현재 <!-- user id jstl처리  --><b>${dto.user_name}</b> 님의 신고 된 게시글 횟수는</p>
	                        <p style="color: red;">
	                            <!-- user 경고 횟수 jstl처리  -->${dto.user_warning }회
	                        </p>
	                        <p>입니다.</p>
	                    </div>
	                </div>
	            </div>
	        </main>
	        <br><br><br><br><br><br>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>