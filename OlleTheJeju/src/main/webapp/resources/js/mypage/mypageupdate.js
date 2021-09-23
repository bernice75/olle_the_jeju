// 맨 상단 프로플 사진 첨부 미리보기 기능 시작
 function previewImage(targetObj, previewId) {
	 var preview = document.getElementById(previewId);  //div id   
	 var ua = window.navigator.userAgent; 
	 
	 if (ua.indexOf("MSIE") > -1) {  //ie일때
		 targetObj.select(); 
	 
	 try { var src = document.selection.createRange().text;   // get file full path 
	 var ie_preview_error = document .getElementById("ie_preview_error_" + previewId); 
	 
	 if (ie_preview_error) { preview.removeChild(ie_preview_error);   //error가 있으면 delete
	 } 
	 
	 var img = document.getElementById(previewId);    //이미지가 뿌려질 곳 
	 img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src + "', sizingMethod='scale')";
	 //이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
	
	 } catch (e) {
		 if (!document.getElementById("ie_preview_error_" + previewId)) { 
			 var info = document.createElement("<p>");
			 info.id = "ie_preview_error_" + previewId;
			 info.innerHTML = "a"; preview.insertBefore(info, null);
			 }
		 }
	 } else {   //ie가 아닐때
		 var files = targetObj.files;
	 for ( var i = 0; i < files.length; i++) { 
		
		 var file = files[i];
		 
		 var imageType = /image.*/;    //이미지 파일일경우만.. 뿌려준다.
		 if (!file.type.match(imageType)) 
			 continue; 
		 
		 var prevImg = document.getElementById("prev_" + previewId);      //이전에 미리보기가 있다면 삭제
		 if (prevImg) {
			 preview.removeChild(prevImg);
			 }
		 
		 var img = document.createElement("img"); //크롬은 div에 이미지가 뿌려지지 않는다. 그래서 자식Element를 만든다
		 img.id = "prev_" + previewId;
		 img.classList.add("obj");
		 img.file = file; 
		 img.style.width = '100px';      //기본설정된 div의 안에 뿌려지는 효과를 주기 위해서 div크기와 같은 크기를 지정해준다
		 img.style.height = '100px';
		 img.style.borderRadius = '70%';
		 preview.appendChild(img); 
		 
		 if (window.FileReader) { 
		 var reader = new FileReader();
		 reader.onloadend = (function(aImg) {
			 return function(e) {
				 aImg.src = e.target.result;
				 };
				 })(img);
		 reader.readAsDataURL(file);
		 } else { 		 
		 if (!document.getElementById("sfr_preview_error_" + previewId)) {
			 var info = document.createElement("p");
			 info.id = "sfr_preview_error_" + previewId;
			 info.innerHTML = "not supported FileReader";
			 preview.insertBefore(info, null);
			 }
		 }
		 }
	 }
	 }
// 맨 상단 프로플 사진 첨부 미리보기 기능 끝

//주소 API (다음)
function addressForm() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수 

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}
			//주소정보를 해당 필드에 넣는다.
			document.getElementById("address1").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("address2").focus();
		}
	}).open();
}

//회원정보 수정 - 기존 비밀번호 확인
function pwChkForm() {
	var pw = $("#password").val();
	var newPw = $("#newpassword").val();
	var addrdetail = $("#address2").val();
	var user_id = $("#id").val();
	
	if(pw == newPw) {
		alert("기존과 같은 비밀번호는 사용할 수 없습니다.");
		$("#newpassword").focus();
	} else {
		alert("새로운 비밀번호를 입력하셨습니다.");
		$.ajax({
			url: "userUpdate.do",
			type: "POST",
			data: {user_pw:pw, user_newpw:newPw, user_addrdetail:addrdetail},
			dataType: "text",
			success: function(data) {
				if(data > 0) {
					console.log(data);
					
					alert("성공적으로 변경되었습니다.");
					location.href="mypage_main.do?user_id=" + user_id;
				} else {
					alert("변경에 오류가 있습니다.");
				}
			},
			error: function(){
			    alert("비밀번호 수정에 실패했습니다. \n 관리자에게 문의하세요.");
			    location.href="mypage_main.do";
			}
		});
	}
}


//회원정보 수정
/*$(document).ready(function(){
	$("#updateCheck").click(function(){
		if(confirm("수정하시겠습니까?")){
			document.mypage_form.action="${path}/user/updateUser.do";
			document.mypage_form.submit();
		}
	});
});*/

//회원탈퇴
function userDelete() {
	var user_id = $("#id").val();
	var user_pw = $("#leave-pw").val();
	
	if(confirm("삭제하시겠습니까?")){
		$.ajax({
			url: "deleteUser.do",
			type: "POST",
			data: {user_id: user_id, user_pw: user_pw},
			dataType: "text",
			success: function(data){
				console.log(data);
				if(data == 1) {
					alert("탈퇴 되었습니다. 바이바이.");
					location.href="home.do";
				} else if(data == 0) {
					alert("비밀번호가 틀렸네? 아직 못 간다.");
				}
			},
			error: function(){
			    alert("회원탈퇴 실패입니다. \n 관리자에게 문의하세요.");
			}
		});
	}
}