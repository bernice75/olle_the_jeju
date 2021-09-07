<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/suggest/suggest_main.css" rel="stylesheet" type="text/css" />
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
				<br><br>
                <div class="main-text">
                    <h2>제주도를 즐기는 다양한 여행 일정 추천</h2>
                    <br>
                    <p>
                        세계적으로 유명한 유네스코 자연유산과 세계지질공원 등을 직접 찾아가보는 여행코스는 남다른 의미가 있습니다!<br>
                        당일 여행부터 4일 이상의 여행까지,<br>
                        개인의 취향과 시간에 맞게 다양한 여행 일정을 계획해 더욱 즐거운 제주도 여행을 경험하세요!
                    </p>
                </div>
                <br><br>
                <div class="menu">
                    <div class="menu1">전체</div>
                    <div class="menu2">편안한</div>
                    <div class="menu3">힐링</div>
                    <div class="menu4">트레킹</div>
                    <div class="menu5">맛집</div>
                    <div class="menu6">투어</div>
                    <div class="menu7">올레길</div>
                </div>
                <br>
                <div class="search">
                    <input class="form-control search1" type="search" placeholder="검색어 입력">
                    <button class="btn btn-outline-secondary search2"><i class="fa fa-search" aria-hidden="true"></i></button>
                </div>
                <br><br>
                <div class="nail">
                    <div class="nail1">
                        <a href="suggest_detail.do">
                            <div class="nail_img">
                                <div class="sleep">2박3일</div>
                            </div>
                        </a>
                        <div class="nail_inner">
                            <p class="nail_title">제목입니다</p>
                            <p class="nail_con_hash">컨셉명 | 해쉬태그명</p>
                            <span class="nail_view">조회수 | 10</span>
                            <span class="nail_like">추천수 | 2</span>
                            <hr style="margin-bottom: 0;">
                            <div class="nail_hrt"><i class="fa fa-heart-o fa-xs"></i> &nbsp; 찜하기</div>
                        </div>
                    </div>
                    <div class="nail2">
                        <a>
                            <div class="nail_img">
                                <div class="sleep">2박3일</div>
                            </div>
                        </a>
                        <div class="nail_inner">
                            <p class="nail_title">제목입니다</p>
                            <p class="nail_con_hash">컨셉명 | 해쉬태그명</p>
                            <span class="nail_view">조회수 | 10</span>
                            <span class="nail_like">추천수 | 2</span>
                            <hr style="margin-bottom: 0;">
                            <div class="nail_hrt"><i class="fa fa-heart-o fa-xs"></i> &nbsp; 찜하기</div>
                        </div>
                    </div>
                    <div class="nail3">
                        <a>
                            <div class="nail_img">
                                <div class="sleep">2박3일</div>
                            </div>
                        </a>
                        <div class="nail_inner">
                            <p class="nail_title">제목입니다</p>
                            <p class="nail_con_hash">컨셉명 | 해쉬태그명</p>
                            <span class="nail_view">조회수 | 10</span>
                            <span class="nail_like">추천수 | 2</span>
                            <hr style="margin-bottom: 0;">
                            <div class="nail_hrt"><i class="fa fa-heart-o fa-xs"></i> &nbsp; 찜하기</div>
                        </div>
                    </div>
                    <div class="nail4">
                        
                    </div>
                    <div class="nail5">
                        
                    </div>
                    <div class="nail6">
                        
                    </div>
                </div>
                <br>
                <div class="write">
                    <button class="btn btn-outline-secondary" onclick="location.href='suggest_insert.do'">글등록</button>
                </div>
                <br><br>
                <div class="paging">
                    페이징 처리
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>