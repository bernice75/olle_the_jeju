<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 문의</title>
		
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
	                    <li><a href="mypage_main.do?user_id=${sessionScope.user_id}">회원 정보 수정</a></li> 
	                    <li><a href="mypage_plan.do?plan_writer=${sessionScope.user_id}">나의 일정</a></li>
	                    <li><a href="mypage_inquire.do?user_id=${sessionScope.user_id}">문의 내역</a></li>
	                    <li><a href="mypage_warn.do?user_id=${sessionScope.user_id}">신고 확인</a></li>
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
	                <div class="chat_area" style="overflow: scroll;">
	                	<ul style="display: flex; flex-direction: column; padding: 0; margin: 20px;">
	                		<c:choose>
	                    		<c:when test="${empty message_list }">
	                    			<p>채팅내역이 없습니다.</p>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<c:forEach var="message" items="${message_list }">
	                    				<c:if test="${message.room_id eq sessionScope.user_id }">
                    						<c:if test="${message.from_user eq 'admin' }">
                    							<p class="to_user">관리자 : ${message.message_content }</p>
                    						</c:if>
                    						<c:if test="${message.from_user == sessionScope.user_id }">
                    							<p class="from_user">${message.message_content } : ${message.from_user}</p>
                    						</c:if>
                    						
                    					</c:if>
	                    			</c:forEach>
	                    		</c:otherwise>
	                    	</c:choose>
	                    	<!-- 동적 생성 -->
	                	</ul>
	                </div>
	                <div class="chat_write" style="width: 540px;">
	                    <textarea rows="5" cols="50" class="form-control" id="msg" placeholder="메세지 입력"></textarea>
	                    <button type="button" class="btn btn-secondary" id="send">전송</button>
	                </div>
	            </div>
	        </main>
	        <!-- main 끝 -->
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
		<script type="text/javascript">
	    	<!-- 채팅 방 관련 -->
	    	var ws;
	    	
	    	$(document).ready(function() {
	    		ws = new WebSocket("ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/echo.do");
		    	
		    	ws.onopen = function(data) {
		    		//소켓 연결 시 초기화 세팅
		    		console.log("info: 연결 성공");
		    	};
		    	ws.onmessage = function(data) {
		    		var new_msg = data.data;
					if(new_msg != null && new_msg.trim() != ''){
						var d = JSON.parse(new_msg);
						if(d.type == "getId"){
							var si = d.sessionId != null ? d.sessionId : "";
							if(si != ''){
								$("#sessionId").val(si); 
							}
						} else if(d.type == "message") {
							if(d.from_user == `${sessionScope.user_id}`){
								$(".chat_area>ul").append("<p class='from_user'>" + d.msg + " : " + `${sessionScope.user_id}` + "</p>");
							}else{
								$(".chat_area>ul").append("<p class='others'>관리자 :" + d.msg + "</p>");
							}
						} else {
							console.warn("unknown type!")
						}
					}
				};
				
		    	ws.onerror = function(error) {
		    		console.log("error: " + error);
	    		};
		    	ws.onclose = function(event) {
		    		console.log("info: 연결 끊김");
		    		//끊김이 발생했을 경우 1초에 한번씩 연결 시도
		    		//setTimeout(function() { connect(); }, 1000);
	    		};
	    		
	    		//엔터 누르면 메세지 전송되도록 설정
				document.addEventListener("keypress", function(e){
					if(e.keyCode == 13){
						var option ={
		    				type: "message",
		    				room_id : `${sessionScope.user_id}`,
		    				from_user : `${sessionScope.user_id}`,
		    				to_user : "admin",
		    				msg : $("#msg").val()
		    			}
			    		ws.send(JSON.stringify(option));
		    			$("#msg").val("");
					}
				});
	    		
	    		$("#send").on('click', function() {
		    		var option ={
	    				type: "message",
	    				room_id : `${sessionScope.user_id}`,
	    				from_user : `${sessionScope.user_id}`,
	    				to_user : "admin",
	    				msg : $("#msg").val()
	    			}
		    		ws.send(JSON.stringify(option));
	    			$("#msg").val("");
	    		});
	    	});
	    	
	    </script>
	</body>
</html>