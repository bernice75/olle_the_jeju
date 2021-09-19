<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 main</title>
		
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/mypage/mypageinquire.css" rel="stylesheet" type="text/css" />
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
	
	        <main class="main item">
	            <div class="user_inq">
	                <div class="inq_title">
	                    문의 내역
	                </div>
	            </div>
	            <!-- 채팅 -->
	            <div class="inq_chat">    
	                <div class="chat">채팅내역</div>
	                <div class="chat_area"></div>
	                <div class="chat_write">
	                    <input type="text" class="chat_content">
	                    <button type="submit">보내기</button>
	                </div>
	            </div>
	        </main>
	        <!-- main 끝 -->
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
		<script type="text/javascript">
			// 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
			var webSocket = new WebSocket("ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/userChat");
			// 콘솔 텍스트 영역
			var messageTextArea = document.getElementById("messageTextArea");
			// 접속이 완료되면
			webSocket.onopen = function(message) {
				// 콘솔에 메시지를 남긴다.
				messageTextArea.value += "Server connect...\n";
			};
			// 접속이 끝기는 경우는 브라우저를 닫는 경우이기 떄문에 이 이벤트는 의미가 없음.
			webSocket.onclose = function(message) { };
			// 에러가 발생하면
			webSocket.onerror = function(message) {
				// 콘솔에 메시지를 남긴다.
				messageTextArea.value += "error...\n";
			};
			// 서버로부터 메시지가 도착하면 콘솔 화면에 메시지를 남긴다.
			webSocket.onmessage = function(message) {
				messageTextArea.value += "(operator) => " + message.data + "\n";
			};
			// 서버로 메시지를 발송하는 함수
			// Send 버튼을 누르거나 텍스트 박스에서 엔터를 치면 실행
			function sendMessage() {
				// 텍스트 박스의 객체를 가져옴
				let message = document.getElementById("textMessage");
				// 콘솔에 메세지를 남긴다.
				messageTextArea.value += "(me) => " + message.value + "\n";
				// 소켓으로 보낸다.
				webSocket.send(message.value);
				// 텍스트 박스 추기화
				message.value = "";
			}
			// 텍스트 박스에서 엔터를 누르면
			function enter() {
				// keyCode 13은 엔터이다.
				if(event.keyCode === 13) {
					// 서버로 메시지 전송
					sendMessage();
					// form에 의해 자동 submit을 막는다.
					return false;
				}
				return true;
			}
		</script>
	</body>
</html>