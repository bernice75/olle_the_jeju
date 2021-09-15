<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관광일정 insert</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/trip/trip_insert.css?var=1" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        
		<script src="./resources/js/trip/trip_insert.js" type="text/javascript"></script>
    </head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>관광정보 등록</h2>
                </div>
                <br><br>
                <form action="trip_update_db.do" method="GET">
                	<input type="hidden" name="trip_num" value="${dto.trip_num }">
                    <div class="main-place">
                        <div id="carouselExampleFade" class="carousel slide carousel-fade slider" data-bs-ride="carousel">
                            <div class="carousel-inner imgs">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" alt="...">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                        <div class="place-info">
                            <fieldset>
                                <section>
                                    <label for="trip_title">장소명 : </label>
                                    <input type="text" class="form-control" name="trip_title" value="${dto.trip_title }">
                                </section>
                                <section>
                                    <label for="trip_content">기본정보 : </label>
                                    <textarea rows="8" cols="40" class="form-control" name="trip_content"> ${dto.trip_content }</textarea>
                                </section>
                                <section>
                                    <label for="trip_addr">주소 : </label>
                                    <input type="text" class="form-control" name="trip_addr" value="${dto.trip_addr }">
                                </section>
                                <section>
                                    <label for="trip_phone">전화번호 : </label>
                                    <input type="tel" class="form-control" name="trip_phone" value="${dto.trip_phone }">
                                </section>
                                <section>
                                    <label for="hash_content">카테고리 : </label>
                                    <select name="trip_kategorie" class="form-control" required >
                                    	<option value="명소">관광</option>
                                    	<option value="가격">착한가격업소</option>
                                    	<option value="맛집">맛집</option>
                                    </select>
                                </section>
                            </fieldset>
                        </div>
                        <fieldset>
                            <section>
                                <input type="file" class="insert-btn" name="img_1" style="float: left;" accept="image/*">
                                <input type="file" class="insert-btn" name="img_2" style="float: left;" accept="image/*">
                                <input type="file" class="insert-btn" name="img_3" style="float: left;" onchange="fileUpload();" accept="image/*">
                                <button class="btn btn-outline-success chk-btn" type="button" style="float: right;" onclick="imgChk();">미리보기</button>
                            </section>
                        </fieldset>
                    </div>
                    <br><br>
                    <div class="trip_text">
                        <h3>상세내용 등록</h3>
                        <hr class="line">
                        <div class="main-second">
                        	<textarea style="width: 1080px; height: 600px; resize: none;" name='trip_detail'>${dto.trip_detail }</textarea>
                        </div>
                    </div>
                    <div class="bottom-btn-group2">
                        <input id="btn1" type="submit" class="btn btn-primary" value="등록" >
                        <input id="btn2" type="button" class="btn btn-secondary" value="취소" onclick="">
                    </div>
                </form>
                <br><br><br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>