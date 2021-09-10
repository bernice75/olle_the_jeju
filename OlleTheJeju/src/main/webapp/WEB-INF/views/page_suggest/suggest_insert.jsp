<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천일정 insert</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/suggest/suggest_insert.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        <script src="./resources/js/suggest/suggest_insert.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<br><br>
                <div class="main-text">
                    <h2>추천일정 등록</h2>
                    </p>
                </div>
                <br><br>
                <form>
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
                                    <label for="sug_title">제목 : </label>
                                    <input type="text" class="form-control" name="sug_title">
                                </section>
                                <section>
                                    <label for="sug_content">내용 : </label>
                                    <textarea rows="10" cols="40" class="form-control" name="sug_content"></textarea>
                                </section>
                                <section>
                                    <label for="sug_term" style="margin-right: 90px;">시작일 : <input type="date" id="sug_term" class="form-control sug_term_start" name="sug_term_start"></label>
                                    <label for="sug_term">마감일 : <input type="date" class="form-control sug_term_end" name="sug_term_end" onchange="date();"></label>
                                </section>
                                <section>
                                    <label for="tendency">성향 : </label>
                                    <div class="btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tendency" value="혼자"> 혼자
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tendency" value="여자끼리"> 여자끼리
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tendency" value="남자끼리"> 남자끼리
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tendency" value="연인"> 연인
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="radio" class="btn-check" name="tendency" value="가족"> 가족
                                        </label>  
                                    </div>
                                </section>
                                <section>
                                    <label for="hash_content">해시태그 : </label>
                                    <input type="text" class="form-control" id="hashtag" name="hash_content" placeholder="콤마(,)로 구분" onchange="hash();">
                                    <input type="hidden" class="form-control hashtag" name="hash_content">
                                    <div class="hash_inner"></div>
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
                    <div class="suggest_text">
                        <div class="day-btn">
                            <h3>일정 등록</h3>
                        </div>
                        <hr class="line">
                        <div class="main-second">
                            <div class="main-map">
                                
                            </div>
                        </div>
                    </div>
                    <div class="bottom-btn-group2">
                        <input id="btn1" type="submit" class="btn btn-primary" value="등록" onclick="">
                        <input id="btn2" type="button" class="btn btn-secondary" value="취소" onclick="">
                    </div>
                </form>
                <br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>