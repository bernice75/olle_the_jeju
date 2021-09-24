function pushPlan(obj) {
	if($(obj).children().hasClass("fa-heart-o") == true) {
        $(obj).children().removeClass();
        $(obj).children().addClass('fa fa-heart');
        
        var plan_num = $(".plan_num").val();
        
        $.ajax({
		url: "customplan_push.do",
		type: "POST",
		data: {plan_num: plan_num},
		dataType: "text",
		success: function(data){
			console.log(data);
			if(data == "true") {
				alert("해당 게시물을 추천했습니다.");
				location.reload();
			} else {
				alert("게시물을 추천하지 못했습니다.");
			}
		},
		error: function(){
		    alert("추천할 수 없습니다. \n 관리자에게 문의하세요.");
		}
	});
    } else {
        $(obj).children().removeClass();
        $(obj).children().addClass('fa fa-heart-o');
    }
}

function noDib() {
	alert("로그인해야 이용할 수 있습니다.");
}

function dibPlan() {
	var user_id = $(".user_id").val();
	var plan_num = $(".plan_num").val();
	var plan_writer = $(".plan_writer").val();
	
	if(user_id == plan_writer) {
		alert("본인이 작성한 게시물은 찜할 수 없습니다.");
	} else {
		$.ajax({
			url: "dib_insert.do",
			type: "POST",
			data: {user_id: user_id, plan_num: plan_num},
			dataType: "text",
			success: function(data){
				console.log(data);
				if(data != null || data != "") {
					if(data == "true") {
						alert("해당 게시물을 찜했습니다.");
						location.reload();
					} else if(data == "already") {
						alert("이미 찜한 게시물입니다.");
					} else {
						alert("찜하지 못했습니다.");
					}
					
				} else {
					alert("게시물을 찜하지 못했습니다.");
				}
			},
			error: function(){
			    alert("찜할 수 없습니다. \n 관리자에게 문의하세요.");
			}
		});
	}
}

//신고접수
function report() {
	var user_id = $("#user_id").val();
	var plan_num = $("#plan_num").val();
	var rep_user = $("#rep_user").val();
	var report_reson = $("#report_reson").val();
	
	if(confirm("신고 하시겠습니까?")) {
		$.ajax({
			url: "reportInsert.do",
			type: "POST",
			data: {user_id: user_id, plan_num: plan_num, rep_user: rep_user, report_reson: report_reson},
			dataType: "text",
			success: function(data){
				console.log(data);
				if(data != null || data != "") {
					if(data == "true") {
						alert("해당 게시물 신고했습니다.");
						location.reload();
					} else if(data == "already") {
						alert("이미 신고한 게시물입니다.");
					} else {
						alert("신고하지 못했습니다.");
					}
					
				} else {
					alert("게시물을 신고하지 못했습니다.");
				}
			},
			error: function(){
			    alert("게시물을 신고 할 수 없습니다. \n 관리자에게 문의하세요.");
			}
		});
	}
}