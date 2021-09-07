<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 plan</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/mypage/mypageplan.css" rel="stylesheet" type="text/css" />
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
			<!-- mypage 좌측 nav 시작 -->
	        <div class="myp_nav">
	            <div class="myp_nav_align">
	                <p style="font-size: 22px;padding-left: 30px;">마이페이지</p>
	                <br>
	                <ul style="list-style: none;">
	                    <li><a href="mypage_plan.do">나의 일정</a></li><br>
	                    <li><a href="mypage_inquire.do">문의 내역</a></li><br>
	                    <li><a href="mypage_main.do">회원 정보 수정</a></li><br>
	                    <li><a href="mypage_warn.do">신고 확인</a></li><br>
	              </ul>
	            </div>
	        </div>
	        <!-- mypage 좌측 nav 끝 -->
	
	        <!-- main 시작 -->
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    내가 작성한 일정
	                </div>
	            </div>
	            <!-- 나의 일정 -->
	            <div class="plan_thum">
	                <!-- jstl core foreach로 썸네일 목록 반복 -->
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	            </div>
	            <br>
	            <!-- 기능구현시 수정해야함 (연결하기)(아이콘 안보임)-->
	            <nav class="paging" aria-label="Page navigation example">
	                <ul class="pagination">
	                  <li class="page-item">
	                    <a class="page-link" href="#" aria-label="Previous">
	                      <span aria-hidden="true">&laquo;</span>
	                    </a>
	                  </li>
	                  <li class="page-item"><a class="page-link" href="#">1</a></li>
	                  <li class="page-item"><a class="page-link" href="#">2</a></li>
	                  <li class="page-item"><a class="page-link" href="#">3</a></li>
	                  <li class="page-item">
	                    <a class="page-link" href="#" aria-label="Next">
	                      <span aria-hidden="true">&raquo;</span>
	                    </a>
	                  </li>
	                </ul>
	              </nav>
	            <br><br>
	
	            <!-- 내가 찜한 일정 -->
	            <div class="user_pick">
	                <div class="pick_title">
	                    내가 찜한 일정
	                </div>
	            </div>
	            <br>
	            <!-- 내가 찜한 일정 -->
	            <div class="plan_thum">
	                <!-- jstl core foreach로 썸네일 목록 반복 -->
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	                <div class="thum_item" onclick="location.href='#'">
	                    <div class="img_thum">
	                        <a>
	                            <div class="nail_img">
	                                <!-- 기간 정보 데이터 받아와서 삽입 -->
	                                <div class="sleep">2박3일</div>
	                            </div>
	                        </a>
	                        <img class="">
	                    </div>
	                    <div class="thum_text">
	                        <div style="font-size: 20px;">제목입니다</div>
	                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">성향</span>
	                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
	                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
	                        <span class="thum_text_span1"style="font-size: 12px;">해시태그명</span>
	                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
	                        <br>
	                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;29 </span>
	                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
	                        <span class="thum_text_span2"style="font-size: 12px;">신고수&nbsp;&nbsp;|&nbsp;&nbsp;3</span>
	                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
	                    </div>
	                </div>
	            </div>
	            <br>
	            <!-- 기능구현시 수정해야함 (연결하기)(아이콘 안보임)-->
	            <nav class="paging" aria-label="Page navigation example">
	                <ul class="pagination">
	                  <li class="page-item">
	                    <a class="page-link" href="#" aria-label="Previous">
	                      <span aria-hidden="true">&laquo;</span>
	                    </a>
	                  </li>
	                  <li class="page-item"><a class="page-link" href="#">1</a></li>
	                  <li class="page-item"><a class="page-link" href="#">2</a></li>
	                  <li class="page-item"><a class="page-link" href="#">3</a></li>
	                  <li class="page-item">
	                    <a class="page-link" href="#" aria-label="Next">
	                      <span aria-hidden="true">&raquo;</span>
	                    </a>
	                  </li>
	                </ul>
	              </nav>
	            <br><br><br><br>
	        </main>
	        <!-- main 끝 -->
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>