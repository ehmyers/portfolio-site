/* globals: $ */
"use strict";
var $ = window.$,
    jQuery = window.jQuery;

$(document).ready(function () {
    window.onresize = function () {
        // getting currrent size of animation
        var currentWidth = document.getElementById("size").getAttribute("width");
        var currentHeight = document.getElementById("size").getAttribute("height");
        console.log("This is the current animation width: " + currentWidth);
        console.log("This is the current animation height: " + currentHeight);
        // getting current size of window
        var windowWidth = $(document).width();
        var windowHeight = $(document).height();
        console.log("This is the current window width: " + windowWidth);
        console.log("This is the current window height: " + windowHeight);
        // setting new animation width
        //document.getElementById("size").setAttribute("width", windowWidth);
        document.getElementById("size").style.height = windowHeight - 100 + "px";
        document.getElementById("size").setAttribute("height", windowHeight);
        var newWindowWidth = document.getElementById("size").getAttribute("width");
        var newWindowHeight = document.getElementById("size").getAttribute("height");
        console.log("This is the new animation width: " + newWindowWidth);
        console.log("This is the new animation width: " + newWindowHeight);
    };
});