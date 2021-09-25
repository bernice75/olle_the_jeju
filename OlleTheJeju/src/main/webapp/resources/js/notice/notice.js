$(document).ready(function() {
	$(".accordion-header").on('click', function() {
		if($(this).children().hasClass("collapsed")) {
			$(this).children().removeClass("collapsed");
			//$(this).next().addClass("show");
			$(this).next().slideDown();
		} else {
			$(this).children().addClass("collapsed");
			//$(this).next().removeClass("show");
			$(this).next().slideUp();
		}
		
	});
})

function showUpdate(obj) {
	$(obj).next().next().attr("style", "display:block");
	$(obj).next().next().children('textarea').attr("id", "editor");
	CKEDITOR.replace("editor");
}

function hideUpdate(obj) {
	$(obj).parent().children('textarea').attr("id", "");
	$(obj).parent().attr("style", "display:none");
}


function updateFaq(obj) {
	var faq_num = $(obj).parent().children('input[name=faq_num]').val();
	var faq_title = $(obj).parent().children('input[name=faq_title]').val();
	var faq_content = CKEDITOR.instances.editor.getData();
	
	$.ajax({
	     url: "notice_update.do",
	     type: "POST",
	     data: {faq_num: faq_num, faq_title: faq_title, faq_content: faq_content},
	     dataType: "text",
	     success: function(data){
	        if(data == "true") {
	           alert("성공적으로 수정하였습니다.");
	           location.href="notice_main.do";
	        } else if(data == "false") {
	           alert("저장실패");
	        }
	     },
	     error: function(){
	         alert("고객지원글 저장 실패(통신실패) \n 관리자에게 문의하세요.");
	     }
	  });
}

function deleteFaq(faq_num) {
	if(confirm("해당 글을 삭제하시겠습니까?")) {
		$.ajax({
		     url: "notice_delete.do",
		     type: "POST",
		     data: {faq_num: faq_num},
		     dataType: "text",
		     success: function(data){
		        if(data == "true") {
		           alert("성공적으로 삭제하였습니다.");
		           location.href="notice_main.do";
		        } else if(data == "false") {
		           alert("삭제실패");
		        }
		     },
		     error: function(){
		         alert("고객지원글 삭제 실패(통신실패) \n 관리자에게 문의하세요.");
		     }
	   });
	}
}