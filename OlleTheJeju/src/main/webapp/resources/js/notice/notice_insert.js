let editor_content;

$(document).ready(function() {
   // CKEditor4를 생성할 textarea 지정
   CKEDITOR.replace("editor");
});

function insert() {
   var title = $("#title").val();
   var kat = $("#kat option:selected").val();
   var content = CKEDITOR.instances.editor.getData();
   
   if(title == null || kat == null || content == null) {
      alert("입력되지 않은 input이 있음");
   } else {
      $.ajax({
         url: "notice_insert.do",
         type: "POST",
         data: {faq_title: title, faq_kat: kat, faq_content: content},
         dataType: "text",
         success: function(data){
            if(data == 1) {
               alert("성공적으로 저장.");
               location.href="notice_main.do";
            } else if(data == 0) {
               alert("저장실패");
            }
         },
         error: function(){
             alert("고객지원글 저장 실패(통신실패) \n 관리자에게 문의하세요.");
         }
      });
   }
}
