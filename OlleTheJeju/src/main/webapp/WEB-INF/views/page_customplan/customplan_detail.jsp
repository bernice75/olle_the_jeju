<%@page import="com.olle.dto.customplan.CustomDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나만의 일정 detail</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/customplan/customplan_detail.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx142479165b1048a5b99ae1b5a05f5d1b"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/customplan/customplan_detail.js" type="text/javascript"></script>
        
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>나만의 일정</h2>
                    <br>
                    <p>
                        세계적으로 유명한 유네스코 자연유산과 세계지질공원 등을 직접 찾아가보는 여행코스는 남다른 의미가 있습니다!<br>
                        당일 여행부터 4일 이상의 여행까지,<br>
                        개인의 취향과 시간에 맞게 다양한 여행 일정을 계획해 더욱 즐거운 제주도 여행을 경험하세요!
                    </p>
                </div>
                <br><br>
                <div class="nail">
                    <div id="carouselExampleFade" class="carousel slide carousel-fade slider" data-bs-ride="carousel">
                        <div class="carousel-inner imgs">
                            
                        <c:choose>
                            <c:when test="${empty ImgDto} ">
                            
                            </c:when>
                            	<c:otherwise>
                            	<c:forEach var="img" items="${ImgDto}">
	                            	<div class="carousel-item active">
	                                	<img src="./resources/plan/${img.img_title}" class="d-block w-100" alt="...">
	                            	</div>
                            	</c:forEach>
                            </c:otherwise>
                        </c:choose>
                            
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="content_info">
                        <br>
                        <!--타이틀 -->
                        <h4>${CustomDto.plan_title }</h4>
                        <div class="name">
                        	<!-- 작성자 -->
                            <h6><strong>작성자</strong> | ${CustomDto.plan_writer }</h6>
                            <h6 class="like" onclick="pushPlan(this);"><i class="fa fa-heart-o" aria-hidden="true"></i> | ${CustomDto.plan_push }</h6>
                            <input type="hidden" class="plan_num" value="${CustomDto.plan_num }">
                            <h6>조회수 | ${CustomDto.plan_views }</h6>
                            <h6><i class="fa fa-thumb-tack" aria-hidden="true"></i> | ${dib }</h6>
                            <h6><i class="fa fa-bullhorn" aria-hidden="true"></i> | 신고</h6>
                        </div>
                        <div class="content">
                            ${CustomDto.plan_content }
                        </div>
                        <div class="tag">
                            <h6 class="day"><strong>기간</strong> | ${CustomDto.plan_term }</h6>
                            <h6 class="regdate"><strong>작성일</strong> | 
                            	<fmt:formatDate var="Regdate" value="${CustomDto.plan_regdate }" pattern="yyyy/MM/dd"/>
                            	${Regdate }</h6>
                            <h6 class="den"><strong>성향</strong> | ${CustomDto.plan_tendency }</h6>
                            <h6 class="hash"><strong>태그</strong> | ${HashDto.hash_content }</h6>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="suggest_text">
                    <h3>일정등록</h3>
                    <hr class="line">
                    <div class="main-second">
             			<div id="map_div"></div>
                        <div class="map_list">
                        	<c:choose>
                        	<c:when test="${empty DateDto }">
                        		
                        	</c:when>
                        	<c:otherwise>
                        		<c:forEach var="date" items="${DateDto }">
                        			<div class=list_inner>
				                        <p class=list_title ><b>1. 코스명</b></p>
				                        <p class=list_title><input type=text value= "${date.date_name }" style=width:200px readonly=readonly></p>
				                        <p class=list_addr><b>2. 주소</b></p>
				                        <p class=list_addr><input type=text value= "${date.date_addr }" style=width:200px readonly=readonly></p>
				                        <p class=list_phone><b>3. 전화번호</b></p>
				                        <p class=list_phone><input type=text value= "${date.date_phone }" style=width:200px readonly=readonly></p>
	                    			</div>
                        			<input type="hidden" id="date_lat" value="${date.date_lat }">
                        			<input type="hidden" id="date_lon" value="${date.date_lon }">
                        			<input type="hidden" id="date_name" value="${date.date_name }">
                        			<input type="hidden" id="date_addr" value="${date.date_addr }">
                        			<input type="hidden" id="date_phone" value="${date.date_phone }">
                        		</c:forEach>
                        	</c:otherwise>
                        </c:choose>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="bottom-btn-group2">
                    <input id="btn1" class="btn btn-secondary" type="button" value="목록" onclick="location.href='customplan_main.do'">
                    <input id="btn2" class="btn btn-primary" type="button" value="수정" onclick="location.href='customplan_update.do?plan_num=${CustomDto.plan_num }'">
                    <input id="btn3" class="btn btn-danger" type="button" value="삭제" onclick="location.href='customplan_delete.do?plan_num=${CustomDto.plan_num }'">
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>