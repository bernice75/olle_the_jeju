<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/login.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script src="./resources/js/login.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="include/header.jsp"></jsp:include>
			<div class="main">
                <form action="login.do" method="POST">
                    <header>네이버 아이디로 로그인</header>
                    <hr>
                    <fieldset>                  
                        <section>
                        <a href="${url }"><img src="./resources/img/naver_login.png"></a>
                        </section>
                    </fieldset>
                    <hr>
                    <header>OLLE THE JEJU 로그인</header>
                    <fieldset>                  
                        <section>
                            <div class="row">
                                <label class="label col col-4">아이디</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="user_id" id="user_id">
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">비밀번호</label>
                                <div class="input-group">
                                    <input type="password" class="form-control" name="user_pw" id="user_pw" autocomplete="off">
                                </div>
                            </div>
                        </section>
                        <div style="text-align:center">
                        	<a type="button" class="btn-u btn-u-lg" onclick="loginForm();">로그인</a>
                        	<a type="button" class="btn-u btn-u-lg" onclick="location.href='joinForm.do'">회원가입</a>
                            <br><br>
                            <p class="find" style="text-decoration: underline; cursor: help;" data-bs-toggle="modal" data-bs-target="#staticBackdrop">아이디/비밀번호 찾기</p>
                        </div>
                    </fieldset>
                </form>
                <!-- Modal 시작 -->
				<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			        <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
					            <h5 class="modal-title" id="staticBackdropLabel">아이디, 비밀번호 찾기</h5>
					            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            </div>
				            <div class="modal-body chatMiddle">
				            	<h6>아이디 찾기</h6>
				            	<div class="input-group mb-3">
									<input type="email" class="form-control user_email1" placeholder="이메일을 입력해주세요." aria-label="이메일을 입력해주세요." aria-describedby="button-addon2">
									<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="findId();">전송</button>
									<br>
								</div>
				            	<p class="findid" style="display: none; color: red;">이메일이 전송되었습니다. 확인해주세요.</p>
				            	<br><hr><br>
				            	<h6>비밀번호 찾기</h6>
				            	<input type="text" class="form-control user_id" placeholder="아이디를 입력해주세요.">
				            	<br>
				            	<div class="input-group mb-3">
									<input type="email" class="form-control user_email2" placeholder="이메일을 입력해주세요." aria-label="이메일을 입력해주세요." aria-describedby="button-addon2">
									<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="findPw();">전송</button>
									<br>
								</div>
								<p class="findpw" style="display: none; color: red;">이메일이 전송되었습니다.</p>
			                </div>
			                <div class="modal-footer">
			                    <button type="button" class="btn btn-secondary" id="send">전송</button>
			                </div>
				        </div>
			        </div>
			    </div>
			    <!-- Modal 끝-->
            </div>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>