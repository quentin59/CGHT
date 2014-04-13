$(document).ready(function() {
	
	$("#formParametres").submit(function(event){
		
		var newmail = $("#newmail").val();
		var newmail2 = $("#newmail2").val();
		if (newmail!=newmail2)
			{
			$("#erreurMail").slideDown();
			event.preventDefault();
			}
		var newmdp = $("#newmdp").val();
		var newmdp2 = $("#newmdp2").val();
		if (newmdp!=newmdp2)
			{
			$("#erreurPassword").slideDown();
			event.preventDefault();
			}
	});
	
});