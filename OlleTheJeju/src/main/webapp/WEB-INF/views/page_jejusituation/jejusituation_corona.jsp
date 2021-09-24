<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>제주상황-제주코로나상황</title>
        <link href="<%=request.getContextPath() %>/resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation_corona.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath() %>/resources/css/footer.css" rel="stylesheet" type="text/css" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        <div class="wrapper">
                  <jsp:include page="../include/header.jsp"></jsp:include>
				<c:set var="label1" value="${label1 }"/>
				<c:set var="label2" value="${label2 }"/>
				<c:set var="label3" value="${label3 }"/>
				<c:set var="label4" value="${label4 }"/>
				<c:set var="label5" value="${label5 }"/>
				<c:set var="label6" value="${label6 }"/>
				<c:set var="label7" value="${label7 }"/>
				<c:set var="data1" value="${data1 }"/>
				<c:set var="data2" value="${data2 }"/>
				<c:set var="data3" value="${data3 }"/>
				<c:set var="data4" value="${data4 }"/>
				<c:set var="data5" value="${data5 }"/>
				<c:set var="data6" value="${data6 }"/>
				<c:set var="data7" value="${data7 }"/>
            <div class="main">
                <br><br>
                <div class="main-text">
                    <h2>제주상황</h2>
                </div>
                <!-- 상단 하이차트 부분 -->
                <div class="main-chart">
                    <div class="main-chat-title">
                        <!-- <h2>제주 코로나 상황</h2> -->
                    </div>
                    <div class="chart">
  						<canvas id="myChart"></canvas>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <!-- 하이차트 아래 코로나 감염현황 박스 -->
                <div class="nail">
                    <div class="nail1">
                        <p>감염현황</p>
                        <div class="corona-status">
                        	<object class="mini-status" type="text/html" data="https://www.visitjeju.net/kr/bigdatamap/">
                        	</object>
                        </div>
                    </div>                   
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <!-- 하단 배너 -->
                <div class="nail-second">
                    <div class="nail2" onclick="openModal();">
                        <p>코로나19 브리핑 영상보기</p>
                    </div>                   
                </div>
                <div class="my-modal">
                    <div class="close-btn" onclick="closeModal();">❌</div>
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/-63YEh_AYY8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </div>

            <!-- footer -->
            <footer class="footer item">
                <div class="aboutUs">
                    <div class="olle_inner_wrap">
                        <div class="info">About Us</div>
                        <div class="business_info">
                            <ul class="txtWrap">
                                <li style="color:#86868c">상상속 여행을 현실로, 올레더제주</li>
                                <li style="color:#86868c">contact : ollethejeju@gmail.com</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="navigations">
                    <div class="olle_inner_wrap">
                        <div class="info">Navigations</div>
                        <div class="business_nav">
                            <ul class="txtWrap nav1">
                                <li style="color:#86868c">Home</li>
                                <li style="color:#86868c">관광일정</li>
                                <li style="color:#86868c">추천일정</li>
                            </ul>
                            <ul class="txtWrap nav2">
                                <li style="color:#86868c">나만의 일정</li>
                                <li style="color:#86868c">제주상황</li>
                                <li style="color:#86868c">고객지원</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="jejuMap">
                    <div class="olle_inner_wrap">
                        <div class="info">JeJu Map Down</div>
                        <div class="business_info">
                            <i class="fa fa-map fa-5x" aria-hidden="true"></i>
                        </div>
                    </div>
                </div>
                <div class="copyright">Copyright@ 2021 All rights reserved</div>
            </footer>
        </div>
        <script src="<%=request.getContextPath() %>/resources/js/jejusituation/jejusituation_corona.js"></script>
        <script>
    	$(function(){
    		var chart=document.querySelector("#myChart");
			var lab1="<c:out value='${label1}'/>";
			var lab2="<c:out value='${label2}'/>";
			var lab3="<c:out value='${label3}'/>";
			var lab4="<c:out value='${label4}'/>";
			var lab5="<c:out value='${label5}'/>";
			var lab6="<c:out value='${label6}'/>";
			var lab7="<c:out value='${label7}'/>";
			var data1="<c:out value='${data1}'/>";
			var data2="<c:out value='${data2}'/>";
			var data3="<c:out value='${data3}'/>";
			var data4="<c:out value='${data4}'/>";
			var data5="<c:out value='${data5}'/>";
			var data6="<c:out value='${data6}'/>";
			var data7="<c:out value='${data7}'/>";
    		var d={
    			labels:[lab1,lab2,lab3,lab4,lab5,lab6,lab7],
    			datasets:[{
    				label:"제주도 코로나 상황(매일 오전 10시 30분에 업데이트)",
    				data:[
    					data1,data2,data3,data4,data5,data6,data7
    				],
    				borderColor:"rgb(255, 99, 132)",
    				backgroundColor: "rgb(255, 99, 132)"
    			}]
    		};
    		var config={
    			type:'line',
    			data:d,
    			options: {}
    		};
    		var graph=new Chart(chart,config);
    	});
    </script>
    </body>
</html>