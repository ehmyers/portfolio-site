$(document).ready(function() {
	$(".side_menu li img").click(function() {
		// getting the alt tag
		var id = $(this).attr("alt");
		spotlightShow(id);
	});

	$("nav li").click(function() { // on click, change active menu
		$(".spotlight").children().hide();
		$("#launchpad").fadeOut();
		$(".spotlight").fadeIn();
		
		var active_menu = $(this).children("a").attr("data-menuid");
		$(".active").removeClass("active");
		$(active_menu).addClass("active");
	});

	$("#launchpad img").click(function() {
		var content = $(this).parent().attr("data-content");
		var sidemenu = $("#" + content).attr("data-menu");
		$("#" + sidemenu).fadeIn();
		$("#" + sidemenu).addClass("active");
		$("#launchpad").fadeOut();
		$(".spotlight").fadeIn();
		spotlightShow(content);
	});

});

function showLightbox(id) {
	var selector = '#' + id + '-lightbox';
	console.log(selector);
	$('.lighbox').hide();
	$(selector).fadeIn();
}

function closeLightbox() {
	$('.lightbox').fadeOut();
}

function spotlightShow(id) {
	console.log("Showing " + id);
	$(".spotlight").children().hide();
	$("#" + id).fadeIn();
}

// window.onresize(function() {
	// get window height
	// get flash height
	// get header height
	// if window height is < flash height + header height,
	// 		set flash height to window height - header height
// });