<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>제주상황-맛집예약/현황(썸네일 클릭시 팝업창2-예약정보입력)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation_rest_detail2.css" rel="stylesheet" type="text/css" />
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
    <body>
        <div class="wrapper">
            <div class="main">
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
                             <div class="part">오전</div>
                            <input type="button" class="time" name="time" value="9:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" value="9:30">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" value="10:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" value="10:30">
                            <br/>
                            <input type="button" class="time" name="time" value="11:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" value="11:30">
                            <br/>
                            <div class="part">오후</div>
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="12:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="12:30">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="13:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="13:30">
                            <br/>
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="16:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="16:30">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="17:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="17:30">&nbsp;&nbsp;
                            <br/>
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="18:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="18:30">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="19:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="19:30">&nbsp;&nbsp;
                            <br/>
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="20:00">&nbsp;&nbsp;
                            <input type="button" class="time" name="time" onclick="checkBtn(this);" value="20:30">&nbsp;&nbsp;
                            <br/>
                            <div class="clearfix">
                                <div class="enable-reg">
                                    <div class="enable"></div><span class="text-time">&nbsp;&nbsp;가능</span>&nbsp;&nbsp;<div class="unable"></div><span class="text-time">&nbsp;&nbsp;불가</span>
                                </div>
                            </div>
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
                                <th>이메일</th>
                                <td><input type="text" name="email" placeholder="이메일을 입력하세요"></td>
                            </tr>
                            <tr>
                                <th>요청사항</th>
                                <td><input type="text" name="require" placeholder="업체에 요청하실 사항을 입력하세요"></td>
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
                    <input id="btn1" type="submit" name="reserved" value="예약완료">
                </div>
            </div>
        </div>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jejusituation/jejusituation_rest.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/jejusituation/calendar_rendering.js"></script>
    </body>
</html>