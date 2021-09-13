$(function(){
        		var p = $("#page").val();
        			page(p);
       		 });
        	
     	   	function page(p){
     	   		$(".page").empty();
     	   		
     	   		if((p%10)==0){ 
     	   			var i=p-9;
     	   		}else if((p%10)>=1){
     	   			var i = (Math.floor(p/10)*10)+1;
     	   		}
     	   		var j = i+10;
     	   		
    			for(i; i<j; i++){
    				if(i>716&&p!=999){//716 마지막페이지
    					break;
    				}else if(i==p){
    					$(".page").append("<a style='margin:3px; text-decoration:underline !important;'>"+i+"</a>");
    				}else if(p==999){
    	     	   		$(".page").append("<a style='margin:3px; text-decoration:underline !important;'>1</a>");
    	     	   		break;
    				}else{
    					$(".page").append("<a style='margin:3px;' href='trip_jeju_page.do?page="+i+"'>"+i+"</a>");
    				}
    			}	
        	}
     	   	
     	   	function prev(){
     	   		var p = $("#page").val();
     	   		if(p>10&&p!=999){
     		   		var first = parseInt($(".page").children('a:eq(0)').text())-1;
 	  	 			window.location.href= 'trip_jeju_page.do?page='+first;
     	   		}else{
     	   			alert("첫번째 페이지 입니다.");
     	   		}
     	   	}
     	   	
     	   	function next(){
     	   		var p = $("#page").val();
     	   		if(p<711){
     		   		var last = parseInt($(".page").children('a:eq(9)').text())+1;
 	  	 			window.location.href= 'trip_jeju_page.do?page='+last;
     	   		}else{
     	   			alert("마지막 페이지 입니다.");
     	   		}
     	   	}
     	   	function search(){
     	   		var search = $("#search").val();
     	   		location.href='trip_jeju_search.do?search='+search;
     	   		
     	   	}