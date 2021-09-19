<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 신고내역</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
       	<link href="./resources/css/admin/adminwarn.css" rel="stylesheet" type="text/css" />
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
			<div class="admin_nav">
	            <div class="admin_nav_align">
	                <p style="font-size: 22px;padding-left: 30px;">관리자페이지</p>
	                <br>
	                <ul style="list-style: none;">
	                    <li><a href="admin_main.do">회원관리</a></li><br>
	                    <li><a href="admin_warn.do">신고 내역</a></li><br>
	                    <li><a href="admin_plan.do">게시물 관리</a></li><br>
	                    <li><a href="admin_inquire.do">문의 내역</a></li><br>
	              </ul>
	            </div>
	        </div>
	        <!-- 신고  -->
	        <main class="main item">
	
	            <div class="user_plan">
	                <div class="plan_title">
	                    <p><b>신고</b></p>
	                </div>
	                <br>
	                <table class="table" border="1">
	                    <tr>
	                        <th><input type="checkbox"></th>
	                        <th>신고 번호</th>
	                        <th>신고자</th>
	                        <th>신고대상</th>
	                        <th>신고사유</th>
	                        <th>글번호</th>
	                        <th>신고 일자</th>
	                        <th>공개 여부</th>
	                        <th>삭제</th>
	                    </tr>
	                    <tr>
	                        <td><input type="checkbox"></td>
	                        <td>21</td>
	                        <td>user</td>
	                        <td>user2</td>
	                        <td>욕설, 비속어</td>
	                        <td>116</td>
	                        <td>2021/05/26</td>
	                        <td>공개</td>
	                        <td><button class="btn btn-primary btn-block" onclick="">삭제</button></td>
	                    </tr>
	                </table>
	
	                <br>
	
	                <div class="admin_warn_btn">
	                    <button class="btn btn-primary btn-block" onclick="">삭제</button>
	                    <button class="btn btn-primary btn-block" onclick="">공개</button>
	                    <button class="btn btn-primary btn-block" onclick="">경고</button>
	                </div>
	            </div> 
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>