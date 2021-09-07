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

	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="include/header.jsp"></jsp:include>
			<div class="log_main">
                <div class="log_center">
                    <div class="col-md-6 col-xs-10">
                        <form>
                            <header>네이버 아이디로 로그인</header>
                            <hr>
                            <fieldset>                  
                                <section>
                                <a href=""><img src="./resources/img/naver_login.png"></a>
                                </section>
                            </fieldset>
                            <hr>
                            <header>올레더제주 로그인</header>
                            <fieldset>                  
                                <section>
                                    <div class="row">
                                        <label class="label col col-4">아이디</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="user_id">
                                        </div>
                                    </div>
                                </section>
                                <section>
                                    <div class="row">
                                        <label class="label col col-4">비밀번호</label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" name="user_pw">
                                        </div>
                                    </div>
                                </section>
                                <footer style="text-align:center">
                                    <a class="btn-u btn-u-lg" href="">로그인</a>
                                    <a class="btn-u btn-u-lg btn-u-default" href="">회원가입</a>
                                    <br>
                                    <a href="" class="find">아이디 비밀번호 찾기</a>
                                </footer>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>