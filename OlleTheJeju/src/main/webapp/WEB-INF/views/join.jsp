<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/join.css" rel="stylesheet" type="text/css" />
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
			<jsp:include page="include/header.jsp"></jsp:include>
			<div class="col-md-6 col-xs-10">
                <form>
                    <header>회원가입 with NAVER</header>
                    <fieldset>                  
                        <section>
                        <a href=""><img src="./resources/img/naver_login.png"></a>
                        </section>
                    </fieldset>
                    <hr>
                    <header>회원가입</header>
                    <fieldset>
                        <section>
                            <div class="row">
                                <label class="label col col-4">아이디</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="userId" name="userId" placeholder="영문/숫자만 사용가능, 4~12자">
                                            <span class="input-group-btn">
                                                <button class="btn-u btn-u-red" type="button" id="user_id_chk">중복확인</button>
                                            </span>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">비밀번호</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group icon">
                                            <input type="password" class="form-control" id="userPw" name="userPw" maxlength="18" placeholder="영문/숫자만 사용가능, 4~8자">
                                            <i class="icon-append fa fa-lock" aria-hidden="true"></i>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">비밀번호 확인</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group icon">
                                            <input type="password" class="form-control" id="pwChk" name="pwChk" maxlength="18" placeholder="비밀번호 재입력">
                                            <i class="icon-append fa fa-lock"></i>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">이름</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group icon">
                                            <input type="text" class="form-control" id="userName" name="userName">
                                            <i class="icon-append fa fa-user"></i>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">나이</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group icon">
                                            <input type="number" class="form-control" id="userAge" name="userAge">
                                            <i class="icon-append fa fa-user"></i>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">닉네임</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="userNick" name="userNick">
                                            <span class="input-group-btn">
                                                <button onclick="" id="nickChk" class="btn-u btn-u-red" type="button">중복확인</button>
                                            </span>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">이메일</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="userEmail" name="userEmail">
                                            <span class="input-group-btn">
                                                <button onclick="" id="emailChk" class="btn-u btn-u-red" type="button">이메일 인증</button>
                                            </span>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">가입구분</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <select id="userMember" name="userMember" class="form-control  col-5">
                                        <option value="N">----</option>
                                        <option value="개인">개인</option>
                                        <option value="사업자">사업자</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">전화번호</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <input type="text" class="form-control" id="userPhone" name="userPhone" placeholder="'-'을 제외하고 입력'">
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="row">
                                <label class="label col col-4">주소</label>
                                <div class="col col-8">
                                    <label class="input">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="userAddr" id="userAddr">
                                            <span class="input-group-btn">
                                                <button onclick="" id="addressEmailChk" class="btn-u btn-u-red" type="button">우편번호 찾기</button>
                                            </span>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <label class="checkbox"><input type="checkbox" name="acceptMail" value="Y" id="AcceptMail" checked=""><i></i>여행(계획)중일때에 해당 여행과 관련된 회원특가 광고메일을 받겠습니다.</label>
                        </section>
                        <section>
                            <a class="btn-u btn-u-dark btn-block" href="termofuse.html" target="_blank">이용약관</a>
                            <a class="btn-u btn-u-dark btn-block" href="privacy.html" target="_blank">개인정보 취급방침</a>
                            <label class="checkbox"><input type="checkbox" name="agree" id="agree"><i></i>약관과 개인정보 수집 및 이용방침에 동의합니다.</label>
                        </section>
                        <footer style="text-align:center">
                            <!-- <a class="btn-u btn-u-lg" href="">회원가입</a> -->
                            <button type="button" class="btn-u btn-u-lg" onClick="btn_usrSave();" >회원가입</button>
                            <a class="btn-u btn-u-lg btn-u-default" href="javascript:window.history.go(-1);">취소</a>
                        </footer>
                    </fieldset>
                </form>
            </div>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>

<script>

// 회원가입 저장
function btn_usrSave() {
	const userId = $("#userId").val();	// 아이디
	const userPw = $("#userPw").val();	// 비밀번호
	const pwChk = $("#pwChk").val();	// 비밀번호 확인
	const userName = $("#userName").val();	// 이름
	const userAge = $("#userAge").val();	// 나이
	const userNick = $("#userNick").val();	// 닉네임
	const userEmail = $("#userEmail").val();	// 이메일
	const userMember = $("#userMember").val();	// 가입구분
	const userPhone = $("#userPhone").val();	// 전화번호
	const userAddr = $("#userAddr").val();	// 주소
	
	console.log("userId :: " + userId);
	console.log("userPw :: " + userPw);
	console.log("pwChk :: " + pwChk);
	console.log("userName :: " + userName);
	console.log("userAge :: " + userAge);
	console.log("userNick :: " + userNick);
	console.log("userEmail :: " + userEmail);
	console.log("userMember :: " + userMember);
	console.log("userPhone :: " + userPhone);
	console.log("userAddr :: " + userAddr);
	
	if(userId == null || userId == "") {
		alert("아이디를 입력해주세요");
		return false;
	} else if(userPw == null || userPw == "") {
		alert("비밀번호를 입력해주세요");
		return false;
	}

	
	if(userPw != pwChk) {
		alert("비밀번호를 확인해주세요.");
		return false;
	}
	
	if(userMember == "N") {
		alert("가입구분을 선택해주세요.");
		return false;
	}
	
	var form = {
			 userId: userId
			,userPw: userPw
			,userName: userName
			,userAge: userAge
			,userNick: userNick
			,userEmail: userEmail
			,userMember: userMember
			,userPhone: userPhone
			,userAddr: userAddr
    }
	
	$.ajax({
		 url: "userInsert.do"
		,data: form
		,success: function(data){
			alert("회원가입이 완료되었습니다.");
			location.href = "home.do";
		}
		,error: function(){
		    alert("회원가입에 실패했습니다. \n 관리자에게 문의하세요.");
		}
	});
	
	
	
	}
</script>