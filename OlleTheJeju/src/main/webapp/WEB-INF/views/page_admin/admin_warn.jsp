<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 신고내역</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
       	<link href="./resources/css/admin/adminwarn.css" rel="stylesheet" type="text/css" />
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
	        <!-- 신고  -->
	        <main class="main item">
	
	            <div class="user_plan">
	                <div class="plan_title">
	                    <p><b>신고</b></p>
	                </div>
	                <br>
	                <table class="table" border="1">
	                    <tr>
	                        <th><input type="checkbox"></th>
	                        <th>신고 번호</th>
	                        <th>신고자</th>
	                        <th>신고대상</th>
	                        <th>신고사유</th>
	                        <th>글번호</th>
	                        <th>신고 일자</th>
	                        <th>처리여부</th>
	                        <th>경고처리</th>
	                    </tr>
	                    <c:choose>
	                    	<c:when test="${empty report }">
	                    		<tr>
	                    			<td colspan="9">=========신고된 게시물이 없습니다.=========</td>
	                    		</tr>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<c:forEach var="rep" items="${report }">
	                    			<tr>
		                    			<td><input type="checkbox"></td>
		                    			<td>${rep.rep_num }</td>
		                    			<td>${rep.user_id }</td>
		                    			<td>${rep.rep_user }</td>
		                    			<td>${rep.rep_reson }</td>
		                    			<c:choose>
		                    				<c:when test="${empty cusList }">
		                    					<td>해당 게시물이 없습니다.</td>
		                    				</c:when>
		                    				<c:otherwise>
	                    						<td data-bs-toggle="modal" data-bs-target="#staticBackdrop">${rep.plan_num }</td>
	                    						<c:forEach var="cus" items="${cusList }">
		                    						<!-- Modal 시작 -->
													<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
												        <div class="modal-dialog">
													        <div class="modal-content">
													            <div class="modal-header">
													            	<h5>신고 게시물 내용</h5>
													            	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
													            </div>
													            <div class="model-body" style="padding: 30px;">
													            	<div class="title">
															            <h4>${cus.plan_title }</h4>
															        </div>
															        <div class="content">
															        	<h6>${cus.plan_content }</h6>
															        </div>
															        <div class="term">
															        	<h6>기간 : ${cus.plan_term }</h6>
															        </div>
															        <div class="tendency">
															        	<h6>기간 : ${cus.plan_tendency }</h6>
															        </div>
													            </div>
												                <div class="modal-footer">
												                </div>
													        </div>
												        </div>
												    </div>
												    <!-- Modal 끝-->
	                    					</c:forEach>
		                    				</c:otherwise>
		                    			</c:choose>
		                    			<fmt:formatDate var="rep_regdate" value="${rep.rep_regdate }" pattern="yyyy.MM.dd"/>
		                    			<td>${rep_regdate }</td>
		                    			<td><button class="btn btn-primary btn-block" onclick="location.href='rep_delete.do?rep_num=${rep.rep_num }&plan_num=${rep.plan_num }'">공개</button></td>
		                    			<td><button class="btn btn-primary btn-block" onclick="location.href='rep_warn.do?user_id=${rep.rep_user }'">경고</button></td>
		                    		</tr>
	                    		</c:forEach>
	                    	</c:otherwise>
	                    </c:choose>
	                </table>
	            </div> 
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
		
	</body>
</html>