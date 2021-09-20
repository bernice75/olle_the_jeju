var myModal=document.querySelector(".my-modal");
var myModal2=document.querySelector(".my-modal2");
var clCnt=0;

function openModal(jeju){
    myModal.style.display="flex";
    document.querySelector(".my-modal").children[1].src="jejusituation_rest_detail.do?situ_num="+jeju;
}

function closeModal(){
    myModal.style.display="none";
   // clCnt++;
    history.back();
}

function openModal2(){
	myModal2.style.display="flex";
}

function closeModal2(){
    myModal2.style.display="none";
  //  history.go(-1);
}