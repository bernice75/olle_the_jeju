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
        <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script src="./resources/js/join.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="include/header.jsp"></jsp:include>
			<div class="main">
                <form name="joinForm" action="userInsert.do" method="post">
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
                                            <input type="text" class="form-control" id="user_id" name="user_id" placeholder="영문/숫자만 사용가능, 4~12자">
                                            <span class="input-group-btn">
                                                <button class="btn-u btn-u-red" type="button" id="user_id_chk" title="n" onclick="idChk();">중복확인</button>
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
                                            <input type="password" class="form-control" id="user_pw" name="user_pw" maxlength="18" placeholder="영문/숫자만 사용가능, 4~8자" autocomplete="off" onclick="idChkForm();">
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
                                            <input type="password" class="form-control" id="user_pw_chk" maxlength="18" placeholder="비밀번호 재입력" autocomplete="off" onclick="idChkForm();" onchange="pwChk();">
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
                                            <input type="text" class="form-control" id="user_name" name="user_name" onclick="idChkForm();">
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
                                            <input type="number" class="form-control" id="user_age" name="user_age" onclick="idChkForm();">
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
                                            <input type="text" class="form-control" id="user_nick" name="user_nick" onclick="idChkForm();">
                                            <span class="input-group-btn">
                                            	<button class="btn-u btn-u-red" type="button" id="user_nick_chk" title="n" onclick="nickChk();">중복확인</button>
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
                                            <input type="text" class="form-control" id="user_email" name="user_email" onclick="idChkForm();">
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
                                        <select id="user_member" name="user_member" class="form-control  col-5">
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
                                        <input type="text" class="form-control" id="user_phone" name="user_phone" placeholder="'-'을 제외하고 입력'" onclick="idChkForm();">
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
                                            <input type="text" class="form-control" name="user_addr" id="user_addr" onclick="idChkForm();" placeholder="주소" style="margin-right:10px;" readonly="readonly">
                                            <input type="text" class="form-control" name="user_addrdetail" id="user_addrdetail" placeholder="상세주소" onclick="idChkForm();">
                                            <span class="input-group-btn">
                                                <button onclick="findAddr();" id="addressEmailChk" class="btn-u btn-u-red" type="button">우편번호 찾기</button>
                                            </span>
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </section>
                        <section>
                            <label class="checkbox"><input type="checkbox" name="acceptMail" value="Y" id="AcceptMail"><i></i>여행(계획)중일때에 해당 여행과 관련된 회원특가 광고메일을 받겠습니다.</label>
                        </section>
                        <section>
                            <a class="btn-u btn-u-dark btn-block" href="termofuse.html" target="_blank">이용약관</a>
                            <a class="btn-u btn-u-dark btn-block" href="privacy.html" target="_blank">개인정보 취급방침</a>
                            <label class="checkbox" style="margin-top:10px;"><input type="checkbox" id="agree"><i></i>약관과 개인정보 수집 및 이용방침에 동의합니다.</label>
                        </section>
                        <div>
                            <a type="button" class="btn-u btn-u-lg" onClick="btn_usrSave();" >회원가입</a>
                            <a class="btn-u btn-u-lg btn-u-default" href="javascript:window.history.go(-1);">취소</a>
                        </div>
                    </fieldset>
                </form>
            </div>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>