<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 plan</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/admin/adminboard.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script type="text/javascript">
	        function showPopup(){
	            window.open("adminboardpopup.do","게시글 수정",
	            "width=800, height=800");
	        }
	    </script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<!-- adminpage nav -->
	        <div class="admin_nav">
	            <div class="admin_nav_align">
	                <p style="font-size: 22px;padding-left: 38px;">관리자페이지</p><br>
		            <ul style="list-style: none;">
		                <li><a href="admin.do">회원관리</a></li><br>
	                    <li><a href="admin_warn.do">신고 내역</a></li><br>
	                    <li><a href="admin_plan.do">게시물 관리</a></li><br>
	                    <li><a href="admin_inquire.do">문의 내역</a></li><br>
	              	</ul>
	            </div>
	        </div>
	
	        <!-- 게시글 관리  -->
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    <h3>게시글 관리</h3>
	                </div>
	            <br>
	        <!-- 관광 정보 -->
	        <div class="tour_info">
	            <div class="tour_info_title">
	                <p>관광정보</p>
	            </div>
	
	            <button class="btn btn-primary btn-block" onclick="">글쓰기</button>
	            <br><br>
	            <table class="table" border="1">
	                <tr>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">카테고리</th>
	                    <th style="text-align: center;">제목</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                    <th style="text-align: center;">조회</th>
	                    <th style="text-align: center;">추천</th>
	                </tr>
	                <tr>
	                    <td>1</td>
	                    <td>명소</td>
	                    <td><a href="" onclick="showPopup();">제주도 초보 여행 루트</a></td>
	                    <td>관리자</td>
	                    <td>20.05.12</td>
	                    <td>25</td>
	                    <td>0</td>
	                </tr>
	            </table>
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
	        <hr>
	        <br><br><br><br>
	        <!-- 추천 일정 -->
	        <div class="pick_plan">
	                <div class="pick_plan_title">
	                    <p>추천일정</p>
	                </div>
	            <button class="btn btn-primary btn-block" onclick="">글쓰기</button>
	            <br><br>
	            <table class="table" border="1">
	                <tr>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">카테고리</th>
	                    <th style="text-align: center;">제목</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                </tr>
	                <tr>
	                    <td>1</td>
	                    <td>편안</td>
	                    <td><a href="" onclick="showPopup();">제주도 초보 여행 루트</a></td>
	                    <td>관리자</td>
	                    <td>20.05.12</td>
	                </tr>
	            </table>
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
	        <hr>
	        <br><br><br><br>
	        <!-- 고객지원 -->
	        <div class="user_help">
	                <div class="user_help_title">
	                    <p>고객 지원</p>
	                </div>    
	            <table class="table" border="1">
	                <tr>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">제목</th>
	                    <th style="text-align: center;">내용</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                </tr>
	                <tr>
	                    <td>1</td>
	                    <td>문의 드립니다.</td>
	                    <td><a href="" onclick="showPopup();">문의 드립니다.</a></td>
	                    <td>user</td>
	                    <td>20.05.12</td>
	                </tr>
	            </table>
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
	        <hr>
	        <br><br><br><br>
	        <!-- 제주 상황 -->
	        <div class="jeju_wrong">
	                <div class="jeju_wrong_title">
	                    <p>제주 상황</p>
	                </div>  
	                <button class="btn btn-primary btn-block" onclick="">전체 선택</button>
	                <button class="btn btn-primary btn-block" onclick="">삭제</button>
	                <br><br>
	            <table class="table" border="1">
	                <tr>
	                    <td><input type="checkbox"></td>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">맛집 이름</th>
	                    <th style="text-align: center;">내용</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                </tr>
	                <tr>
	                    <td><input type="checkbox"></td>
	                    <td>1</td>
	                    <td>흑돼지 삼겹살 장인</td>
	                    <td><a href="" onclick="showPopup();">여기가 바로 맛집이다</a></td>
	                    <td>user</td>
	                    <td>20.05.12</td>
	                </tr>
	            </table>
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
	        <br><br><br>
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>