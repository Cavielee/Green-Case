// 左右滑动
$(function() {
	var myElement = document.getElementById('Carousel')
	var hm = new Hammer(myElement);
	hm.on("swipeleft", function() {
		$('#Carousel').carousel('next')
	})
	hm.on("swiperight", function() {
		$('#Carousel').carousel('prev')
	})
})