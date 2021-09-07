<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객지원 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/notice/notice.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<main class="main item">
	            <!-- 타이틀, 내용, 검색바 -->
	            <div class="notice">
	                <p class="not_title">고객지원</p>
	                <div class="not_inner">회원님들께서 가장 자주하시는 질문들을 모았습니다.<br>
	                    궁금하신 내용에 대해 검색해보세요.</div>
	            </div>
	            <div class="not_search">
	                <input type="text" class="form-control" placeholder="검색어 입력">
	                <button class="btn btn-outline-success" onclick="">검색</button>
	            </div>
	
	            <!-- 테이블: 나중에 jstl로 처리-->
	            <div class="accordion accordion-flush" id="accordionFlushExample">
	                <div class="accordion-item">
	                  <h2 class="accordion-header" id="flush-headingOne">
	                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
	                      Accordion Item #1
	                    </button>
	                  </h2>
	                  <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
	                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
	                  </div>
	                </div>
	                <div class="accordion-item">
	                  <h2 class="accordion-header" id="flush-headingTwo">
	                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
	                      Accordion Item #2
	                    </button>
	                  </h2>
	                  <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
	                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being filled with some actual content.</div>
	                  </div>
	                </div>
	                <div class="accordion-item">
	                  <h2 class="accordion-header" id="flush-headingThree">
	                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
	                      Accordion Item #3
	                    </button>
	                  </h2>
	                  <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
	                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the third item's accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.</div>
	                  </div>
	                </div>
	              </div>
				<br><br>
	            <div class="write">
                    <button class="btn btn-outline-secondary" onclick="location.href='notice_insert.do'">글등록</button>
                </div>
	
	            <div class="not_map">
	                <p>제주 관광지도 Down</p>
	                
	            <div class="map_bg">
	                <div class="not_map_down">
	                </div>
	                <br>
	                <div class="map_down_button">
	                <a href="" download><button>국문</button></a>
	                <a href="" download><button>영문</button></a>
	                <a href="" download><button>일문</button></a>
	                <a href="" download><button>중문</button></a>
	                </div>
	            </div>
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>