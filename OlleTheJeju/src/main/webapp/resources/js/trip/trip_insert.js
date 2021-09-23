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