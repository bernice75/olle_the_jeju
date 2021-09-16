function fileUpload(){
	var fileInput = document.getElementsByClassName("insert-btn");

	for( var i=0; i < fileInput.length; i++ ){
		if( fileInput[i].files.length > 0 ){
			for( var j = 0; j < fileInput[i].files.length; j++ ){
				console.log(fileInput[i].files[j].name); // 파일명 출력
				var ext = fileInput[i].files[j].name.split(".")[1].toLowerCase(); //확장자 추출 후 소문자로 변경
				if($.inArray(ext, ['bmp' , 'jpg', 'png', 'jpeg', 'gif']) == -1) {
					alert("이미지 파일을 선택해주세요.");
					return false;
				}
			}
		}
	}
}

function imgChk() {
	var fileInput = document.getElementsByClassName("insert-btn");

    if(fileInput[0].files.length == 0 || fileInput[1].files.length == 0 || fileInput[2].files.length == 0) {
        alert("이미지 3가지를 모두 선택해주세요.");
        return false;
    } else {
        alert("3가지 이미지를 모두 선택하셨습니다.");
        var file = fileInput[0].files;
        var reader = new FileReader();
        reader.onload = function (e) {
            $('.d-block').eq(0).attr('src', e.target.result);
        }
        reader.readAsDataURL(file[0]);

        file = fileInput[1].files;
        reader = new FileReader();
        reader.onload = function (e) {
            $('.d-block').eq(1).attr('src', e.target.result);
        }
        reader.readAsDataURL(file[0]);

        file = fileInput[2].files;
        reader = new FileReader();
        reader.onload = function (e) {
            $('.d-block').eq(2).attr('src', e.target.result);
        }
        reader.readAsDataURL(file[0]);
    }
}

function date() {
	var start = $('.plan_term_start').val() instanceof Date ? $('.plan_term_start').val() : new Date($('.plan_term_start').val());
	var end = $('.plan_term_end').val() instanceof Date ? $('.plan_term_end').val() : new Date($('.plan_term_end').val());

	//alert(start+", "+end);

	start = new Date(start.getFullYear(), start.getMonth() + 1, start.getDate());
	end = new Date(end.getFullYear(), end.getMonth() + 1, end.getDate());

	var diff = Math.abs(end.getTime() - start.getTime());
	diff = Math.ceil(diff / (1000 * 3600 * 24));

	console.log(diff + "일차");

    for(var i = 0; i < (diff + 1); i++) {
        var button = document.createElement('button');
        button.setAttribute('class', 'btn btn-outline-dark ' + (start.getDate() + i) + " " + (i+1));
        button.setAttribute('type', 'button');
        button.setAttribute('onclick', 'createList(this);');
        var btnText = document.createTextNode((i + 1) + "일차");
        button.appendChild(btnText);
        $('.day-btn').append(button);
    }
}

function createList(obj) {
    var class_name = $(obj).attr('class'); //클래스명 저장
    class_name = class_name.split(' ')[2];
    console.log(class_name);
    var date = $(obj).text(); //내용 저장
    console.log(date);
    $(obj).siblings().attr('disabled', false); //나를 제외한 형제들 활성화

    //map_list 클래스를 가진 div가 있는가
    if($('div').hasClass("map_list") == true) {
        //이미 존재하는 map_list 중 버튼과 동일한 클래스를 가진 것이 있는가
        if($('.map_list').hasClass(class_name) == true) {
            $('.map_list.'+class_name).siblings().hide();
            $('.map_list.'+class_name).show();
        } else {
            $('.map_list').hide();
            var map_list = document.createElement('div'); //일정목록을 감싸는 div
            map_list.setAttribute('class', 'map_list ' + class_name);
            $("#map_div > div").append(map_list);
            //div 클래스 중 버튼과 동일한 클래스인 경우에만 글 삽입
            if($('.map_list.'+class_name).children().length == 0) {
                var br = document.createElement('br');
                var h5 = document.createElement('h5'); //n일차 지도리스트
                h5.innerHTML = date + " 지도리스트";
                $('.map_list.'+class_name).append(br);
                $('.map_list.'+class_name).append(h5);
            }
        }
    } else {
        var map_list = document.createElement('div'); //일정목록을 감싸는 div
        map_list.setAttribute('class', 'map_list ' + class_name);
        var br = document.createElement('br');
        var h5 = document.createElement('h5'); //n일차 지도리스트
        h5.innerHTML = date + " 지도리스트";
        $('.main-map').append(map_list);
        $('.map_list').append(br);
        $('.map_list').append(h5);
    }
    
    //이건 마커에서 장소 추가를 눌렀을 때 나오게하면 될듯
    var list = document.createElement('div'); //장소 정보를 담을 div
    var list_nail = document.createElement('div'); //해당 장소의 썸네일을 담을 div
    var list_inner = document.createElement('div'); //해당 장소 정보 담을 div
    var course_name = document.createElement('p'); //장소명
    var distance = document.createElement('p'); //위치(주소)
    var phone = document.createElement('p'); //연락처
    var taxi = document.createElement('p'); //장소 설명

    $(obj).attr('disabled', true);
}

function hash() {
	var hash = $('#hashtag').val().replace(" ", ""); //해시태그 적은 값 받아오기
	var text = $(".hashtag").val();
	if(text == '') {
		//hidden input에 값이 없을 경우 바로 넣어주면 된다.
		$(".hashtag").val(hash);
	} else {
		//hidden input에 값이 있을 경우 합쳐서 넣어주면 된다.
		$(".hashtag").val('');
		var new_text = text + "," + hash;
		$(".hashtag").val(new_text);
	}
	$('#hashtag').val(''); //적었던 값 삭제
	var arr = []; //각각의 해시태그를 저장할 배열 생성
	arr = $(".hashtag").val().split(","); //적은 값을 나눠 배열에 저장
	
	if($(".hash_inner").children().length > 0) {
		//해시태그 컨테이너에 이미 존재하는 요소가 있는지 보고 있으면 모두 삭제
		$(".hash_inner").children().remove();
	}
	
	for(var i = 0; i < arr.length; i++) {
		var tag = document.createElement('div');
		tag.setAttribute('class', 'tag ' + (i + 1));
		var button = document.createElement('button');
		button.setAttribute('class', 'button ' + (i + 1));
		button.setAttribute('type', 'button');
		button.setAttribute('onclick', 'deleteTag(this);');
		$(".hash_inner").append(tag);
		$('.tag.' + (i + 1)).text('#' + arr[i]);
		$('.tag.' + (i + 1)).append(button);
		$('.button.' + (i + 1)).text('x');
	}
}

function deleteTag(obj) {
	var text = $(obj).parent().text().substring(1, $(obj).parent().text().indexOf('x'));
    var arr = [];
    arr = $(".hashtag").val().split(",");
    
    var filterArr = arr.filter((element) => element !== text);
    $(".hashtag").val(filterArr);
    
 	$(obj).parent().remove();
}