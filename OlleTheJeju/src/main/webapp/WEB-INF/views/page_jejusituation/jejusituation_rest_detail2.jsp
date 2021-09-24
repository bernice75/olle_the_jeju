<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>제주상황-맛집예약/현황(썸네일 클릭시 팝업창2-예약정보입력)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <%--  <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation_rest_detail2.css" rel="stylesheet" type="text/css" /> --%>
        <!-- <link href="js/jejusituation_rest.js" rel="script" type="text/javascript"/> -->
        <!-- 합쳐지고 최소화된 최신 CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <!-- 부가적인 테마 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.css"/>
    </head>
            <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/locales-all.min.js"></script>
<style>
@font-face {
    font-family: 'cafe24_ddh';
    src: url("<%=request.getContextPath()%>/resources/font/Cafe24Dangdanghae.ttf");
}
@font-face {
    font-family: 'cafe24_djh';
    src: url("<%=request.getContextPath()%>/resources/font/Cafe24Danjunghae.ttf");
}
@font-face {
    font-family: 'cafe24_sph';
    src: url("<%=request.getContextPath()%>/resources/font/Cafe24Simplehae.ttf");
}

* {
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    font-family: 'cafe24_djh';
}

body, html {
    height: 100%;
}

html {
    overflow: scroll;
}

body {
    margin: 0;
    padding: 0;
}

.wrapper {
    display: grid;
    color: white;
    width: 100%;
    height: 100%;
}

.wrapper {
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: 1fr 1fr;
}

.main {
    grid-column: 1/3;
    grid-row: 1/3;
    background: #F8F8FA;
}
.nail-first {
    display: grid;
    grid-template-columns: 400px 400px;
    grid-gap: 40px;
    padding-left: 40px;
    padding-right: 40px;
    height: 300px;
    justify-content: center;
    height:600px;
}

.exp{
    font-size:20px;
    font-weight:bold;
    margin-top:50px;
    margin-left:30px;
    margin-bottom:50px;
}

.range{
    display:flex;
    justify-content: center;
}

.range input{
    text-align: center;
}

.nail1 {
    grid-column-start: 1;
    grid-column-end: 2;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}

#calendar{
    height:450px;
}

.attached_img{
    position: absolute;
    margin-top: 17%;
}

.nail2 {
    grid-column-start: 2;
    grid-column-end: 3;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}

.nail-second {
    display: grid;
    grid-template-columns: 400px 400px;
    grid-gap: 40px;
    padding-left: 40px;
    padding-right: 40px;
    height: 200px;
    justify-content: center;
}
.nail3 {
    grid-column-start: 1;
    grid-column-end: 2;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}
.nail4 {
    grid-column-start: 2;
    grid-column-end: 3;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}

.bottom-line{
    width: 55%;
}
.bottom-reseved-check{
    position: relative;
    border: 1px dashed red;
    width: 50%;
    left: 23%;
    margin-top:150px;
    font-weight: bold;
    color: black;
    text-align:center;
    margin-bottom:20px;
}
.bottom-btn{
    color: black;
    margin-left: 46%;
}
#btn1{
    width: 80px;
}

.res-time{
    display:flex;
    flex-wrap:wrap;
    justify-content:flex-start;
}

.part{
    font-size:15px;
    font-weight:bold;
    margin-top:10px;
}

.time{
    width:60px;
    margin-left:30px;
    margin-bottom:30px;
    background-color: lightgray;
}


.enable-reg{
    float:right;
    margin-right:30px;
}

.enable,
.unable{
    display:inline-block;
    margin-left:30px;
    width:30px;
    height:30px;
}

.enable{
    background-color: #2ecc71;
}
.unable{
    background-color:lightgray;
}

.text-time{
    position:relative;
    bottom:10px;
    font-size:15px;
    font-weight: bold;
}
.break-time{
	width:fit-content;
	height:30px;
	margin-left:30px;
}
	
</style>
    <body>
        <div class="wrapper">
            <div class="main">
            <input type="hidden" name="situ_num" value="${situ_num }"/>
                <br>
                <br>
                <!-- 썸네일 -->
                <div class="nail-first">
                    <div class="nail1">
                        <div class="exp">
                            날짜선택
                         </div>   
                        <div id="calendar">

                        </div>
                    </div>
                    <div class="nail2">
                        <div class="exp">
                            시간선택<br/><br/>
                            ※브레이크 타임: 14~16시
                         </div> 
                         <div class="res-time">
							<c:forEach begin="${open_hour}" end="${close_hour}" var="item">
								<c:choose>
									<c:when test="${item ge 14 and item le 16}">
										<button class="break-time">브레이크 타임</button>
									</c:when>
									<c:otherwise>
										<input type="button" class="time" name="time" onclick="checkBtn(this);" value="${item}:${open_min}"/>
									</c:otherwise>
								</c:choose>
							</c:forEach>
                         </div>  
                    </div>
                </div>
                <br><br>
                <div class="nail-second">   
                    <div class="nail3">
                        <div class="exp">
                            인원 선택
                        </div>
                        <div class="range">
                            <input type="button" id="minus" value="➖" onclick="decCnt();"/>
                            <input type="number" id="cnt" name="visiters" value="1"/>
                            <input type="button" id="plus" value="➕" onclick="incCnt();"/>&nbsp;&nbsp;명
                        </div>
                    </div>
                    <div class="nail4">
                        <div class="exp">
                            예약자정보 입력
                        </div>    
                        <br><br>
                        <table class="table">
                            <tr>
                                <th>예약자</th>
                                <td><input type="text" name="name" placeholder="성함을 입력하세요"></td>
                            </tr>
                            <tr>
                                <th>연락처</th>
                                <td><input type="text" name="phone" placeholder="연락처를 입력하세요"></td>
                            </tr>
                            <tr>
                                <th>요청사항</th>
                                <td><input type="text" name="require" placeholder="업체에 요청하실 사항을 입력하세요"></td>
                            </tr>
                            <tr>
                            	<td colspan="2">
                            	     <p><strong>여기</strong>를 눌러주세요!</p>
                            	</td>
                            </tr>	
                        </table>
                    </div>
                </div>
                <br><br>
                <hr class="bottom-line">
               
                <div class="bottom-reseved-check">
                    예약날짜, 시간, 명수 (확인)
                </div>
                <div class="bottom-btn">
                    <input id="btn1" type="button" name="reserved" value="예약하기" onclick="sendData('${situ_num}');">
                </div>
            </div>
        </div>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jejusituation/jejusituation_rest.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/jejusituation/calendar_rendering.js"></script>
    </body>
</html>