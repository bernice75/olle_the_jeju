//아이디 중복확인 체크
function idChkForm() {
	var idTitle = $("#user_id_chk")[0].title;
	if(idTitle == "n") {
		alert("아이디 중복체크는 필수사항입니다.");
		$("#user_id").focus();
	}
}
function idChk() {
	var idTitle = $("#user_id_chk")[0].title;
	var inputId = $("#user_id").val().trim();
	
	if(inputId == null || inputId == "") {
		alert("id가 입력되지 않았습니다.");
		$("#user_id").focus();
	} else {
		$.ajax({
			url: "idChk.do",
			type: "POST",
			data: {user_id: inputId},
			dataType: "text",
			success: function(data){
				console.log(data);
				if(data == 1) {
					alert("이미 존재하는 id입니다.");
					$("#user_id").focus();
				} else if(data == 0) {
					alert("사용 가능한 id입니다.");
					$("#user_id_chk")[0].title = "y";
					$("#user_pw").focus();
				}
			},
			error: function(){
			    alert("id중복체크 실패입니다. \n 관리자에게 문의하세요.");
			}
		});
	}
}
//비밀번호 체크
function pwChk() {
	var pw = $("#user_pw").val();
	var pwChk = $("#user_pw_chk").val();
	
	if(pw == pwChk) {
		alert("입력하신 비밀번호가 일치합니다.");
	} else {
		alert("다시 입력해주세요.");
		$("#user_pw_chk").focus();
	}
}

//닉네임 중복 확인
function nickChk() {
	var nickTitle = $("#user_nick_chk")[0].title;
	var inputNick = $("#user_nick").val().trim();
	
	if(inputNick == null || inputNick == "") {
		alert("닉네임이 입력되지 않았습니다.");
		$("#user_nick").focus();
	} else {
		$.ajax({
			url: "nickChk.do",
			type: "POST",
			data: {user_nick: inputNick},
			dataType: "text",
			success: function(data){
				console.log(data);
				if(data == 1) {
					alert("이미 존재하는 닉네임입니다.");
					$("#user_nick").focus();
				} else if(data == 0) {
					alert("사용가능한 닉네임입니다.");
					$("#user_nick_chk")[0].title = "y";
				}
			},
			error: function(){
			    alert("닉네임중복체크 실패입니다. \n 관리자에게 문의하세요.");
			}
		});
	}
}

//우편번호
function findAddr() {
	new daum.Postcode({
		oncomplete: function(data) {
		    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
			// 도로명 주소의 노출 규칙에 따라 주소를 표시
	       	// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기
	       	var roadAddr = data.roadAddress; // 도로명 주소 변수
	       	var extraRoadAddr = ''; // 참고 항목 변수
	
	       	// 법정동명이 있을 경우 추가 (법정리는 제외)
	       	// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	       	if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	       	    extraRoadAddr += data.bname;
	       	}
	       	// 건물명이 있고, 공동주택일 경우 추가
	       	if(data.buildingName !== '' && data.apartment === 'Y'){
	       	   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	       	}
	       	// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열
	       	if(extraRoadAddr !== ''){
	       	    extraRoadAddr = ' (' + extraRoadAddr + ')';
	       	}
	
	       	// 우편번호와 주소 정보를 해당 필드에 넣는다.
	       	//document.getElementById('우편번호input').value = data.zonecode;
	       	document.getElementById("user_addr").value = roadAddr; //도로명 주소
	       	document.getElementById("user_addr").value += " " + data.jibunAddress; //상세 주소
	   	
	    	// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	       	if(roadAddr !== ''){
	       	    document.getElementById("user_addr").value += extraRoadAddr;
	       	} else {
	       	    document.getElementById("user_addr").value += '';
	       	}
		}
	}).open();
}

//메일 인증
function emailChkForm() {
	var emailChk = $("#emailChk")[0].title;
	var userEmail = $("#user_email").val().trim();
	
	if(userEmail == null || userEmail == "") {
		alert("메일이 입력되지 않았습니다.");
		$("#user_email").focus();
	} else {
		if(!confirm("작성하신 메일이 '" + userEmail + "' 이 맞으십니까?")) {
			//아니오를 클릭했을 경우 로직
			alert("메일을 다시 입력해주세요.");
			$("#user_email").focus();
		} else {
			//예를 클릭했을 경우 로직
			alert("작성하신 메일로 인증번호가 전송됩니다.");
			$('#user_email_chk').prop('readonly', false);
			
			$.ajax({
				url: "emailChk.do",
				type: "POST",
				data: { user_email: userEmail },
				success: function(data){
					$("#email_number").val(data);
					alert("메일이 발송되었습니다. \n 인증번호를 입력해주세요.");
				},
				error: function(){
				    alert("메일 발송에 실패했습니다. \n 관리자에게 문의하세요.");
				}
			});
		}
	}
}
//인증번호 체크
function emailNumberChk() {
	var emailChk = $('#user_email_chk').val().trim();
	var emailChkNumber = $("#email_number").val();
					
	if(emailChkNumber == emailChk) {
		alert("인증번호가 일치합니다. \n 인증이 완료되었습니다.");
		$('#user_email_chk').prop('readonly', true);
		$("#emailChk")[0].title = "y";
	} else {
		alert("인증번호가 일치하지 않습니다. \n 다시 입력해주세요.");
		$('#user_email_chk').focus();
	}
}

// 회원가입 정보 저장
function btn_usrSave() {
	var agree = $("#agree").val();
	//약관 동의 여부
	if(agree == "on") {
		var idTitle = $("#user_id_chk")[0].title;
		var nickChk = $("#user_nick_chk")[0].title;
		var emailChk = $("#emailChk")[0].title;
		if(idTitle == "n") {
			alert("id 중복확인 처리가 되지 않았습니다.");
		}
		if(nickChk == "n") {
			alert("닉네임 중복확인 처리가 되지 않았습니다.");
		}
		if(emailChk == "n") {
			alert("메일인증이 처리되지 않았습니다.");
		}
		const userId = $("#user_id").val();	// 아이디
		const userPw = $("#user_pw").val();	// 비밀번호
		const pwChk = $("#user_pw_chk").val();	// 비밀번호 확인
		const userName = $("#user_name").val();	// 이름
		const userAge = $("#user_age").val();	// 나이
		const userNick = $("#user_nick").val();	// 닉네임
		const userEmail = $("#user_email").val();	// 이메일
		const userMember = $("#user_member").val();	// 가입구분
		const userPhone = $("#user_phone").val();	// 전화번호
		const userAddr = $("#user_addr").val();	// 주소
		const userAddrDe = $("#user_addrdetail").val(); //상세주소
		
		console.log("userId :: " + userId);
		console.log("userPw :: " + userPw);
		console.log("pwChk :: " + pwChk);
		console.log("userName :: " + userName);
		console.log("userAge :: " + userAge);
		console.log("userNick :: " + userNick);
		console.log("userEmail :: " + userEmail);
		console.log("userMember :: " + userMember);
		console.log("userPhone :: " + userPhone);
		console.log("userAddr :: " + userAddr);
		console.log("userAddrDetail :: " + userAddrDe);
		
		if(userId == null || userId == "") {
			alert("아이디가 입력되지 않았습니다.");
			$("#user_id").focus();
			return false;
		} else if(userPw == null || userPw == "") {
			alert("비밀번호가 입력되지 않았습니다.");
			$("#userPw").focus();
			return false;
		}
		
		if(userMember == "N") {
			alert("가입구분이 입력되지 않았습니다.");
			return false;
		}
		
		$.ajax({
			url: "userInsert.do",
			type: "POST",
			data: {
				user_id: userId,
				user_pw: userPw,
				user_name: userName,
				user_age: userAge,
				user_nick: userNick,
				user_email: userEmail,
				user_member: userMember,
				user_phone: userPhone,
				user_addr: userAddr,
				user_addrdetail: userAddrDe
			},
			success: function(){
				alert("만나게 되어 반갑습니다! \n 로그인 해주세요^^.");
				location.href = "loginForm.do";
			},
			error: function(){
			    alert("회원가입에 실패했습니다. \n 관리자에게 문의하세요.");
			}
		});
	} else {
		alert("약관에 동의해주세요.");
	}
}