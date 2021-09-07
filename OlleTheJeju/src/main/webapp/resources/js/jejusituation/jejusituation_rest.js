var myModal=document.querySelector(".my-modal");
var myModal2=document.querySelector(".my-modal2");

function openModal(){
    myModal.style.display="flex";
}

function closeModal(){
    myModal.style.display="none";
    history.go(-1);
}

function openModal2(){
    myModal2.style.display="flex";
}

function closeModal2(){
    myModal2.style.display="none";
    history.go(-1);
}