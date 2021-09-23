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