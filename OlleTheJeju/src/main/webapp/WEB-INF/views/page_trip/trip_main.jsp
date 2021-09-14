<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script type="text/javascript">
            	$(function(){
				var nail=1;
					<c:forEach items="${place}" var="p" varStatus="vs" begin="0" end="5">
					console.log(nail);
					var cName = "nail"+nail;
					var text='<div class="nail'+nail+'">'
						+'<a href="trip_detail.do?trip_num=${p.trip_num}">'
           			    +'<div class="nail_img">'
           			 	+'</div>'
        				+'</a>'
        				+'<div class="nail_inner">'
            			+'<p class="nail_title">'+'${p.trip_title}'+'</p>'
            			+'<span class="nail_view">'+'조회수 | ${p.trip_views}'+'</span>'
            			+'<span class="nail_push">'+'추천수 | ${p.trip_push}'+'</span>'
            			+'<hr style="margin-bottom: 0;">'
            			+'<div class="nail_hrt"><i class="fa fa-heart-o fa-xs"></i> &nbsp; 찜하기</div>'
        				+'</div>'
        				+'</div>';
					$(".nail").append(text);
					nail++;
				</c:forEach>
			}); 
        </script>
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
                    <div class="menu1">관광명소</div>
                    <div class="menu2">착한가격 업소</div>
                    <div class="menu3">맛집 15선</div>
                    <div class="menu4" onclick='location.href="trip_jeju.do"'>방언 사전</div>
                </div>
                <br><br>
                <div class="nail">
<%--                 <c:forEach items="${place }" var="p" begin="0" end="5">
                   <div class="nail1">
        				<a href="trip_detail.do?trip_num=${p.trip_num}">
                       		 <div class="nail_img"></div>
                		</a>
                		<div class="nail_inner">
                    		<p class="nail_title">${p.trip_title}</p>
                    		<span class="nail_view">조회수 | ${p.trip_views}</span>
                    		<span class="nail_push">추천수 | ${p.trip_push}</span>
                    		<hr style="margin-bottom: 0;">
                    		<div class="nail_hrt"><i class="fa fa-heart-o fa-xs"></i> &nbsp; 찜하기</div>
                		</div>
                	</div>
                </c:forEach> --%>
                </div>
                <br>
                <div class="write">
                    <button class="btn btn-outline-secondary" onclick="location.href='trip_insert.do'">글등록</button>
                </div>
                <br>
                <div class="paging">
                    1 | 2 | 3 | 4 | 5 
                </div>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>