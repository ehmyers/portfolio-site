$(document).ready(function(){
	$("a").click(function(){
		swap_background();
	});

	$(".small_menu a").click(function(){
		// showing the content clicked on
		$("active").hide();
		var active_content = $(this).attr("menu-item");
		console.log("active content " + active_content);
		$(".info_box").hide();
		$("#" + active_content).show();
		//$(".info_box").css("display", "block");
	});

	swap_background();
	changing_active_menu();

	$(".small_menu li:first-child a").click()
});

/* function time! */

function swap_background(){
	// changing the background image on click
	var randomnumber = Math.ceil(Math.random()*10);
	if(randomnumber < 10) {
		var url = "url('images/rotatable_bkds/surrealist_0" + randomnumber;
	}
	else {
		var url = "url('images/rotatable_bkds/surrealist_" + randomnumber;
	}

	$("#background").css("background-image", url + ".jpg')");
	$("#midground").css("background-image", url + "a.png')");
	$("#foreground").css("background-image", url + "b.png')");
}

function changing_active_menu(){
	//changing the active menu item
	$(".small_menu a").click(function() {
		$(".small_menu a.active").removeClass("active");
		$(this).addClass("active");
	 });
}

function showLightbox(id) {
	var selector = '#' + id + '-lightbox';
	console.log(selector);
	$('.lighbox').hide();
	$(selector).fadeIn();
}

function closeLightbox() {
	$('.lightbox').fadeOut();
}

//function swap_favicon(){
	// swapping favicons
	//	var secondrandom = Math.ceil(Math.random()*8);
	//	var url = "url('images/favicons/favicon" + secondrandom + ".ico");
//}