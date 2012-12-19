$(document).ready(function() {
	// getting currrent size of animation
	var currentSize = document.getElementById("size").getAttribute("width");
	console.log("This is the current animation width: " + currentSize);
	// getting current size of window
	var windowSize = $(document).width();
	console.log("This is the current window width: " + windowSize);
	// setting new animation width
	document.getElementById("size").setAttribute("width", windowSize);
	var newWindowSize = document.getElementById("size").getAttribute("width");
	console.log("This is the new animation width: " + newWindowSize);
});