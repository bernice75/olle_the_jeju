<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>제주상황-맛집예약/현황(맛집등록)</title>

        <link href="<%=request.getContextPath() %>/resources/css/jejusituation/jejusituation_rest_create.css" rel="stylesheet" type="text/css" />
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
                <form action="registerStore.do" method="post" encType="multipart/form-data">
                <input type="hidden" name="writer" value="${user.user_name }"/>
                <!-- 썸네일 -->
                <div class="nail-first">
                    <div class="nail1">
                        <img class="preview-target" src="" alt="미리보기"/>
                    </div>
                    
                    <div class="nail2">
                        <div class="tablebox">
                            <table class="table">
                                <tr>
                                    <th>상호명 :</th>
                                    <td><input type="text" name="company"></td>
                                </tr>
                                <tr>
                                    <th>전화번호 :</th>
                                    <td><input type="text" name="phone"></td>
                                </tr>
                                <tr>
                                    <th>주소 :</th>
                                    <td><input type="text" name="address"></td>
                                </tr>
                                <tr>
                                    <th>운영시간 :</th>
                                    <td><input type="text" name="time"></td>
                                </tr>
                                <tr>
                                    <th>한식/양식/일식/중식 :</th>
                                    <td>
                                        <select name="gubun">
                                            <option value="한식">한식</option>
                                            <option value="양식">양식</option>
                                            <option value="일식">일식</option>
                                            <option value="중식">중식</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <div class="attached_img">
                        <input type="file" id="ex_file" name="file" onchange="previewImage(this);" >
                    </div>
                </div>
                <br><br><br>
                <div class="nail-second">   
                    <div class="nail3">
                        <div class="tablebox2">
                       <table class="table">
                                <thead>
                                    <tr>
                                        <th>메뉴</th>
                                        <th>가격(원)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="menu"></td>
                                        <td><input type="number" name="price"></td>
                                    </tr>
                                </tbody>
                           
                            </table>
                        </div>
                    </div>
                </div>
                <br>
                <br>
            
                <div class="bottom-btn">
                    <input id="btn1" type="submit" name="create" value="등록">
                    <input id="btn2" type="button" name="cancel" value="취소">
                </div>
                </form>
            </div>
            
        </div>
        <script src="<%=request.getContextPath() %>/resources/js/jejusituation/jejusituation_rest_create.js"></script>
    </body>
</html>