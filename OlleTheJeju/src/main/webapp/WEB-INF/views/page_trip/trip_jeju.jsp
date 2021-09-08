<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관광정보 방언사전</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/trip/trip_jeju.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script type="text/javascript">
        	$(function(){
        		var p = $("#page").val();
        			page(p);
       		 });
        	
     	   	function page(p){
     	   		$(".page").empty();
     	   		
     	   		if((p%10)==0){ 
     	   			var i=p-9;
     	   		}else if((p%10)>=1){
     	   			var i = (Math.floor(p/10)*10)+1;
     	   		}
     	   		var j = i+10;
     	   		
    			for(i; i<j; i++){
    				if(i>716){//716 마지막페이지
    					break;
    				
    				}else if(i==p){
    					$(".page").append("<a style='margin:3px; text-decoration:underline !important;'>"+i+"</a>");
    				}else{
    					$(".page").append("<a style='margin:3px;' href='trip_jeju_page.do?page="+i+"'>"+i+"</a>");
    				}
    			}	
        	}
     	   	
     	   	function prev(){
     	   		var p = $("#page").val();
     	   		if(p>10){
     		   		var first = parseInt($(".page").children('a:eq(0)').text())-1;
 	  	 			window.location.href= 'trip_jeju_page.do?page='+first;
     	   		}else{
     	   			alert("첫번째 페이지 입니다.");
     	   		}
     	   	}
     	   	
     	   	function next(){
     	   		var p = $("#page").val();
     	   		if(p<711){
     		   		var last = parseInt($(".page").children('a:eq(9)').text())+1;
 	  	 			window.location.href= 'trip_jeju_page.do?page='+last;
     	   		}else{
     	   			alert("마지막 페이지 입니다.");
     	   		}
     	   	}
        </script>
    </head>
	<body>
	<input type="hidden" value="${page}" id="page">
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
                    <div class="menu4">방언 사전</div>
                </div>
                <br>
                <div class="search">
                    <input class="form-control search1" type="search" placeholder="검색어 입력">
                    <button class="btn btn-outline-secondary search2"><i class="fa fa-search" aria-hidden="true"></i></button>
                </div>
               
                <br>
                <div class="desc">
                    <div class="dialect">
                    	<small style="grid-column-start: 1; grid-column-end: 2;">* 아래아가 안보일 경우: 새굴림 폰트 설치</small>
                        <table class="table">
                            <tr class="table-secondary">
                                <th style="width: 50%;">
                                    방언
                                </th>
                                <th style="width: 50%;">
                                    뜻풀이
                                </th>
                            </tr>
       
                            <c:forEach var="val" begin="0" end="9">
                            	<tr>
                                	<td style="font-family:'새굴림';">${dia[val]} </td>
                                	<td style="font-family:'새굴림';">${kor[val]}</td>
                            	</tr>
                            </c:forEach>
     
                        </table>
                    </div>
                </div>
                <br><br><br>
                <div class="paging">
                			<a href="#" onclick="prev();">&lt;&lt;</a>
							<span class="page"></span>
                			<a href="#" onclick="next();">&gt;&gt;</a>
                </div>
                <br><br><br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>