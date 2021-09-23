<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 팝업</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/admin/adminboardpopup.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="popup">
	        <div class="category">
	            <p style="font-size: 15px;">편안</p>
	        </div>
	
	        <div class="title">
	            <h3>제주도 최상급 여행루트</h3>
	        </div>
	        <br>
	        <div class="user_img">
	            <img src="./resources/img/user.png" class="profile">
	        </div>
	        <div class=user_info>
	            <div class="user_nick">
	                <p style="font-size: 15px;">얄리얄리얄라셩</p>
	            </div>
	
	            <div class="user_date">
	                <p style="font-size: 15px;">2021.04.17</p>
	            </div>
	
	            <div class="user_views">
	                <p style="font-size: 15px;">조회 128</p>
	            </div>
	        </div>
	        <div class="user_inner">
	        <textarea class="form-control" cols="80" rows="20" readonly="readonly">
	        한국어 관련 질문
	        무슨 부귀영화를 누리겠다고 은 무슨 뜻인가요?
	        부귀영화 means rich and the phrase “무슨 부귀영화를 누리겠다고” 
	        is used to be sarcastic toward a person who does worthless things
	        to try to be rich.
	        부귀영화= wealth and honor thing
	        so, that means "what can i get from that?"
	        it is also used to describe 'being self-locking'
	        </textarea>
	        </div>
	        <br>
	        <div class="popup_btn">
	            <button type="button" class="btn btn-primary" onclick="">수정</button>
	            <button type="button" class="btn btn-secondary" onclick="">삭제</button>
	        </div>
	        <br><br><br>
	    </div>
	</body>
</html>