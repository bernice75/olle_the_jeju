<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자페이지 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/admin/admin_main.css" rel="stylesheet" type="text/css" />
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
	                    <li><a href="admin.do">회원관리</a></li><br>
	                    <li><a href="admin_warn.do">신고 내역</a></li><br>
	                    <li><a href="admin_plan.do">게시물 관리</a></li><br>
	                    <li><a href="admin_inquire.do">문의 내역</a></li><br>
	              </ul>
	            </div>
	        </div>
	        <!-- 회원 관리  -->
	        <main class="main item">
	            <div class="user_plan">
	                <div class="plan_title">
	                    <p><b>회원 관리</b></p>
	                </div>
	            
	            <br>
	        
	            <div class="admin_user">
	                <button class="btn btn-primary btn-block" onclick="">전체 수정</button>
	
	                <br><br>
	            
	            <div class="admin_user_table">
	                <table class="table" border="1">
	                    <tr>
	                        <th>아이디</th>
	                        <th>가입일</th>
	                        <th>가입구분</th>
	                        <th>강제 탈퇴</th>
	                        <th>수정여부</th>
	                    </tr>
	                    <tr>
	                        <td>user</td>
	                        <td>1994 / 5 / 20</td>
	                        <td>
	                            <select class="form-control">
	                                <option>개인</option>
	                                <option>사업자</option>
	                            </select>
	                        </td>
	                        <td>
	                            <select class="form-control">
	                                <option>예</option>
	                                <option>아니오</option>
	                            </select>
	                        </td>
	                        <td>
	                            <button class="btn btn-primary btn-block" onclick="">수정</button>
	                        </td>
	                    </tr>
	                </table>
	            </div>    
	        </div>
	
	        <br><br><br>
	            <!-- 페이징 처리 -->
	            <div class="admin_user_paging">
	                페이징 처리
	            </div>
	            </div>
	                
	        </main>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>