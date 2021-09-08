<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 main</title>
		
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/mypage/mypage_main.css" rel="stylesheet" type="text/css" />
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
	        <!-- 유저 정보 입력 -->
	        <main class="main item">
	            <div class="user_update">
	                <div class="update_title">
	                    <p style="font-size: 25px;"><b>회원 정보 수정</b></p>
	                </div>
	                <div class="user_img">
	                    <div id='previewId' style='width: 100px; height: 100px; position: absolute; '></div>
	                </div>
	                <div class="img_update">
	                    <input type="file" id="ex_file" name="poster" onchange="previewImage(this,'previewId')">
	                    <p style="font-size: 11px;">1mb 이하의 JPEG파일만 등록 가능합니다</p>
	                </div>
	                <br><br>
	                <!-- 우측, 유저 정보 form -->
	                <form id="mypage_form" name="mypage_form" action="userController" method="post">
	                    <input type="hidden" name="command" value="info_update">
	                    
	                    <div class="mb-3 row">
	                        <label for="name" class="col-sm-3 col-form-label">이름</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="name" value="${userdetail.name }" readonly="readonly">
	                        </div>
	                    </div>
	                    
	                    <!-- 별명을 변경한 경우, 변경 확인을 통해 진행해야 함 -->
	                    <div class="mb-3 row">
	                        <label for="nickname" class="col-sm-3 col-form-label">닉네임</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="nickname" value="${userdetail.nickname }" readonly="readonly">
	                        </div>
	                        <!--<button class="btn btn-default">변경</button>-->
	                    </div>
	                                
	                    <div class="mb-3 row">
	                        <label for="id" class="col-sm-3 col-form-label">아이디</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="id" value="${userdetail.id }" readonly="readonly">
	                        </div>
	                    </div>
	                    
	                    <div class="mb-3 row">
	                        <label for="password" class="col-sm-3 col-form-label">기존 비밀번호</label>
	                        <div class="col-sm-6">
	                            <input type="password" class="form-control" id="password" name="password" value="${userdetail.password }">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="newpassword" class="col-sm-3 col-form-label">신규 비밀번호</label>
	                        <div class="col-sm-6">
	                            <input type="newpassword" class="form-control" id="newpassword" name="newpassword" value="${userdetail.newpassword }">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="email" class="col-sm-3 col-form-label">이메일</label>
	                        <div class="col-sm-6">
	                            <input type="email" class="form-control" id="email" value="${userdetail.email }" readonly="readonly">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="gender" class="col-sm-3 col-form-label">성별</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="gender" value="${userdetail.gender }" readonly="readonly">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="phone" class="col-sm-3 col-form-label">전화번호</label>
	                        <div class="col-sm-6">
	                            <input type="phone" class="form-control" id="phone" value="${userdetail.phone }" readonly="readonly">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="birth" class="col-sm-3 col-form-label">생년월일</label>
	                            <div class="col-sm-2">
	                                <input type="year" class="form-control" id="year" value="${userdetail.year }" readonly="readonly">
	                            </div>
	                            <div class="col-sm-1">
	                                <input type="month" class="form-control" id="month" value="${userdetail.month }" readonly="readonly">
	                            </div>
	                            <label for="month" class="col-sm-1 col-form-label">월</label>
	                            <div class="col-sm-1">
	                                <input type="date" class="form-control" id="date" value="${userdetail.date }" readonly="readonly">
	                            </div>
	                            <label for="date" class="col-sm-1 col-form-label">일</label>
	                    </div>
	
	                    <div class="mb-3 row">
	                        <label for="address" class="col-sm-3 col-form-label">주소</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="address1" name="address1" value="${userdetail.address }" readonly="readonly">
	                        </div>
	                        <div class="col-sm-2">
	                            <input type="button" class="btn btn-primary btn-block" onclick="addressForm();" value="주소찾기">
	                        </div>
	                    </div>
	                    <div class="mb-3 row">
	                        <label for="address" class="col-sm-3 col-form-label">상세주소</label>
	                        <div class="col-sm-6">
	                            <input type="text" class="form-control" id="address2" name="address2" value="${userdetail.address_detail }" >
	                        </div>
	                    </div>
	                    <div class="btn_group">
	                        <input type="button" class="btn btn-primary btn-block" onclick="location.href='../page_mypage/mypageplan.html'" value="취소">
	                        <input type="button" class="btn btn-primary btn-block" onclick="updateCheck();" value="정보수정">
	                        <!-- <input type="button" class="btn btn-primary btn-block" onclick="" value="회원탈퇴"> -->
	                        <!-- Button trigger modal -->
	                        <button type="button" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#staticBackdrop">회원탈퇴</button>
	                        <!-- Modal 시작 -->
	                        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	                            <div class="modal-dialog">
	                            <div class="modal-content">
	                                <div class="modal-header">
	                                <h5 class="modal-title" id="staticBackdropLabel">회원 탈퇴</h5>
	                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	                                </div>
	                                <form action="userController" method="POST">
	                                <input type="hidden" name="command" value="userleave">
	                                    <div class="modal-body" >
	                                        <p class="modal-text1">탈퇴 후 재 로그인이 불가능합니다.</p>
	                                        <p class="modal-text2">정말 탈퇴 하시겠습니까 ? 비밀번호를 입력하세요.</p>
	                                        <br>
	                                        <div class="col-sm-6">
	                                            <input type="text" class="form-control" id="leave-pw" name="leave-pw" value="${userdetail.leave-pw }" >
	                                        </div>
	                                        <br>
	                                    </div>
	                                    <div class="modal-footer">
	                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	                                        <button type="submit" class="btn btn-primary">회원탈퇴</button>
	                                    </div>
	                                </form>
	                            </div>
	                            </div>
	                        </div>
	                        <!-- Modal 끝-->
	                    </div>
	                    <br>
	                </form>
	            </div> 
	        </main>
	        <br><br><br><br>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>