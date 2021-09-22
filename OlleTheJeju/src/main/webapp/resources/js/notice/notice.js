$(document).ready(function() {
	$(".accordion-header").on('click', function() {
		if($(this).children().hasClass("collapsed")) {
			$(this).children().removeClass("collapsed");
			$(this).next().addClass("show");
		} else {
			$(this).children().addClass("collapsed");
			$(this).next().removeClass("show");
		}
		
	});
})