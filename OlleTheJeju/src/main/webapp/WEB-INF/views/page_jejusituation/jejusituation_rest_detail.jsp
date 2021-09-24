<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>제주상황-맛집예약/현황(썸네일 클릭시 팝업창-매장확인)</title>
       <%--  <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation_rest_detail.css" rel="stylesheet" type="text/css" /> --%>
        <!-- <link href="js/jejusituation_rest.js" rel="script" type="text/javascript"/> -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </head>
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
    margin:auto 0;
}
.nail-first {
    display: grid;
    grid-template-columns: 350px 300px;
    grid-gap: 40px;
    padding-left: 40px;
    padding-right: 40px;
    margin-bottom:100px;
    justify-content: center;
}
.nail1 {
    grid-column-start: 1;
    grid-column-end: 2;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}
.nail1 img{
	width:100%;
	height:100%;
}
.nail2 {
    grid-column-start: 2;
    grid-column-end: 3;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}
.tablebox{
    border: 1px dashed transparent;
    margin-top: 20px;
}
.tablebox2{
    border: 1px dashed transparent;
    margin-top: 20px;
}

.nail-second {
    display: grid;
    grid-template-columns: 350px 300px;
    grid-gap: 40px;
    padding-left: 40px;
    padding-right: 40px;
    height: 210px;
    justify-content: center;
}
.nail3 {
    grid-column-start: 1;
    grid-column-end: 3;
    background: white;
    border:2px solid black;
    border-radius:5px;
    color: black;
}
.bottom-btn{
    color: black;
    margin-left: 48%;
}
.my-modal{
    position:fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    display:none;
    width:100%;
    height:100%;
    z-index: 2;
    background-color: rgba(0,0,0,0.5);
    justify-content: center;
}

.my-modal .close-btn{
    cursor:pointer;
    position:relative;
    top:5%;
    left:30%;
}

.my-modal iframe{
    width: 800px;
    height: 730px;

}
    	
    </style>
    <body>
        <div class="wrapper">
            <div class="main">
                <br>
                <br>
                <br>
                <br>
                <br>
              <!--모달창-->
            <div class="my-modal">
                <div class="close-btn" onclick="closeModal();">❌</div>
                <iframe src="jejusituation_rest_detail2.do" title="모달창">

                </iframe>
            </div>
                <!-- 썸네일 -->
                <div class="nail-first">
                    <div class="nail1">
						<img src="<%=request.getContextPath() %>/resources/img/jejusitu/${img.img_title}" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                    </div>
                    <div class="nail2">
                        <div class="tablebox">
                            <table class="table">
                                <tr>
                                    <th>상호명 :</th>
                                    <td>${jeju.situ_name }</td>
                                </tr>
                                <tr>
                                    <th>전화번호 :</th>
                                    <td>${jeju.situ_phone }</td>
                                </tr>
                                <tr>
                                    <th>주소 :</th>
                                    <td>${jeju.situ_addr}</td>
                                </tr>
                                <tr>
                                    <th>운영시간 :</th>
                                    <td>${jeju.situ_open_time }~${jeju.situ_close_time }</td>
                                </tr>
                                <tr>
                                    <th>한식/양식/일식/중식 : :</th>
                                    <td>${jeju.situ_gubun }</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="nail-second">   
                    <div class="nail3">
                        <div class="tablebox2">
                            <table class="table">
                               <thead>
                               	<tr>
                               		<th>메뉴</th>
                               		<th>가격(단위: KRW, 원)</th>
                               	</tr>
                               </thead>
                               <tbody>
                               	<c:choose>
                               		<c:when test="${empty menuList}">
                               			<tr>
                               				<td colspan="2">---영업 준비 중입니다---</td>
                               			</tr>
                               		</c:when>
                               		<c:otherwise>
                               			<c:forEach items="${menuList }" var="item">
                               			<tr>
                               				<td>${item.menu}</td>
                               				<td>${item.price }</td>
                               			</tr>	
                               			</c:forEach>
                               		</c:otherwise>
                               	</c:choose>
                               </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="bottom-btn">
                    <input type="button" name="reverved" value="예약하기" onclick="location.href='./jejusituation_rest_detail2.do?situ_num=${jeju.situ_num}';"/>
                </div>
            </div>
            
        </div>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jejusituation/jejusituation_rest.js"></script>
    </body>
    </html>