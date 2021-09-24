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
				if(data == "status") {
					alert("강제탈되된 아이디입니다.\n로그인하실 수 없습니다.");
				} else {
					alert("반갑습니다~ \nOLLE THE JEJU 입니다!");
					location.href="home.do?user_id=" + user_id;
				}
			}
		},
		error: function(){
		    alert("로그인 실패입니다. \n 관리자에게 문의하세요.");
		}
	});
}

function findId() {
	var user_email = $(".user_email1").val();
	if(user_email == "" || user_email == "") {
		alert("이메일이 입력되지 않았습니다.");
		$(".mb-3.user_email1").focus();
	} else {
		$.ajax({
		url: "findId.do",
		type: "POST",
		data: {user_email: user_email},
		dataType: "text",
		success: function(data){
			console.log(data);
			if(data == null || data == "") {
				alert("해당하는 정보가 존재하지 않습니다.");
			} else {
				if(data == "success") {
					$(".findid").attr("style", "display: block");
				} else {
					alert("이메일을 보낼 수 없습니다.");
				}
			}
		},
		error: function(){
		    alert("아이디찾기 실패입니다. \n 관리자에게 문의하세요.");
		}
	});
	}
}

function findPw() {
	var user_email = $(".user_email2").val();
	var user_id = $(".user_id").val();
	
	if(user_id == "" || user_id == null) {
		alert("아이디가 입력되지 않았습니다.");
		$(".mb-3.user_id").focus();
	}
	if(user_email == "" || user_email == "") {
		alert("이메일이 입력되지 않았습니다.");
	} else {
		$.ajax({
		url: "findPw.do",
		type: "POST",
		data: {user_id: user_id, user_email: user_email},
		dataType: "text",
		success: function(data){
			console.log(data);
			if(data == null || data == "") {
				alert("해당하는 아이디가 존재하지 않습니다.");
			} else {
				if(data == "success") {
					$(".findpw").attr("style", "display: block");
				} else {
					alert("이메일을 보낼 수 없습니다.");
				}
			}
		},
		error: function(){
		    alert("비밀번호찾기 실패입니다. \n 관리자에게 문의하세요.");
		}
	});
	}
}