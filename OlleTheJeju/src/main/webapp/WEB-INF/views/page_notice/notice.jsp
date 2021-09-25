<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객지원 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/notice/notice.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="//cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
		<script src="./resources/js/notice/notice.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<main class="main item">
	            <!-- 타이틀, 내용, 검색바 -->
	            <div class="notice">
	                <p class="not_title">고객지원</p>
	                <div class="not_inner">회원님들께서 가장 자주하시는 질문들을 모았습니다.<br>
	                    궁금하신 내용에 대해 검색해보세요.</div>
	            </div>
	            <br>
	            <!-- 
	            <div class="not_search">
	                <input type="text" class="form-control" placeholder="검색어 입력">
	                <button class="btn btn-outline-success" onclick="">검색</button>
	            </div>
	 			-->
	            <!-- 테이블: 나중에 jstl로 처리-->
	            <div class="accordion accordion-flush" id="accordionFlushExample">
	            	<c:choose>
	            		<c:when test="${empty faqList }">
	            			<div class="accordion-item">
			                  <h2 class="accordion-header" id="flush-headingOne">
			                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
			                      	작성된 글 없음
			                    </button>
			                  </h2>
			                  <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
			                    <div class="accordion-body">글이 없어요 새로 등록해주세요</div>
			                  </div>
			                </div>
	            		</c:when>
	            		<c:otherwise>
	            			<c:forEach var="faq" items="${faqList }">
								<div class="accordion-item">
								<h2 class="accordion-header" id="flush-headingOne">
									<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
										${faq.faq_title } (
											<c:choose>
												<c:when test="${faq.faq_kat eq 1 }">
													관광일정
												</c:when>
												<c:when test="${faq.faq_kat eq 2 }">
													추천일정
												</c:when>
												<c:when test="${faq.faq_kat eq 3 }">
													나만의 일정
												</c:when>
												<c:otherwise>
													제주상황
												</c:otherwise>
											</c:choose>
										 )
									</button>
								</h2>
								<div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">${faq.faq_content }</div>
									<c:choose>
										<c:when test="${sessionScope.user_id eq 'admin' }">
											<button type="button" class="btn btn-outline-secondary" style="width:100%;" onclick="showUpdate(this);">수정</button>
											<button type="button" class="btn btn-outline-secondary" style="width:100%;" onclick="deleteFaq(${faq.faq_num });">삭제</button>
										</c:when>
										<c:otherwise>
											
										</c:otherwise>
									</c:choose>
									<div class="update" style="display: none;">
										<input type="hidden" name="faq_num" value="${faq.faq_num }">
										<input type="text" class="form-control" name="faq_title" value="${faq.faq_title }">
										<textarea rows="10" cols="40" class="form_textarea form-control">${faq.faq_content }</textarea>
										<button class="btn btn-outline-primary" style="width:100%;" onclick="updateFaq(this);">수정완료</button>
										<button class="btn btn-outline-danger" style="width:100%;" onclick="hideUpdate(this);">수정취소</button>
									</div>
								</div>
								</div>
		                   </c:forEach>
	            		</c:otherwise>
	            	</c:choose>
	              </div>
				<br><br>
				<c:choose>
					<c:when test="${sessionScope.user_id eq 'admin' }">
						<div class="write">
		                    <button class="btn btn-outline-secondary" onclick="location.href='notice_insertForm.do'">글등록</button>
		                </div>
					</c:when>
				</c:choose>
	            <div class="not_map">
	                <p>제주 관광지도 Down</p>
	                
	            <div class="map_bg">
	                <div class="not_map_down">
	                </div>
	                <br>
	                <div class="map_down_button">
	                <a href="" download><button>국문</button></a>
	                <a href="" download><button>영문</button></a>
	                <a href="" download><button>일문</button></a>
	                <a href="" download><button>중문</button></a>
	                </div>
	            </div>
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>