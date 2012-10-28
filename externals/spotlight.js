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
		
		var active_menu = $(this).children("a").attr("data-menuid"); // swaps out menus
		$(".side_menu").hide();
		$(active_menu).fadeIn();

		var first_item = $(active_menu + " ul").children(":first-child");
		first_item.find("img").click();
	});

	$("#launchpad img").click(function() {
		var content = $(this).parent().attr("data-content");
		var sidemenu = $("#" + content).attr("data-menu");
		$("#" + sidemenu).fadeOut();
		$("#" + sidemenu).addClass("active");
		$("#launchpad").fadeOut();
		$(".spotlight").fadeIn();
		spotlightShow(content);
	});

});

function showLightbox(id) {
	var selector = '#' + id + '-lightbox';
	console.log(selector);
	$('.lightbox').hide();
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