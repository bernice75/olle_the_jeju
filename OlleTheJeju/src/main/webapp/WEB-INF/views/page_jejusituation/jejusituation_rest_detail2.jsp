<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>제주상황-맛집예약/현황(썸네일 클릭시 팝업창-매장확인)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./resources/css/jejusituation/jejusituation_rest_detail2.css" rel="stylesheet" type="text/css" />
        <!-- <link href="js/jejusituation_rest.js" rel="script" type="text/javascript"/> -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </head>
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
                <iframe src="jejusituation_detail2.do" title="모달창">

                </iframe>
            </div>
                <!-- 썸네일 -->
                <div class="nail-first">
                    <div class="nail1">
                        이미지 삽입
                    </div>
                    <div class="nail2">
                        <div class="tablebox">
                            <table class="table">
                                <tr>
                                    <th>상호명 :</th>
                                    <td>어디어디어디</td>
                                </tr>
                                <tr>
                                    <th>전화번호 :</th>
                                    <td>02-1123-4567</td>
                                </tr>
                                <tr>
                                    <th>주소 :</th>
                                    <td>서울시 강남구 서초동 어디 123</td>
                                </tr>
                                <tr>
                                    <th>운영시간 :</th>
                                    <td>09:00 ~ 20:00</td>
                                </tr>
                                <tr>
                                    <th>홈페이지 :</th>
                                    <td>1234@12345.com</td>
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
                                <tr>
                                    <th>메뉴 :</th>
                                </tr>
                                <tr>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                </tr>
                                <tr>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                </tr>
                                <tr>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                    <td>쿠바샌드위치 세트 15,000원</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="bottom-btn">
                    <input type="button" name="reverved" value="예약하기" onclick="location.href='jejusituation_detail2.do';"/>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="./resources/js/jejusituation/jejusituation_rest.js"></script>
        <script src="./resources/js/jejusituation/calendar_rendering.js"></script>
    </body>
</html>