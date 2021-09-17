$(document).ready(function() {
    $('.nail_hrt').click(function() {
       var user_id = $("#user_id").val();
        if(user_id==null||user_id==""){
        	return false;
        }
        if($(this).children().hasClass("fa-heart-o") == true) {
            $(this).children().removeClass();
            $(this).children().addClass('fa fa-heart');
        } else {
            $(this).children().removeClass();
            $(this).children().addClass('fa fa-heart-o');
        }
        
     });
});

        	function dibs(num){
        		var user_id = $("#user_id").val()
        		if(user_id==null||user_id==""){
        			alert("로그인 해주세요");
        			return false;
        		}
        		var sendData = "trip_num="+num+"&user_id="+user_id;//유저아이디 추가
        		
        		$.ajax({
        			url: "trip_dibs.do",
        			type: "POST",
        			data:sendData,
        			success: function(data){
        				if(data==1){
        					alert("찜 목록에 추가하였습니다.");
        				}else if(data==2){
        					alert("찜 목록에 추가 실패");
        				}else if(data==3){
        					alert("찜 목록에서 삭제하였습니다.");
        				}else if(data==4){
        					alert("찜 목록에서 삭제 실패");
        				}
        			},
        			error:function(){
						alert("실패");
        			}
        			
        		})
	        }