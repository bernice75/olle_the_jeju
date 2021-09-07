$(document).ready(function() {
    $('.like').click(function() {
        if($(this).children().hasClass("fa-heart-o") == true) {
            $(this).children().removeClass();
            $(this).children().addClass('fa fa-heart');
        } else {
            $(this).children().removeClass();
            $(this).children().addClass('fa fa-heart-o');
        }
     });
});