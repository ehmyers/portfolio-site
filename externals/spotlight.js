/* globals: $ */
var $ = window.$,
    jQuery = window.jQuery;

function showLightbox(id) {
    "use strict";
    var selector = '#' + id + '-lightbox';
    console.log(selector);
    $('.lightbox').hide();
    $(selector).fadeIn();
}

function closeLightbox() {
    "use strict";
    $('.lightbox').fadeOut();
}

function spotlightShow(id) {
    "use strict";
    console.log("Showing " + id);
    $(".spotlight").children().hide();
    $("#" + id).fadeIn();
}

$(document).ready(function () {
    "use strict";
    $(".side_menu li img").click(function () {
        // getting the alt tag
        var id = $(this).attr("alt");
        spotlightShow(id);
    });

    // on click, change active menu
    $("nav li").click(function () {
        var active_menu = $(this).children("a").attr("data-menuid"),
            first_item = $(active_menu + " ul").children(":first-child");
        //
        $(".spotlight").children().hide();
        $("#launchpad").fadeOut();
        $(".spotlight").fadeIn();
        //
        // swaps out menus
        $(".side_menu").hide();
        $(active_menu).fadeIn();
        //
        // displays the first item in the clicked section
        first_item.find("img").click();
    });

    // when an image in the launchpad is clicked...
    $("#launchpad img").click(function () {
        var content = $(this).parent().attr("data-content"),
            sidemenu = $("#" + content).attr("data-menu");
        $("#" + sidemenu).fadeOut();
        $("#" + sidemenu).addClass("active");
        $("#launchpad").fadeOut();
        $(".spotlight").fadeIn();
        spotlightShow(content);
    });

    // fades everything out and the launchpad back in
    $("#logo img").click(function () {
        $(".spotlight").fadeOut();
        $(".side_menu").hide();
        $("#launchpad").fadeIn();
    });

});