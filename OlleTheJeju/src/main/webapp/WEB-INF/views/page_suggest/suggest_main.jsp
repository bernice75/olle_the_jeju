<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.olle.dto.suggest.SuggestDto" %>
<%@page import="java.util.List" %>
<%@ page import="com.olle.dto.pagination.Paging" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/suggest/suggest_main.css?var=1" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/suggest/suggest_main.js?var=2" type="text/javascript"></script>

	</head>
	<body>
		<input type="hidden" id="user_id" value="${sessionScope.user_id}">
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>제주도를 즐기는 다양한 여행 일정 추천</h2>
                    <br>
                    <p>
                        세계적으로 유명한 유네스코 자연유산과 세계지질공원 등을 직접 찾아가보는 여행코스는 남다른 의미가 있습니다!<br>
                        당일 여행부터 4일 이상의 여행까지,<br>
                        개인의 취향과 시간에 맞게 다양한 여행 일정을 계획해 더욱 즐거운 제주도 여행을 경험하세요!
                    </p>
                </div>
                <br><br>
                <div class="menu">
                    <div class="menu1" onclick="location.href='suggest_main.do?kategorie=전체&page=1&user_id=${sessionScope.user_id}'">전체</div>
                    <div class="menu2" onclick="location.href='suggest_main.do?kategorie=편안&page=1&user_id=${sessionScope.user_id}'">편안한</div>
                    <div class="menu3" onclick="location.href='suggest_main.do?kategorie=힐링&page=1&user_id=${sessionScope.user_id}'">힐링</div>
                    <div class="menu4" onclick="location.href='suggest_main.do?kategorie=트레킹&page=1&user_id=${sessionScope.user_id}'">트레킹</div>
                    <div class="menu5" onclick="location.href='suggest_main.do?kategorie=맛집&page=1&user_id=${sessionScope.user_id}'">맛집</div>
                    <div class="menu6" onclick="location.href='suggest_main.do?kategorie=올레길&page=1&user_id=${sessionScope.user_id}'">올레길</div>
                </div>
                <br>
                <div class="search">
                    <input class="form-control search1" type="search" placeholder="검색어 입력">
                    <button class="btn btn-outline-secondary search2" onclick="search();"><i class="fa fa-search" aria-hidden="true"></i></button>
                </div>
                <br><br>
                <div class="nail">
            
					<% 
						List<SuggestDto> dto = (List)request.getAttribute("dto");
						int size = dto.size()-1;
						Paging pg = (Paging)request.getAttribute("paging");
						int s = pg.getPage()*6;
						
						Math.floor(s);
						
						int nail=1;
						int i=0;
						
						for(; i<=size; i++){
						String cName = "nail"+nail;
					%>
						<div class="<%=cName%>">
						<% SuggestDto sd = dto.get(i); %>
							<a href="suggest_detail.do?sug_num=<%=sd.getSug_num()%>">
           			   			<div class="nail_img"><div class="sleep"><%=sd.getSug_term() %></div></div>
        					</a>
        				<div class="nail_inner">
            					<p class="nail_title"><%=sd.getSug_title() %></p>
            					<span class="nail_view">조회수 | <%=sd.getSug_views() %></span>
            					<span class="nail_push">좋아요 | <%=sd.getSug_push() %></span>
            					<hr style="margin-bottom: 0;">
            					<div class="nail_hrt">
            						<% if(sd.getDib()==1){
            						%>
            							<i class="fa fa-heart fa-xs" onclick="dibs('<%=sd.getSug_num()%>')"></i>
            						<%
            							}else{
            						%>
            							<i class="fa fa-heart-o fa-xs" onclick="dibs('<%=sd.getSug_num()%>')"></i>
            						<%
            							}
            						%>
            						 &nbsp; 찜하기</div>
            					
        					</div>
        				</div>
					<%		
							nail++;
						}
					
					%>
                    </div>
                <br>
					<c:if test="${sessionScope.user_id eq 'admin' }">
                		<div class="write">
		                    <button class="btn btn-outline-secondary" onclick="location.href='suggest_insert.do'">글등록</button>
		                </div>
		                <br><br>
		            </c:if>
                <div class="paging">
                <c:if test="${paging.prev}">
	    			<a href="suggest_main.do?kategorie=<%=dto.get(0).getSug_kategorie() %>&page=${paging.beginPage-1}&user_id=${sessionScope.user_id}" style="font-size:20px; margin-right: 5px;">prev</a>
				</c:if>
				<c:forEach begin="${paging.beginPage}" end="${paging.endPage }" step="1" var="index">
	    			<c:choose>
	        			<c:when test="${paging.page==index}">
	          			  	<span style="font-size: 20px; color: gray; margin: 5px;">${index}</span>
	        			</c:when>
	        			<c:otherwise>
	           			 	<a href="suggest_main.do?kategorie=<%=dto.get(0).getSug_kategorie() %>&page=${index}&user_id=${sessionScope.user_id}" style="font-size:20px; margin:5px;">${index}</a>
	        			</c:otherwise>
	    			</c:choose>
				</c:forEach>
				<c:if test="${paging.next}">
	   				<a href="suggest_main.do?kategorie=<%=dto.get(0).getSug_kategorie() %>&page=${paging.endPage+1}&user_id=${sessionScope.user_id}" style="font-size:20px; margin-left: 5px;">next</a>
				</c:if>
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
			</div>
	</body>
</html>