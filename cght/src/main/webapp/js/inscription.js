$(document).ready(function() {
	
	$("#inscription").submit(function(event) {
		var licence = $("#licence").val();
		var licence1 = licence.substring(0,7);
		var licence2 = licence.substring(7);
		var regex = new RegExp(/([A-Za-z])/);
		if (licence.length!=8 || isNaN(licence1) || !regex.test(licence2))
			{
			$(".licenceIncorrecte").slideDown();
			event.preventDefault();
			}
		});
});