<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.olle.dto.trip.TripDto" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.olle.dao.trip.Paging" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관광일정 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/trip/trip_main.css?var=1" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>제주도 모든 여행지를 한번에!</h2>
                    <p>
                        제주의 아름다운 여행지를 취향에 맞게 선택해 보세요!<br>
                        368개의 크고 작은 오름을 비롯하여 눈 돌리면 어디에서나 마주치는 한라산 그리고 푸른바다<br>
                        제주의 아름다운 여행지가 여러분의 선택을 기다립니다!
                    </p>
                </div>
                <br><br>
                <div class="menu">
                    <div class="menu1"><a href="trip_main.do?kategorie=명소&page=1" style="color:black;">관광명소</a></div>
                    <div class="menu2"><a href="trip_main.do?kategorie=가격&page=1" style="color:black;"> 착한가격 업소</a></div>
                    <div class="menu3"><a href="trip_main.do?kategorie=맛집&page=1" style="color:black;">맛집 15선</a></div>
                    <div class="menu4" onclick='location.href="trip_jeju.do"'>방언 사전</div>
                </div>
                <br><br>
                <div class="nail">
                
					<% 
						List<TripDto> dto = (List)request.getAttribute("dto");
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
						<% TripDto trip = dto.get(i); %>
							<a href="trip_detail.do?trip_num=<%=trip.getTrip_num()%>">
           			   			<div class="nail_img"></div>
        					</a>
        				<div class="nail_inner">
            					<p class="nail_title"><%=trip.getTrip_title() %></p>
            					<span class="nail_view">조회수 | <%=trip.getTrip_views() %></span>
            					<span class="nail_push">좋아요 | <%=trip.getTrip_push() %></span>
        					</div>
        				</div>
					<%		
							nail++;
						}
					
					%>
                </div>
                <br>
                <div class="write">
                    <button class="btn btn-outline-secondary" onclick="location.href='trip_insert.do'">글등록</button>
                </div>
                <br>
			<div class="paging">
				<c:if test="${paging.prev}">
	    			<a href="trip_main.do?kategorie=<%=dto.get(0).getTrip_kategorie() %>&page=${paging.beginPage-1}" style="font-size:20px; margin-right: 5px;">prev</a>
				</c:if>
				<c:forEach begin="${paging.beginPage}" end="${paging.endPage }" step="1" var="index">
	    			<c:choose>
	        			<c:when test="${paging.page==index}">
	          			  	<span style="font-size: 20px; color: gray; margin: 5px;">${index}</span>
	        			</c:when>
	        			<c:otherwise>
	           			 	<a href="trip_main.do?kategorie=<%=dto.get(0).getTrip_kategorie() %>&page=${index}" style="font-size:20px; margin:5px;">${index}</a>
	        			</c:otherwise>
	    			</c:choose>
				</c:forEach>
				<c:if test="${paging.next}">
	   				<a href="trip_main.do?kategorie=<%=dto.get(0).getTrip_kategorie() %>&page=${paging.endPage+1}" style="font-size:20px; margin-left: 5px;">next</a>
				</c:if>
			</div>
			<br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>