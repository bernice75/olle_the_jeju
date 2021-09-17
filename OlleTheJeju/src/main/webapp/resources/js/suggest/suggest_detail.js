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
        			alert("이미 추천하셨습니다.")
        		}else{
        			var sug_num = $("#sug_num").val();
        			$.ajax({
        				url:"sug_update_like.do?sug_num="+sug_num,
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