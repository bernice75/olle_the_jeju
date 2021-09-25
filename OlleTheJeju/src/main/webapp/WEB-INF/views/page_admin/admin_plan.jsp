<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 plan</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/admin/adminboard.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script type="text/javascript">
	        function showPopup(){
	            window.open("adminboardpopup.do","게시글 수정",
	            "width=800, height=800");
	        }
	    </script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<!-- adminpage nav -->
	        <div class="admin_nav">
	            <div class="admin_nav_align">
	                <p style="font-size: 22px;padding-left: 38px;">관리자페이지</p><br>
		            <ul style="list-style: none;">
		                <li><a href="admin_main.do">회원관리</a></li><br>
	                    <li><a href="admin_warn.do">신고 내역</a></li><br>
	                    <li><a href="admin_plan.do">게시물 관리</a></li><br>
	                    <li><a href="admin_inquire.do">문의 내역</a></li><br>
	              	</ul>
	            </div>
	        </div>
	
	        <!-- 게시글 관리  -->
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    <h3>게시글 관리</h3>
	                </div>
	            <br>
	        <!-- 나만의 일정 -->
	        <div class="tour_info">
	            <div class="tour_info_title">
	                <p>나만의 일정</p>
	            </div>
	            <br>
	            <table class="table" border="1">
	                <tr>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">제목</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                    <th style="text-align: center;">조회</th>
	                    <th style="text-align: center;">추천</th>
	                </tr>
	                <c:choose>
	                	<c:when test="${empty planList }">
	                		<td colspan="6">=======게시물이 없습니다.========</td>
	                	</c:when>
	                	<c:otherwise>
	                		<c:forEach var="plan" items="${planList }" varStatus="status">
	                			<tr>
		                			<td>${status.count }</td>
		                			<td>${plan.plan_title }</td>
		                			<td>${plan.plan_writer }</td>
		                			<td>
		                				<fmt:formatDate var="Regdate" value="${plan.plan_regdate }" pattern="yyyy.MM.dd"/>
		                				${Regdate }
	                				</td>
		                			<td>${plan.plan_views }</td>
		                			<td>${plan.plan_push }</td>
	                			</tr>
	                		</c:forEach>
	                	</c:otherwise>
	                </c:choose>
	            </table>
	        </div>
	        <br>
	        <!-- 페이징 처리 -->
            <div class="paging">
            	<nav aria-label="Page navigation example">
            		<ul class="pagination">
           				<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${paging.beginPage}">처음으로</a></li>
            			<c:forEach begin="${paging.beginPage}" end="${paging.endPage }" step="1" var="index">
            				<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${index}">${index}</a></li>
					    </c:forEach>
				    	<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${paging.beginPage+1}">다음</a></li>
            		</ul>
            	</nav>
           	</div>
	        <hr>
	        <br><br><br><br>
	        <!-- 신고된 게시물 목록 -->
	        <div class="pick_plan">
                <div class="pick_plan_title">
                    <p>신고된 게시물</p>
                </div>
	            <br>
	            <table class="table" border="1">
	                <tr>
	                    <th style="text-align: center;">번호</th>
	                    <th style="text-align: center;">제목</th>
	                    <th style="text-align: center;">글쓴이</th>
	                    <th style="text-align: center;">작성일</th>
	                </tr>
	                <c:choose>
	                	<c:when test="${empty planList2 }">
	                		<td colspan="6">=======게시물이 없습니다.========</td>
	                	</c:when>
	                	<c:otherwise>
	                		<c:forEach var="plan2" items="${planList2 }" varStatus="status">
	                			<tr>
		                			<td>${status.count }</td>
		                			<td>${plan2.plan_title }</td>
		                			<td>${plan2.plan_writer }</td>
		                			<td>
		                				<fmt:formatDate var="Regdate" value="${plan2.plan_regdate }" pattern="yyyy.MM.dd"/>
		                				${Regdate }
	                				</td>
	                			</tr>
	                		</c:forEach>
	                	</c:otherwise>
	                </c:choose>
	            </table>
	        </div>
	        <br>
	        <!-- 페이징 처리 -->
            <div class="paging">
            	<nav aria-label="Page navigation example">
            		<ul class="pagination">
           				<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${paging2.beginPage}">처음으로</a></li>
            			<c:forEach begin="${paging2.beginPage}" end="${paging2.endPage }" step="1" var="index">
            				<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${index}">${index}</a></li>
					    </c:forEach>
				    	<li class="page-item"><a class="page-link" href="admin_plan.do?search=&page=${paging2.beginPage+1}">다음</a></li>
            		</ul>
            	</nav>
           	</div>
	        
	        <br><br><br>
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>