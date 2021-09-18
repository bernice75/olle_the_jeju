<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>제주상황-맛집예약/현황</title>
        <link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/jejusituation/jejusituation_rest.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="../include/header.jsp"></jsp:include>

            <div class="main">
                <br><br>
                <div class="main-text">
                    <h2>제주 맛집 및 예약현황</h2>
                </div>
                <br>
                <br><br>
                <div class="menu">
                    <div class="menu1">한식</div>
                    <div class="menu2">중식</div>
                    <div class="menu3">일식</div>
                    <div class="menu4">양식</div>
                </div>
                <br>
                <div class="search">
                    <input class="form-control search1" type="search" placeholder="검색어 입력">
                    <button class="btn btn-outline-secondary search2"><i class="fa fa-search" aria-hidden="true"></i></button>
                </div>
                <br><br>
            <!--모달창<-아이템-->
            <div class="my-modal">
                <div class="close-btn" onclick="closeModal();">❌</div>
                <iframe src="jejusituation_rest_detail.do" title="모달창">

                </iframe>
            </div>
            <!--추후 사용자 모드(사장님인지에 따라) 자바스크립트가 변경되어야 할 것-->
            <div class="my-modal2">
                <div class="close-btn2" onclick="closeModal2();">❌</div>
                <iframe src="jejusituation_rest_create.do" title="모달창">

                </iframe>
            </div>

                <!-- 썸네일 -->
                <div class="nail">
                    <div class="nail1" onclick="openModal('${oneJeju.situ_num}');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${oneImg.img_title}" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png';"/>
                        <div class="nail1-text1 text">${oneJeju.situ_name }
                            <span class="nail1-text2 text">${oneJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${oneJeju.situ_addr }</div>
                    </div>
                    <div class="nail2" onclick="openModal('${twoJeju.situ_num}');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${twoImg.img_title}" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                        <div class="nail1-text1 text">${twoJeju.situ_name }
                            <span class="nail1-text2 text">${twoJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${twoJeju.situ_addr }</div>
                    </div>
                    <div class="nail3" onclick="openModal('${threeJeju.situ_num}');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${threeImg.img_title}" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                        <div class="nail1-text1 text">${threeJeju.situ_name}
                            <span class="nail1-text2 text">${threeJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${threeJeju.situ_addr }</div>
                    </div>
                </div>
                <br><br><br>
                <div class="nail">
                    <div class="nail4" onclick="openModal('${fourJeju.situ_num}');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${fourImg.img_title}" alt="ex"  onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                        <div class="nail1-text1 text">${fourJeju.situ_name }
                            <span class="nail1-text2 text">${fourJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${fourJeju.situ_addr}</div>
                    </div>
                    <div class="nail5" onclick="openModal('${fiveJeju.situ_num }');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${fiveImg.img_title }" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                        <div class="nail1-text1 text">${fiveJeju.situ_name }
                            <span class="nail1-text2 text">${fiveJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${fiveJeju.situ_addr }</div>
                    </div>
                    <div class="nail6" onclick="openModal('${sixJeju.situ_num}');">
                        <img class="store" src="<%=request.getContextPath() %>/resources/img/jejusitu/${sixImg.img_title }" alt="ex" onerror="this.src='<%=request.getContextPath()%>/resources/img/noImage.png'"/>
                        <div class="nail1-text1 text">${sixJeju.situ_name }
                            <span class="nail1-text2 text">${sixJeju.situ_gubun }</span>
                        </div>
                        <div class="nail1-text3 text">${sixJeju.situ_addr }</div>
                    </div>
                </div>
                <br>
                <div class="write">
                    <!-- <button class="btn btn-outline-secondary" name="createrest" onclick="openModal2();">맛집등록</button> -->
                    <button class="btn btn-outline-secondary" name="createrest" onclick="registerStoreForm();">맛집등록</button>
                </div>
                <br><br>
                <!-- 페이징 처리 -->
                <div class="paging"> 페이징 처리 </div>
                <br><br><br>
            </div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
        </div>
        <script type="text/javascript" src="./resources/js/jejusituation/jejusituation_rest.js"></script>
        <script>
        	function registerStoreForm(){
        		$.ajax({
        			method:"POST",
        			data:`<%=session.getAttribute("user_id")%>`,
        			contentType:false,
        			url:"jejuSituationValidUser.do",
        			success:function(json){
        				console.log(`msg:${json}`);
					   if(json.msg===true){
        					alert("맛집 등록 페이지로 이동합니다");
            				openModal2();
        				}else{
        					alert("권한이 부여되지 않았습니다");
        				}
        			},
        			error:function(msg){
        				alert("죄송합니다. 접근하실 수 없습니다.");
        			}
        		});
        	}
        </script>
    </body>
</html>