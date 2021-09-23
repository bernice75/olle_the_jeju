<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	                	<col width="80px">
	                	<col width="150px">
	                	<col width="200px">
	                	<col width="300px">
	                    <tr>
	                        <th>문의 번호</th>
	                        <th>보낸    이</th>
	                        <th>문의 일자</th>
	                        <th>문의 내용</th>
	                    </tr>
	                    <c:choose>
	                    	<c:when test="${empty room_id }">
	                    		<tr>
	                    			<td colspan="4">==========문의 내역이 없습니다.==========</td>
	                    		</tr>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<c:forEach var="room_list" items="${room_id }" varStatus="status">
		                    			<tr>
		                    				<td>${status.count }</td>
		                    				<td>
		                    					${room_list }
		                    					<input type="hidden" id="room_id" value="${room_list }">
	                    					</td>
		                    				
		                    				<c:forEach var="message" items="${message_content }">
		                    					<c:if test="${room_list eq message.room_id }">
		                    						<fmt:formatDate var="Regdate" value="${message.message_regdate }" pattern="yyyy.MM.dd"/>
		                    						<td>${Regdate }</td>
		                    						<td class="${room_list }_msg" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="connect('${room_list}');">
		                    							<p>${message.message_content }</p>
		                    							
		                    							<c:forEach var="message2" items="${message_list }">
			                    							<c:forEach var="msg" items="${message2 }">
			                    								<c:if test="${msg.room_id eq room_list }">
			                    									<input type="hidden" class="${msg.from_user }" value="${msg.message_content }">
			                    								</c:if>
			                    							</c:forEach>
			                    						</c:forEach>
	                    							</td>
		                    					</c:if>
		                    				</c:forEach>
		                    			</tr>
	                    		</c:forEach>
	                    	</c:otherwise>
	                    </c:choose>
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
		            <h5 class="modal-title" id="staticBackdropLabel"></h5>
		            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		            </div>
		            <form name="reportmodal">
			            <input type="hidden" id="sessionId" value="">
		                <div class="modal-body chatMiddle" style="overflow: scroll;">
		                    <ul style="display: flex; flex-direction: column; padding: 0;">
		                    	<c:choose>
		                    		<c:when test="${empty message_list }">
		                    		
		                    		</c:when>
		                    		<c:otherwise>
		                    			<c:forEach var="message" items="${message_list }">
		                    				<c:forEach var="msg" items="${message }">
		                    					<c:if test="${msg.room_id eq room_id }">
		                    						<c:if test="${msg.from_user eq 'admin' }">
		                    							<p>${msg.message_content } : 관리자</p>
		                    						</c:if>
		                    						<p>${msg.from_user} : ${msg.message_content }</p>
		                    					</c:if>
		                    				</c:forEach>
		                    			</c:forEach>
		                    		</c:otherwise>
		                    	</c:choose>
		                    	<!-- 동적 생성 -->
		                    </ul>
		                    <br>
		                </div>
		                <div class="modal-footer">
		                	<textarea rows="5" cols="50" class="form-control" id="msg" placeholder="메세지 입력"></textarea>
		                    <button type="button" class="btn btn-secondary" id="send">전송</button>
		                </div>
		            </form>
		        </div>
	        </div>
	    </div>
	    <!-- Modal 끝-->
	    <script type="text/javascript">
	    	<!-- 채팅 방 관련 -->
	    	var room_id;
	    	var ws;
	    	
	    	function connect(room_id) {
	    		room_id = room_id;
	    		$(".modal-title").text(room_id + "님의 문의");
	    		
	    		var li = $(".chatMiddle>ul").children();
	    		
	    		if(li.length > 0) {
	    			$(".chatMiddle>ul").children().remove();
	    		}
	    		
	    		var td = $("."+room_id+"_msg");
	    		console.log(td);
	    		var input = td.children('input');
	    		for(var i = 0; i < input.length; i++) {
	    			//console.log(input[i]);
	    			if(input[i].className == room_id) {
	    				$(".chatMiddle>ul").append("<p class='to_user'>" + room_id + " :" + input[i].value + "</p>");
	    			} else {
	    				$(".chatMiddle>ul").append("<p class='from_user'>" + input[i].value + " : 관리자</p>");
	    			}
	    		}
	    		
	    		var to_user = $("input#to_user").val();
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
							if(d.from_user == room_id){
								$(".chatMiddle>ul").append("<p class='to_user'>" + d.from_user + " :" + d.msg + "</p>");
							} else {
								$(".chatMiddle>ul").append("<p class='from_user'>" + d.msg + " : 관리자</p>");
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
					location.reload();
	    		});
	    		
	    		//엔터 누르면 메세지 전송되도록 설정
				document.addEventListener("keypress", function(e){
					if(e.keyCode == 13){
						console.log(room_id);
						sendBtn();
					}
				});
	    		
	    		$("#send").on('click', function() {
	    			console.log(room_id);
		    		var option ={
	    				type: "message",
	    				room_id : room_id,
	    				from_user : "admin",
	    				to_user : room_id,
	    				msg : $("#msg").val()
	    			}
		    		ws.send(JSON.stringify(option));
	    			$("#msg").val("");
	    		});
	    	}
	    	
	    </script>
	</body>
</html>