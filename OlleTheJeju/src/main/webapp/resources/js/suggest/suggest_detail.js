function good(){
    var s = document.getElementById('smile').getAttribute('value');
    if(s==0){
        document.getElementById('smile').setAttribute('class','fa fa-smile-o fa-2x');
        document.getElementById('smile').setAttribute('value','1');
    }else{
        document.getElementById('smile').setAttribute('class','fa fa-meh-o fa-2x');
        document.getElementById('smile').setAttribute('value','0');
    }
}

         	var push=1;
        	function like(){
        		if(push==0){
        			alert("이미 추천하셨습니다.");
        		}else{
        			var sug_num = $("#sug_num").val();
        			$.ajax({
        				url:"suggest_update_like.do?sug_num="+sug_num,
        				type:"GET",
        				success: function(){
        					push=0;
        					$("#push").attr("class","fa fa-heart");
        					var text = $("#text").text();
        					var nText = parseInt(text);
        					console.log(text);
        					console.log(nText);
        					nText = nText+1;
        					console.log(nText);
        					$("#text").text(nText);
        				}
        			})
        		}
        	}
        
        function changeList(obj){
            var class_name = $(obj).attr('class'); //클래스명 저장
            class_name = class_name.split(' ')[2];
            
            var date = $(obj).text(); //내용 저장
            
            $(obj).siblings().attr('disabled', false); //나를 제외한 형제들 활성화

            //map_list 클래스를 가진 div가 있는가
            if($('div').hasClass("map_list") == true) {
                //이미 존재하는 map_list 중 버튼과 동일한 클래스를 가진 것이 있는가
                if($('.map_list').hasClass(class_name) == true) {
                	$('.map_list.'+class_name).siblings("div[name=map_show]").attr('name','map_list');
                    $('.map_list.'+class_name).siblings("div[name=map_list]").hide();
                    $('.map_list.'+class_name).show();
                    $('.map_list.'+class_name).attr('name','map_show');
                    mapMaker(class_name);
                } else {
                    $('.map_list').hide();
                    var map_list = document.createElement('div'); //일정목록을 감싸는 div
                    map_list.setAttribute('class', 'map_list ' + class_name);
                    map_list.setAttribute('name','map_show');
                    $('.main-second').append(map_list);
                    $('.map_list.'+class_name).siblings("div[name=map_show]").attr('name','map_list');
                    //div 클래스 중 버튼과 동일한 클래스인 경우에만 글 삽입
                    if($('.map_list.'+class_name).children().length == 0) {
                        var br = document.createElement('br');
                        var h5 = document.createElement('h5'); //n일차 지도리스트
                        var ta = document.createElement('textarea');
                        h5.setAttribute('name',class_name);
                        ta.setAttribute('name','sug_addr');
                        ta.style.display='none';
                        ta.innerHTML = "일수";
                        h5.innerHTML = date + " 지도리스트";
                        $('.map_list.'+class_name).append(h5);
                        $('.map_list.'+class_name).append(ta);
                        mapMaker(class_name);
                        
                    }
                }
            } else {
                var map_list = document.createElement('div'); //일정목록을 감싸는 div
                map_list.setAttribute('class', 'map_list ' + class_name);
                map_list.setAttribute('name','map_show');
                var br = document.createElement('br');
                var h5 = document.createElement('h5'); //n일차 지도리스트
                var ta = document.createElement('textarea');
                h5.setAttribute('name',class_name);
                ta.style.display='none';
                ta.setAttribute('name','sug_addr');
                h5.innerHTML = date + " 지도리스트";
                $('.main-second').append(map_list);
                $('.map_list').append(h5);
                $('.map_list').append(ta);
               	mapMaker(class_name);
         }
        }   
        
     