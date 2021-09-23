<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 plan</title>
		
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/mypage/mypageplan.css" rel="stylesheet" type="text/css" />
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
	
	        <!-- main 시작 -->
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    <%--${sessionScope.user_id }님께서--%> 내가 작성한 일정
	                </div>
	            </div>
	            <!-- 나의 일정 -->
	            <div class="plan_thum">
	                <!-- jstl core foreach로 썸네일 목록 반복 -->
	                <c:choose>
	                	<c:when test="${empty planList }">
	                		<tr>
								<td colspan ="4">----내가 작성한 글이 존재하지 않습니다----</td>
							</tr>
	                	</c:when>
	                	<c:otherwise>
	                		<c:forEach var="plan" items="${planList }" varStatus="status">
		                			<div class="thum_item" onclick="location.href='customplan_detail.do?plan_num=${plan_num}'">
					                    <div class="img_thum">
				                            <div class="nail_img">
				                            	<!-- 기간 정보 데이터 받아와서 삽입 -->
				                                <div class="sleep">${plan.plan_term }</div>
				                                 <!-- 이미지 데이터 작성 / 추후에 이미지태그는 삭제하고 데이터값만 적어야함-->
	                                			<img src="./resources/img/제주도샘플사진1.jpg">
				                            </div>
					                    </div>
					                    <div class="thum_text">
					                        <div style="font-size: 20px;">${plan.plan_title }</div>
					                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
					                        <span class="thum_text_span1" style="font-size: 12px;">${plan.plan_tendency }</span>
					                        <!-- 내가 작성한 게시글의 성향 데이터를 받아와서 삽입-->
					                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
					                        <c:choose>
					                        	<c:when test="${empty hashList }">
					                        		<span class="thum_text_span1"style="font-size: 12px;">해시태그 정보없음</span>
					                        	</c:when>
					                        	<c:otherwise>
					                        		<c:forEach var="tag" items="${hashList }">
					                        			<c:if test="${plan.plan_num eq tag.table_num }">
		                        							<span class="thum_text_span1" style="font-size: 12px;">${tag.hash_content }</span>
		                        						</c:if>
					                        		</c:forEach>
					                        	</c:otherwise>
					                        </c:choose>
					                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
					                        <br>
					                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;${plan.plan_push } </span>
					                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
					                        <span class="thum_text_span2"style="font-size: 12px;">조회수&nbsp;&nbsp;|&nbsp;&nbsp;${plan.plan_views }</span>
					                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
					                    </div>
					                </div>
	                		</c:forEach>
	                	</c:otherwise>
	                </c:choose>
	                
	            </div>
	            <br>
	            <!-- 페이징처리 -->
	           <div class="paging">
	            	<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <%-- <c:if test="${pageMaker.prev}"> --%>
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(pageMaker.startPage - 1)}&plan_writer=${sessionScope.user_id}">이전</a></li>
					    <%-- </c:if>  --%>
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(idx)}&plan_writer=${sessionScope.user_id}">${idx}</a></li>
					    </c:forEach>
					    <%-- <c:if test="${pageMaker.next && pageMaker.endPage > 0}"> --%>
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(pageMaker.endPage + 1)}&plan_writer=${sessionScope.user_id}">다음</a></li>
					    <%-- </c:if>  --%>
					  </ul>
				 	 </nav>
				</div>
	            <br><br>
	
	           <%--  <!-- 내가 찜한 일정 -->
	            <div class="user_pick">
	                <div class="pick_title">
	                    내가 찜한 일정
	                </div>
	            </div>
	            <br>
	            <!-- 내가 찜한 일정 -->
	            <div class="plan_thum">
	                <!-- jstl core foreach로 썸네일 목록 반복 -->
	                <c:choose>
	                	<c:when test="${empty list }">
	                		<tr>
								<td colspan ="4">----내가 찜한 일정이 존재하지 않습니다----</td>
							</tr>
	                	</c:when>
	                	<c:otherwise>
	                		<c:forEach var="plan" items="${list }">
	                			<div class="thum_item" onclick="location.href='#'">
				                    <div class="img_thum">
			                            <div class="nail_img">
			                                <!-- 기간 정보 데이터 받아와서 삽입 -->
			                                <div class="sleep">${plan.plan_term }</div>
			                                <!-- 이미지 데이터 작성 / 추후에 이미지태그는 삭제하고 데이터값만 적어야함-->
                                			<img src="./resources/img/제주도샘플사진1.jpg">
			                            </div>
				                    </div>
				                    <div class="thum_text">
				                        <div style="font-size: 20px;">${plan.plan_title }</div>
				                        <!-- 내가 작성한 게시글의 제목 데이터를 받아와서 삽입-->
				                        <span class="thum_text_span1" style="font-size: 12px;">${plan.plan_tendency }</span>
				                        <!-- 내가 작성한 게시글의 성향ㄴ 데이터를 받아와서 삽입-->
				                        <span class="thum_text_span1" style="font-size: 12px;">|</span>
				                        <c:choose>
				                        	<c:when test="${empty tag }">
				                        		<span class="thum_text_span1"style="font-size: 12px;">해시태그 정보없음</span>
				                        	</c:when>
				                        	<c:otherwise>
				                        			<c:forEach var="tag" items="${tag }">
				                        			<c:if test="${plan.plan_num eq tag.table_num }">
		                        						<span class="thum_text_span1"style="font-size: 12px;">${tag.hash_content }</span>
		                        					</c:if>
				                        		</c:forEach>
				                        	</c:otherwise>
				                        </c:choose>
				                        <!-- 내가 작성한 게시글의 해시태그 데이터를 받아와서 삽입-->
				                        <br>
				                        <span class="thum_text_span2"style="font-size: 12px;">추천수&nbsp;&nbsp;|&nbsp;&nbsp;${plan.plan_push } </span>
				                        <!-- 내가 작성한 게시글의 추천수 데이터를 받아와서 숫자 지우고 삽입-->
				                        <span class="thum_text_span2"style="font-size: 12px;">조회수&nbsp;&nbsp;|&nbsp;&nbsp;${plan.plan_views }</span>
				                        <!-- 내가 작성한 게시글의 신고수 데이터를 받아와서 숫자 지우고 삽입-->
				                        <hr style="margin-bottom: 0;">
                        				<c:choose>
                        					<c:when test="${empty zzim }">
                        						<div class="nail_hrt"><a href=""><i class="fa fa-heart-o fa-xs"></i></a> &nbsp; 찜정보없음</div>
                        					</c:when>
                        					<c:otherwise>
                        						<c:forEach var="dib" begin="0" items="${zzim }">
                        							<c:forEach var="dib2" begin="0" items="${dib }">
                        								<c:if test="${plan.plan_num eq dib2.table_num}">
                        									<div class="nail_hrt"><a href=""><i class="fa fa-heart-o fa-xs"></i></a> &nbsp; ${dib2.dib_num }(찜번호)</div>
                        								</c:if>
                        							</c:forEach>
                        						</c:forEach>
                        					</c:otherwise>
                        				</c:choose>
                        				
				                    </div>
				                </div>
	                		</c:forEach>
	                	</c:otherwise>
	                </c:choose>
	            </div>
	            <br>
	            <!-- 페이징 -->
	            <div class="paging">
	            	<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <c:if test="${pageMaker.prev}">
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(pageMaker.startPage - 1)}&plan_writer=${sessionScope.user_id}">이전</a></li>
					    </c:if> 
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(idx)}&plan_writer=${sessionScope.user_id}">${idx}</a></li>
					    </c:forEach>
					    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					    	<li class="page-item"><a class="page-link" href="mypage_plan.do${pageMaker.makeQuery(pageMaker.endPage + 1)}&plan_writer=${sessionScope.user_id}">다음</a></li>
					    </c:if> 
					  </ul>
				 	 </nav>
				</div> --%>
	            <br><br><br><br>
	        </main>
	        <!-- main 끝 -->
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>