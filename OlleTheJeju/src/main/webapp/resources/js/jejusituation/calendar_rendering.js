var target=document.querySelector("#calendar");
var chk=document.querySelectorAll(".time");
var counter=document.querySelector("#cnt");

var res=0;//선택시간
var day;//선택일자
var regCnt=0;//선택인원

//이름
var u_name;
var nameIn=document.getElementsByName("name")[0];
//연락처
var u_tel;
var telIn=document.getElementsByName("phone")[0];
//이메일
var u_email;
var eIn=document.getElementsByName("email")[0];
//요청사항
var u_req;
var rIn=document.getElementsByName("require")[0];

var json;//json
var jsonUser;//예약자 정보

//확인구간
var preChk=document.querySelector(".bottom-reseved-check");

//시간 확인
function checkBtn(e){

    for(var i=0; i < chk.length;i++){
        console.log(chk[i]);
        if(chk[i]===e){
            res=chk[i].value;
            chk[i].style.bgColor="#fd79a8";
            break;
        }
    }
    return res;//선택한 시간값
}

//인원감소
function decCnt(){
  var temp=counter.value;

  if(temp<=0){
    counter.value=0;
    alert("선택하신 입력은 0명입니다");
  }else{
    counter.value--;
  }
}

//인원 증가
function incCnt(){
  var temp=counter.value;

  if(temp>=4){
     counter.value=4;
     alert('코로나로 인하여 4명 이하만 예약하실 수 있습니다');
  }else{
    counter.value++;
  }
}

//인원정보
function getCounter(){
  var temp=counter.value;
  console.log("인원: "+temp);
  return temp;
}

//예약자 정보
function personalInfo(){
  u_name=nameIn.value;
  u_req=rIn.value;
  u_email=eIn.value;
  u_tel=telIn.value;
}

//날짜확인+달력그리기
//모든 정보를 json 형태로 만들어두기
document.addEventListener('DOMContentLoaded', function() {
   // var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(target, {
      initialView: 'dayGridMonth',
      dateClick:function(info){
        day=info.dateStr;//날짜
        console.log("clicked: "+day);
    }
    });
    calendar.render();

  });

  document.addEventListener("change",function(e){
    
    //사용자 정보받기
    personalInfo();
    regCnt=getCounter();//인원수
    //사용자
    jsonUser={
      name:u_name,
      email:u_email,
      phone:u_tel,
      require:u_req
    };
    //전체 json
    json={
      user:jsonUser,
      date:day,
      time:res,
      cnt:regCnt
    };
    preChk.innerHTML=`${u_name}님, ${day} ${res}에 ${regCnt}명을 예약하시겠습니까?`;
    console.log("이용자: ",jsonUser);
    console.log("전체 요청: ",json);
  });