<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/admin/adminqna.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="admin_nav">
	            <div class="admin_nav_align">
	                <p style="font-size: 22px;padding-left: 30px;">관리자페이지</p>
	                <br>
	                <ul style="list-style: none;">
	                    <li><a href="admin_main.do">회원관리</a></li><br>
	                    <li><a href="admin_warn.do">신고 내역</a></li><br>
	                    <li><a href="admin_plan.do">게시물 관리</a></li><br>
	                    <li><a href="admin_inquire.do">문의 내역</a></li><br>
	              </ul>
	            </div>
	        </div>
	
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    <p><b>문의 관리</b></p>
	                </div>
	
	                <br>
	
	                <table class="table" border="1">
	                    <tr>
	                        <th>문의 번호</th>
	                        <th>보낸    이</th>
	                        <th>문의 일자</th>
	                        <th>문의 내용</th>
	                    </tr>
	                    <tr>
	                        <td>1</td>
	                        <td>user<input type="hidden" value="user" id="to_user"></td>
	                        <td>2021 / 05 / 21</td>
	                        <td data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="connect();">혹시 나만의 일정 수정..</td>
	                    </tr>
	                    <tr>
	                        <td>2</td>
	                        <td>user2</td>
	                        <td>2021 / 05 / 21</td>
	                        <td><a href="">아 생각이 없어진다...</a></td>
	                    </tr>
	                </table>
	            </div>
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
		
		<!-- Modal 시작 -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	        <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            <h5 class="modal-title" id="staticBackdropLabel">user님의 문의</h5>
		            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		            </div>
		            <form name="reportmodal">
			            <input type="hidden" id="sessionId" value="">
		                <div class="modal-body chatMiddle" style="overflow: scroll;">
		                    <ul style="display: flex; flex-direction: column; padding: 0;">
		                    	<!-- 동적 생성 -->
		                    </ul>
		                    <br>
		                </div>
		                <div class="modal-footer">
		                	<textarea rows="5" cols="50" class="form-control" id="msg" placeholder="메세지 입력"></textarea>
		                    <button type="button" class="btn btn-secondary" id="send" onclick="sendBtn();">전송</button>
		                </div>
		            </form>
		        </div>
	        </div>
	    </div>
	    <!-- Modal 끝-->
	    <script type="text/javascript">
	    	<!-- 채팅 방 관련 -->
	    	let roomId;
	    	var ws;
	    	
	    	function connect() {
	    		var to_user = $("input#to_user").val();
	    		ws = new WebSocket("ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/echo.do?room_id=${sessionScope.user_id}");
		    	
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
							if(d.sessionId == $("#sessionId").val()){
								$(".chatMiddle>ul").append("<p class='from_user'>" + d.msg + " : " + `${sessionScope.user_id}` + "</p>");
							} else {
								$(".chatMiddle>ul").append("<p class='others'>" + d.from_user + " :" + d.msg + "</p>");
							}
						} else {
							console.warn("unknown type!");
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
	    		
	    		$(".btn-close").on('click', function() {
					ws.close();
	    		});
	    	}
	    	
	    	//엔터 누르면 메세지 전송되도록 설정
			document.addEventListener("keypress", function(e){
				if(e.keyCode == 13){ //enter press
					sendBtn();
				}
			});
	    	
	    	function sendBtn() {
	    		var option ={
    				type: "message",
    				sessionId : $("#sessionId").val(),
    				from_user : `${sessionScope.user_id}`,
    				to_user : "user1",
    				msg : $("#msg").val()
    			}
	    		ws.send(JSON.stringify(option));
    			$("#msg").val("");
	    	}
	    	
	    </script>
	</body>
</html>