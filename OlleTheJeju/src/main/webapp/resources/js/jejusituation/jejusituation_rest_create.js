var previewImg=document.querySelector(".preview-target");

function previewImage(input){
    //파일이 존재하는 경우에만 진행
    if(input.files && input.files[0]){
        console.log("in");
        var reader=new FileReader();

        reader.onload=function(e){
            previewImg.src=e.target.result;
        };

        reader.readAsDataURL(input.files[0]);

    }else{
        previewImg.src="";
    }


}