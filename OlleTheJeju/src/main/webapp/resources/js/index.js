$(document).ready(function() {
    var $typing = $(".main-img-text");
    var text = "여행의 시작\nOLLE THE JEJU에서";
    $typing.html(""); // #typing 요소의 내부 문자 제거

    // #typing 요소의 내부 문자를 한 글자씩 잘라 배열에 저장
    // → String 객체의 split 메서드
    var chars = text.split("");

    // 배열 chars의 각 문자들을 내부 문자로 갖는 span 요소를 생성해 #typing 요소에 추가
    // → Array 객체의 forEach 메서드
    chars.forEach(function (item) {
        // 문자가 빈칸인 경우에는 HTML 엔티티로 변환
        item = (item == " ") ? "&nbsp" : ((item == "\n") ? "<br>" : item);

        $("<span></span>").html(item).appendTo($typing);
    });

    // 캐럿 추가
    var $caret = $("<span></span>").attr("id", "caret").css({
        width: "5px",
    }).appendTo($typing);

    // 글자를 표시하기 전의 지연 시간(ms)
    var delayStart = 1500;

    // 타이핑 속도(ms)
    var speed = 200;

    // 글자들을 보이지 않게 설정한 다음 한 글자씩 화면에 표시
    $typing.children(":not(#caret)").hide().each(function (index) {
        var delay = delayStart + speed * index;

        $(this).delay(delay).show(10);
    });
});

//메인 이미지 슬라이드 시작
var slideIndex = 0;
            
function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
//메인 이미지 슬라이드 끝

// 중앙 멀티슬라이드 js 시작
$(document).ready(function() {
    var slides2 = document.querySelector('.slides'), //left 값을 지정하는 용도?
        slide = document.querySelectorAll('.slides li'), //총 요소 개수
        currentIdx = 0, //순서 지정 -> 시작
        slideCount = slide.length, //순서 지정 -> 마지막
        prevBtn = document.querySelector('.prev'),
        slideWidth = 200,
        slideMargin = 20,
        nextBtn = document.querySelector('.next');
    
    //요소들을 감싸고 있는 부모의 너비
    slides2.style.width = (slideWidth + slideMargin)*slideCount - slideMargin + 20 + 'px';
    
    function moveSlide(num){
        slides2.style.left = -num * 220 + 'px';
        currentIdx = num;
    }
    nextBtn.addEventListener('click', function(){
        if(currentIdx < slideCount - 5){
            moveSlide(currentIdx + 1);
            console.log(currentIdx);
        }else{
            moveSlide(0);
        }
    });
    prevBtn.addEventListener('click', function(){
        if(currentIdx > 0){
            moveSlide(currentIdx - 1);
            console.log(currentIdx);
        }else{
            moveSlide(0);
        }
    });
});
// 중앙 멀티슬라이드 js 끝