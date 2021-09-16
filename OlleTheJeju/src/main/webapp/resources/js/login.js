function loginForm() {
	var user_id = $("#user_id").val();
	var user_pw = $("#user_pw").val();
	
	if(user_id == null || user_id == "") {
		alert("아이디가 입력되지 않았습니다.");
	}
	if(user_pw == null || user_pw == "") {
		alert("비밀번호가 입력되지 않았습니다.");
	}
	
	$.ajax({
		url: "login.do",
		type: "POST",
		data: {user_id: user_id, user_pw: user_pw},
		dataType: "text",
		success: function(data){
			console.log(data);
			if(data == null || data == "") {
				alert("로그인 정보가 일지하지 않습니다.");
				$("#user_pw").focus();
			} else {
				alert("반갑습니다~ \nOLLE THE JEJU 입니다!");
				location.href="home.do?user_id=" + user_id;
			}
		},
		error: function(){
		    alert("로그인 실패입니다. \n 관리자에게 문의하세요.");
		}
	});
}